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
@Table(name = "calendar")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Calendar {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private int cal_num;

    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private int goal_num;

    @Column(nullable = false)
    private int add_num;

    public Calendar(int cal_num, String id, int goal_num, int add_num) {
        this.cal_num = cal_num;
        this.id = id;
        this.goal_num = goal_num;
        this.add_num = add_num;
    }
}
