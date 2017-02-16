package albert.practice.httpClient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.junit.Before;
import org.junit.Test;

public class HttpClientExampleTest {

    private HttpClientExample httpClientExample;

    @Before
    public void setup() {
        httpClientExample = new HttpClientExample();
    }

    @Test
    public void testSendPost() throws HttpException, IOException {
        int statusCode = httpClientExample.sendPost();
        assertEquals(HttpStatus.SC_OK, statusCode);
    }

    @Test
    public void testSendGet() throws HttpException, IOException {
        String responseString = httpClientExample.sendGet();
        System.out.println("responseString = " + responseString);
        assertNotNull(responseString);
    }

}
