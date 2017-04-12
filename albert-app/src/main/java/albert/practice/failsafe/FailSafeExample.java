package albert.practice.failsafe;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;
import net.jodah.failsafe.ExecutionContext;
import net.jodah.failsafe.Failsafe;
import net.jodah.failsafe.FailsafeConfig;
import net.jodah.failsafe.RetryPolicy;
import net.jodah.failsafe.SyncFailsafe;
import net.jodah.failsafe.event.ContextualResultListener;
import net.jodah.failsafe.function.CheckedConsumer;
import net.jodah.failsafe.function.CheckedRunnable;

@Slf4j
public class FailSafeExample {
    
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void setupConnectionWithRetry(ConnParams connParams) {
        RetryPolicy retryPolicy = new RetryPolicy();
        retryPolicy.withDelay(3, TimeUnit.SECONDS).withMaxRetries(3);

        ((FailsafeConfig<Object, SyncFailsafe<Object>>) Failsafe.with(retryPolicy)
        .onSuccess(new CheckedConsumer() {
            @Override
            public void accept(Object t) throws Exception {
                log.info("[onSuccess] setup connection successfully! connParams = " + connParams.toString());
            }
        })
//        .onFailure(new CheckedConsumer() {
//            @Override
//            public void accept(Object t) throws Exception {
//                if (t instanceof Exception) {
//                    Exception exception = (Exception) t;
//                    log.error("[onFailure] fail to connect, exception = " + exception.getMessage()
//                            + ", params = " + connParams.toString());
//                }
//            }
//        })
        .onFailedAttempt(new CheckedConsumer() {
            @Override
            public void accept(Object t) throws Exception {
                if (t instanceof Exception) {
                    Exception exception = (Exception) t;
                    log.error("[onFailedAttempt] Reconnecting...., exception = " + exception.getMessage()
                            + ", params = " + connParams.toString());
                }
            }
        }))
        .onComplete(new ContextualResultListener() {
            @Override
            public void onResult(Object result, Throwable failure, ExecutionContext context)
                    throws Exception {
                if (failure == null) {
//                    log.info("get connection succesfully");
                } else {
//                    log.error("fail to get connection finally = " + failure.getMessage());
                }
            }
        })
        .run(new CheckedRunnable() {
            @Override
            public void run() throws Exception {
                log.info("[run] connecting.....");
                setupConnection(connParams);
            }
        });

        // .get(new Callable<Void>() {
        // @Override
        // public Void call() throws Exception {
        // log.info("connecting.....");
        // return setupConnection();
        // }
        // });
    }

    public void setupConnection(ConnParams connParams ) throws ConnectionException {
        Random random = new Random();
        int n = random.nextInt(20);
        log.debug("random number = " + n);
        
        // throw exception if number is even
        if(n % 2 == 0) {
            throw new ConnectionException("Fail to setup connection");
        }
    }

}
