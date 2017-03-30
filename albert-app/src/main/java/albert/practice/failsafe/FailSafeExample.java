package albert.practice.failsafe;

import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;
import net.jodah.failsafe.ExecutionContext;
import net.jodah.failsafe.Failsafe;
import net.jodah.failsafe.RetryPolicy;
import net.jodah.failsafe.event.ContextualResultListener;
import net.jodah.failsafe.function.CheckedConsumer;
import net.jodah.failsafe.function.CheckedRunnable;

@Slf4j
public class FailSafeExample {

    @SuppressWarnings({"unchecked", "rawtypes"})
    public void setupConnectionWithRetry(ConnParams connParams) {
        RetryPolicy retryPolicy = new RetryPolicy();
        retryPolicy.withDelay(3, TimeUnit.SECONDS).withMaxRetries(3);

        Failsafe.with(retryPolicy)
//        .onSuccess(new CheckedConsumer() {
//            @Override
//            public void accept(Object t) throws Exception {
//                log.info("setup connection successfully");
//            }
//        })
//        .onFailure(new CheckedConsumer() {
//            @Override
//            public void accept(Object t) throws Exception {
//                if (t instanceof Exception) {
//                    Exception exception = (Exception) t;
//                    log.error("fail to connect, exception = " + exception.getMessage()
//                            + ", params = " + connParams.toString());
//                }
//            }
//        })
        .onFailedAttempt(new CheckedConsumer() {
            @Override
            public void accept(Object t) throws Exception {
                if (t instanceof Exception) {
                    Exception exception = (Exception) t;
                    log.error("Reconnecting...., exception = " + exception.getMessage()
                            + ", params = " + connParams.toString());
                }
            }
        }).onComplete(new ContextualResultListener() {
            @Override
            public void onResult(Object result, Throwable failure, ExecutionContext context)
                    throws Exception {
                if (failure == null) {
                    log.info("get connection succesfully");
                } else {
                    log.error("fail to get connection finally = " + failure.getMessage());
                }
            }
        }).run(new CheckedRunnable() {
            @Override
            public void run() throws Exception {
                log.info("connecting.....");
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
         throw new ConnectionException("Fail to setup connection");
    }

}
