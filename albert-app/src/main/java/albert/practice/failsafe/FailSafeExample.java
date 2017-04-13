package albert.practice.failsafe;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;
import net.jodah.failsafe.Failsafe;
import net.jodah.failsafe.RetryPolicy;

@Slf4j
public class FailSafeExample {

	public void setupConnectionWithRetry(ConnParams connParams) {
		RetryPolicy retryPolicy = new RetryPolicy();
		retryPolicy.withDelay(3, TimeUnit.SECONDS).withMaxRetries(3);

		Failsafe.with(retryPolicy).onSuccess(cxn -> {
			log.info("[onSuccess] setup connection successfully");
		}).onFailedAttempt(failure -> {
			log.info("[onFailedAttempt] fail to setup connection, error = " + failure.toString());
		}).onFailure(failure -> {
			log.info("[onFailure] fail to setup connection, error = " + failure.getMessage());
		}).run(() -> {
			log.debug("[run] setupConnection ");
			setupConnection(connParams);
		});
	}

	// log.info("[onFailedAttempt] fail to setup connection, error = " +
	// failure.getMessage());
	public void setupConnection(ConnParams connParams) throws ConnectionException {
		Random random = new Random();
		int n = random.nextInt(20);
		log.debug("random number = " + n);

		// throw exception if number is even
		if (n % 2 == 0) {
			throw new ConnectionException("Fail to setup connection");
		}
	}

}
