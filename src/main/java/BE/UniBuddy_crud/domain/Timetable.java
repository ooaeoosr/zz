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
@Table(name = "timetable")
public class Timetable {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long tt_num;

    @Column(nullable = false)
    private String id;

    @Column(nullable = true)
    private int sub_num;

    @Column(nullable = true)
    private int semester;

    public Timetable(Long tt_num, String id, int sub_num, int semester) {
        this.tt_num = tt_num;
        this.id = id;
        this.sub_num = sub_num;
        this.semester = semester;
    }

    public Long getTt_num() {
        return tt_num;
    }

    public void setTt_num(Long tt_num) {
        this.tt_num = tt_num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSub_num() {
        return sub_num;
    }

    public void setSub_num(int sub_num) {
        this.sub_num = sub_num;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Timetable{" +
                "tt_num=" + tt_num +
                ", id='" + id + '\'' +
                ", sub_num=" + sub_num +
                ", semester=" + semester +
                '}';
    }
}


