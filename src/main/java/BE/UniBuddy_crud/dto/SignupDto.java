package BE.UniBuddy_crud.dto;

import BE.UniBuddy_crud.domain.Users;
import lombok.Data;

@Data //Getter, Setter 생성
public class SignupDto {
    private String name;
    private String password;
    private String email;
    private String university;

    public Users toEntity() {
        return Users.builder()
                .name(name)
                .password(password)
                .email(email)
                .university(university)
                .build();
    }
}
