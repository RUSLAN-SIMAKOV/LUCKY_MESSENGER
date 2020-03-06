package ruslan.simakov.luckymessenger.service;

import ruslan.simakov.luckymessenger.model.Comment;
import ruslan.simakov.luckymessenger.model.Notification;

public interface NotificationService {

    void doSomeWorkOnNotification();

    Comment addNewNotification(Notification notification);

    boolean isCommentPresent(Notification notification);
}
