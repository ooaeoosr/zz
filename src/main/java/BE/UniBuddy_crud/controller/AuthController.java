//package BE.UniBuddy_crud.controller;
//
//import BE.UniBuddy_crud.dto.GoalDto;
//import BE.UniBuddy_crud.dto.SignupDto;
//import BE.UniBuddy_crud.repository.UsersRepository;
//import BE.UniBuddy_crud.service.AuthService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import BE.UniBuddy_crud.domain.Users;
//
//import java.time.LocalDate;
//
//
//@CrossOrigin(origins = "*")
//@RestController
//@RequestMapping("/users")
//public class AuthController {
//
//    private final AuthService authService;
//
//    private final UsersRepository usersRepository;
//
//    @Autowired
//    public AuthController(AuthService authService, UsersRepository usersRepository) {
//        this.authService = authService;
//        this.usersRepository = usersRepository;
//    }
//
//    @PostMapping(value = "/register")
//    public String signup(@RequestBody SignupDto signupDto) {
//        Users users = signupDto.toEntity();
//        Users userEntity = authService.회원가입(users);
//        return "index";
//    }
//
//
//    @PostMapping("/login")
//    public String login(@RequestParam String email, @RequestParam String password, Model model) {
//        Users user = authService.로그인(email, password);
//
//        if (user != null) {
//            // 로그인 성공
//            model.addAttribute("user", user);
//            return "Test"; // 로그인 성공 페이지로 이동
//        } else {
//            // 로그인 실패
//            model.addAttribute("error", "Invalid email or password");
//            return "loginPage"; // 로그인 페이지로 이동 (로그인 실패 메시지 표시)
//        }
//    }
//
//    @GetMapping("/{email}")
//    public Users getUserByName(@PathVariable String email) {
//        return usersRepository.findByEmail(email);
//    }
//
//    @DeleteMapping("/delete/{email}")
//    public ResponseEntity<String> deleteUserByEmail(@PathVariable String email) {
//        Users userToDelete = usersRepository.findByEmail(email);
//        if (userToDelete != null) {
//            usersRepository.delete(userToDelete);
//            return new ResponseEntity<>("계정이 삭제 되었습니다.", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("삭제 실패", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//
//}
package BE.UniBuddy_crud.controller;

import BE.UniBuddy_crud.dto.SignupDto;
import BE.UniBuddy_crud.repository.UsersRepository;
import BE.UniBuddy_crud.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import BE.UniBuddy_crud.domain.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class AuthController {

    private final AuthService authService;
    private final UsersRepository usersRepository;

    @Autowired
    public AuthController(AuthService authService, UsersRepository usersRepository) {
        this.authService = authService;
        this.usersRepository = usersRepository;
    }

    @PostMapping(value = "/register")
    public String signup(@RequestBody SignupDto signupDto) {
        Users users = signupDto.toEntity();
        Users userEntity = authService.register(users);
        return "index";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password, Model model) {
        Users user = authService.login(email, password);

        if (user != null) {
            // 로그인 성공
            model.addAttribute("user", user);
            return new ResponseEntity<>("로그인 성공", HttpStatus.OK);
        } else {
            // 로그인 실패
            model.addAttribute("error", "Invalid email or password");
            return new ResponseEntity<>("로그인 실패 메시지", HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/{email}")
    public Users getUserByName(@PathVariable String email) {
        return usersRepository.findByEmail(email);
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<String> deleteUserByEmail(@PathVariable String email) {
        Users userToDelete = usersRepository.findByEmail(email);
        if (userToDelete != null) {
            usersRepository.delete(userToDelete);
            return new ResponseEntity<>("계정이 삭제 되었습니다.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("삭제 실패", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value="/logout", method=RequestMethod.GET)
    public String logout(HttpServletRequest request) throws Exception{

        HttpSession session = request.getSession();
        session.invalidate();

        return "시작페이지";

    }
}
