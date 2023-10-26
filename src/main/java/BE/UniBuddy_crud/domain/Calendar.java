package BE.UniBuddy_crud.domain;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data // @Getter @Setter
@Table(name = "calendar")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Calendar {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private int cal_num;

    private String add_content;

    @Column(nullable = false)
    private LocalDate day;



    public Calendar(int cal_num,  String add_content) {
        this.cal_num = cal_num;
        this.add_content = add_content;
    }

    // 연관관계 매핑
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id", nullable = false)
    private Users users;
}




