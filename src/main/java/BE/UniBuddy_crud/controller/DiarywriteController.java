package BE.UniBuddy_crud.controller;


import BE.UniBuddy_crud.domain.Diarywrite;
import BE.UniBuddy_crud.dto.DiarywriteDto;
import BE.UniBuddy_crud.repository.DiarywriteRepository;
import BE.UniBuddy_crud.service.DiarywriteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.TimeZone;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/diarywrite")
public class DiarywriteController {

    private final DiarywriteService diarywriteService;

    private final DiarywriteRepository diarywriteRepository;

    public DiarywriteController(DiarywriteService diarywriteService, DiarywriteRepository diarywriteRepository) {
        this.diarywriteService = diarywriteService;
        this.diarywriteRepository = diarywriteRepository;
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/add")
    public String add(DiarywriteDto diarywriteDto) {
        Diarywrite diarywrite = diarywriteDto.ttoEntity();

        // 수정: DiarywriteDto에서 받은 문자열 형태의 날짜를 Date로 변환
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date termDate = null;
        try {
            termDate = dateFormat.parse(dateFormat.format(diarywriteDto.getTerm())); // 날짜를 문자열로 변환하여 다시 파싱
        } catch (ParseException e) {
            e.printStackTrace();
        }
        diarywrite.setTerm(termDate);

        Diarywrite diarywriteEntity = diarywriteService.작성(diarywrite);
        return "gg";
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiarywriteDto> getById(@PathVariable Long id) {
        Optional<Diarywrite> diarywrite = diarywriteRepository.findById(id);
        if (diarywrite.isPresent()) {
            // 엔티티를 DTO로 변환하여 반환
            DiarywriteDto diarywriteDto = DiarywriteDto.fromEntity(diarywrite.get());
            return ResponseEntity.ok(diarywriteDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        Optional<Diarywrite> diarywrite = diarywriteRepository.findById(id);
        if (diarywrite.isPresent()) {
            diarywriteRepository.deleteById(id);
            return ResponseEntity.ok("Deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}


