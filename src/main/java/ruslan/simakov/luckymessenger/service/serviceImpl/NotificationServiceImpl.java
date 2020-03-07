package ruslan.simakov.luckymessenger.service.serviceImpl;

import ruslan.simakov.luckymessenger.model.Notification;
import ruslan.simakov.luckymessenger.repository.NotificationRepository;
import ruslan.simakov.luckymessenger.service.BusinessLogicService;
import ruslan.simakov.luckymessenger.service.NotificationService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private BusinessLogicService businessLogicService;

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public void doSomeWorkOnNotification() {
        businessLogicService.sleepAndRandomThrowRuntimeException(2, 10);
    }

    @Override
    public Notification addNewNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getAllNotifications(Pageable pageable) {
        return notificationRepository.findAll(pageable).getContent();
    }

    @Override
    public boolean isCommentPresent(Notification notification) {
        return notificationRepository.existsById(notification.getId());
    }
}
