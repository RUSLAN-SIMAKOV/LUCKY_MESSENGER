package ruslan.simakov.luckymessenger.service;

import ruslan.simakov.luckymessenger.model.Notification;
import java.util.List;

import org.springframework.data.domain.Pageable;

public interface NotificationService {

    void doSomeWorkOnNotification();

    Notification addNewNotification(Notification notification);

    List<Notification> getAllNotifications(Pageable pageable);

    boolean isCommentPresent(Notification notification);
}
