package BE.UniBuddy_crud.domain;




import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.*;


@Entity
@Data // @Getter @Setter
@Table(name = "mypage_pw")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Mypage_pw {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String pw;

    @Column(nullable = false)
    private String new_pw;

    public Mypage_pw(String id, String pw, String new_pw) {
        this.id = id;
        this.pw = pw;
        this.new_pw = new_pw;
    }
}