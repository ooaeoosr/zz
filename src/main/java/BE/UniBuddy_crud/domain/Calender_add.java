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
@Table(name = "calender_add")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Calender_add {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private int add_num;

    @Column(nullable = false)
    private Date day;

    private String add_content;

    public Calender_add(int add_num, Date day, String add_content) {
        this.add_num = add_num;
        this.day = day;
        this.add_content = add_content;
    }
}
