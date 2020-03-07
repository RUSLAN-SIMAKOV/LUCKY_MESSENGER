package ruslan.simakov.luckymessenger.model.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class NotificationDto {

    private Long id;
    private Long commentId;
    private LocalDateTime timeGeneratingNotification;
    private Boolean isNotificationDelivered;
}
