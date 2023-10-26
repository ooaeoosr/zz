package BE.UniBuddy_crud.domain;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data // @Getter @Setter
@Table(name = "time_score")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Time_score {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private int semester;


    private float avg_score;
    private int get_score;

    public Time_score(int semester, float avg_score, int get_score) {
        this.semester = semester;
        this.avg_score = avg_score;
        this.get_score = get_score;
    }
}

