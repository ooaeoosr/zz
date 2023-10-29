package BE.UniBuddy_crud.controller;


import BE.UniBuddy_crud.domain.Diarywrite;
import BE.UniBuddy_crud.domain.Users;
import BE.UniBuddy_crud.dto.DiarywriteDto;
import BE.UniBuddy_crud.dto.GoalDto;
import BE.UniBuddy_crud.repository.DiarywriteRepository;
import BE.UniBuddy_crud.service.AuthService;
import BE.UniBuddy_crud.service.DiarywriteService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/diarywrite")
public class DiarywriteController {

    private final DiarywriteService diarywriteService;
    private AuthService authService;

    private final DiarywriteRepository diarywriteRepository;

    public DiarywriteController(DiarywriteService diarywriteService, AuthService authService, DiarywriteRepository diarywriteRepository) {
        this.diarywriteService = diarywriteService;
        this.authService = authService;
        this.diarywriteRepository = diarywriteRepository;
        this.authService = authService;
    }

@PostMapping("/add/{id}")
    public String add(@PathVariable("id") Long id, @RequestBody DiarywriteDto diarywriteDto) {
    Diarywrite diarywrite = diarywriteDto.toEntity();

    // 수정: DiarywriteDto에서 받은 문자열 형태의 날짜를 Date로 변환
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date termDate = null;
    try {
        termDate = dateFormat.parse(dateFormat.format(diarywriteDto.getTerm())); // 날짜를 문자열로 변환하여 다시 파싱
    } catch (ParseException e) {
        e.printStackTrace();
    }
    diarywrite.setTerm(termDate);


    // 사용자 ID를 설정
    Users user = authService.findById(id); // 사용자 정보 가져오기
    diarywrite.setUsers(user);

    diarywriteService.write(diarywrite);
    return "gg";
}


    @GetMapping("/{title}")
    public Diarywrite getDiary(@PathVariable String title) {
        return diarywriteRepository. findByTitle(title);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<DiarywriteDto> getById(@PathVariable Long id) {
//        Optional<Diarywrite> diarywrite = diarywriteRepository.findById(id);
//        if (diarywrite.isPresent()) {
//            // 엔티티를 DTO로 변환하여 반환
//            DiarywriteDto diarywriteDto = DiarywriteDto.fromEntity(diarywrite.get());
//            return ResponseEntity.ok(diarywriteDto);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }


    @DeleteMapping("/delete/{title}")
    @Transactional
    public ResponseEntity<String> deleteByTitle(@PathVariable String title) {
        try {
            Diarywrite diarywrite = diarywriteRepository.findByTitle(title);

            if (diarywrite != null) {
                diarywriteRepository.deleteByTitle(title);
                return ResponseEntity.ok("Deleted");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // 예외 처리 추가
            e.printStackTrace(); // 또는 로깅으로 변경해도 됩니다.
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }



}


