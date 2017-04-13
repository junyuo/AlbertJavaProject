package albert.practice.failsafe;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FailSafeTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    ConnParams connParams = null;
    FailSafeExample failSafeExample = null;

    @Before
    public void setup() {
        connParams = new ConnParams.Builder().url("http://192.168.0.1").userName("admin")
                .password("password").build();
        failSafeExample = new FailSafeExample();
    }

    @Test
    public void testSetupConnectionWithRetry() {
//        thrown.expect(FailsafeException.class);
        failSafeExample.setupConnectionWithRetry(connParams);
    }

}
