package BE.UniBuddy_crud.service;

import BE.UniBuddy_crud.domain.Diarywrite;
import BE.UniBuddy_crud.domain.Users;
import BE.UniBuddy_crud.repository.DiarywriteRepository;
import BE.UniBuddy_crud.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class DiarywriteService {

    private final DiarywriteRepository diarywriteRepository;

    public Diarywrite write(Diarywrite diarywrite) {
        //회원가입 진행
        Diarywrite diarywriteEntity = diarywriteRepository.save(diarywrite);
        return diarywriteEntity;
    }
}
