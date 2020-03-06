package ruslan.simakov.luckymessenger.service;

public interface BusinessLogicService {

    void sleepAndRandomThrowRuntimeException(int seconds, int exceptionProbabilityProc);
}
