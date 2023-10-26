package BE.UniBuddy_crud.controller;

import BE.UniBuddy_crud.dto.SignupDto;
import BE.UniBuddy_crud.repository.UsersRepository;
import BE.UniBuddy_crud.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import BE.UniBuddy_crud.domain.Users;


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

    @PostMapping("/register")
    public String signup(SignupDto signupDto) {
        Users users = signupDto.toEntity();
        Users userEntity = authService.회원가입(users);
        return "index";
    }


    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        Users user = authService.로그인(email, password);

        if (user != null) {
            // 로그인 성공
            model.addAttribute("user", user);
            return "Test"; // 로그인 성공 페이지로 이동
        } else {
            // 로그인 실패
            model.addAttribute("error", "Invalid email or password");
            return "loginPage"; // 로그인 페이지로 이동 (로그인 실패 메시지 표시)
        }
    }

    @GetMapping("/{email}")
    public Users getUserByName(@PathVariable String email) {
        return usersRepository.findByEmail(email);
    }

//    @PatchMapping("/edit/{email}")
//    public Users updateUser(@PathVariable String email, @RequestBody UpdateUserDto updateUserDto) {
//        Users user = usersRepository.findByEmail(email);
//
//        if (user != null) {
//            // 업데이트할 정보가 있는 경우에만 업데이트
//            if (updateUserDto.getName() != null) {
//                user.setName(updateUserDto.getName());
//            }
//            if (updateUserDto.getUniversity() != null) {
//                user.setUniversity(updateUserDto.getUniversity());
//            }
//
//            // 변경된 정보를 저장하고 반환
//            return usersRepository.save(user);
//        }
//
//        return null; // 사용자가 없는 경우에는 null 반환
//    }

    @DeleteMapping("/delete/{email}")
    public String deleteUserByEmail(@PathVariable String email) {
        Users userToDelete = usersRepository.findByEmail(email);
        if (userToDelete != null) {
            usersRepository.delete(userToDelete);
            return "User with email " + email + " has been deleted.";
        } else {
            return "User with email " + email + " not found.";
        }
    }

}
