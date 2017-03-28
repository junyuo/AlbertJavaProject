package albert.practice.failsafe;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;
import net.jodah.failsafe.Failsafe;
import net.jodah.failsafe.RetryPolicy;

@Slf4j
public class FailSafeExample {

    public void setupConnectionWithRetry() {
        RetryPolicy retryPolicy = new RetryPolicy();
        retryPolicy.withDelay(5, TimeUnit.SECONDS).withMaxRetries(5);
        
        Failsafe.with(retryPolicy).get(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                log.debug("try to setup connection");
                return setupConnection();
            }
        });
    }
    
    public Void setupConnection() {
        throw new RuntimeException("Fail to setup connection");
    }
    
    public static void main(String[] args) {
        new FailSafeExample().setupConnectionWithRetry();
    }
    
}
