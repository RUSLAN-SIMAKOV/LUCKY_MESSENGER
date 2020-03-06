package ruslan.simakov.luckymessenger.service.serviceImpl;

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
}
