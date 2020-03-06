package ruslan.simakov.luckymessenger.service.serviceImpl;

import ruslan.simakov.luckymessenger.service.BusinessLogicService;
import ruslan.simakov.luckymessenger.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private BusinessLogicService businessLogicService;


    @Override
    public void doSomeWorkOnCommentCreation() {
        businessLogicService.sleepAndRandomThrowRuntimeException(1, 30);
    }
}
