package BE.UniBuddy_crud.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data // @Getter @Setter
@Table(name = "login")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Login {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String pw;

    public Login(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }
}
