//package BE.UniBuddy_crud.domain;
//
//
//import lombok.*;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Getter
//@Setter
//@Entity
//@Data // @Getter @Setter
//@Table(name = "diarywrite")
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//public class Diarywrite {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(nullable = false)
//    private int act_id;
//
//    @GeneratedValue
//    @Column(nullable = false)
//    private String act_name;
//
//    @Column(nullable = false)
//    private String title;
//
//    @Column(nullable = false)
//    private Date term;
//
//    @Column(nullable = false)
//    private String agency_name;
//
//    @Column
//    private String content;
//
////    @Column(nullable = false)
////    private Long id;
//
////    @ManyToOne
////    @JoinColumn(name = "id", nullable = false)
////    private Users users;
//    @ManyToOne
//    @JoinColumn(name = "users_id")
//    private Users id;
//
//    @Builder
//    public Diarywrite(String act_name, String title ,Date term, String agency_name, String content) {
//        this.act_name = act_name;
//        this.title = title;
//        this.term = term;
//        this.agency_name = agency_name;
//        this.content = content;
//    }
//
//
//    public static Diarywrite create(String act_name, String title ,Date term, String agency_name, String content) {
//        Diarywrite diarywrite = new Diarywrite();
//        diarywrite.setAct_name(act_name);
//        diarywrite.setTitle(title);
//        diarywrite.setTerm(term);
//        diarywrite.setAgency_name(agency_name);
//        diarywrite.setContent(content);
//        return diarywrite;
//
//    }
//}
package BE.UniBuddy_crud.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "diarywrite")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Diarywrite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private int act_id;

    private String act_name;
    private String title;
    private Date term;
    private String agency_name;
    private String content;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;

    // 생성자를 직접 정의하지 않고 롬복의 @NoArgsConstructor(access = AccessLevel.PROTECTED)를 사용
    // @Builder 어노테이션을 사용하여 객체를 생성

    public static Diarywrite create(String act_name, String title, Date term, String agency_name, String content) {
        Diarywrite diarywrite = new Diarywrite();
        diarywrite.setAct_name(act_name);
        diarywrite.setTitle(title);
        diarywrite.setTerm(term);
        diarywrite.setAgency_name(agency_name);
        diarywrite.setContent(content);
        return diarywrite;
    }
}
