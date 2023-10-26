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
@Table(name = "calender_goal")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Calender_goal {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private int goal_num;

    @Column(nullable = false)
    private Date month;

    private String goal_content;

    public Calender_goal(int goal_num, Date month, String goal_content) {
        this.goal_num = goal_num;
        this.month = month;
        this.goal_content = goal_content;
    }
}
