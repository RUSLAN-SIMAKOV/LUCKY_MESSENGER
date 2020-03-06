package ruslan.simakov.luckymessenger.model.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CommentDto {

    private Long id;
    private String comment;
    private LocalDateTime timeGeneratingComment;
}
