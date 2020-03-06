package ruslan.simakov.luckymessenger.service.serviceImpl;

import ruslan.simakov.luckymessenger.model.Comment;
import ruslan.simakov.luckymessenger.model.Notification;
import ruslan.simakov.luckymessenger.service.BusinessLogicService;
import ruslan.simakov.luckymessenger.service.NotificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private BusinessLogicService businessLogicService;

    @Override
    public void doSomeWorkOnNotification() {
        businessLogicService.sleepAndRandomThrowRuntimeException(2, 10);
    }

    @Override
    public Comment addNewNotification(Notification notification) {
        return null;
    }

    @Override
    public boolean isCommentPresent(Notification notification) {
        return false;
    }
}
