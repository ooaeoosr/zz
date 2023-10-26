package BE.UniBuddy_crud.dto;

import BE.UniBuddy_crud.domain.Diarywrite;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Data
public class DiarywriteDto {
    private String act_name;
    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date term;

    private String agency_name;
    private String content;

    public Diarywrite toEntity() {
        return Diarywrite.builder()
                .act_name(act_name)
                .title(title)
                .term(term)
                .agency_name(agency_name)
                .content(content)
                .build();
    }

    public static DiarywriteDto fromEntity(Diarywrite diarywrite) {
        DiarywriteDto dto = new DiarywriteDto();
        dto.setAct_name(diarywrite.getAct_name());
        dto.setTitle(diarywrite.getTitle());
        dto.setTerm(diarywrite.getTerm());
        dto.setAgency_name(diarywrite.getAgency_name());
        dto.setContent(diarywrite.getContent());
        return dto;
    }


}
