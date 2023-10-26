package BE.UniBuddy_crud.domain;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String university;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column
    private String hash;

    @Column
    private String sns;

    @Column
    private String education;

    @Column
    private String phone;

    @Builder
    public Users(String email, String name, String password, String university) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.university = university;
    }

    public static Users create(String email, String name, String password, String university) {
        Users users = new Users();
        users.setEmail(email);
        users.setName(name);
        users.setPassword(password);
        users.setUniversity(university);
        return users;
    }


}
