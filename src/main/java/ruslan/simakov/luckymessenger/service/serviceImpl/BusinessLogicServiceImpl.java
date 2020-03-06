package ruslan.simakov.luckymessenger.service.serviceImpl;

import ruslan.simakov.luckymessenger.service.BusinessLogicService;

import org.springframework.stereotype.Service;

@Service
public class BusinessLogicServiceImpl implements BusinessLogicService {

    @Override
    public void sleepAndRandomThrowRuntimeException(int seconds, int exceptionProbabilityProc) {

        try {
            Thread.sleep((long) (seconds * 1000 * Math.random()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int randomProc = (int) (100 * Math.random());
        if(exceptionProbabilityProc > randomProc) throw new RuntimeException();
    }
}
