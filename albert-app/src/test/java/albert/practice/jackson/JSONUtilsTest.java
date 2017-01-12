package albert.practice.jackson;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JSONUtilsTest extends JSONUtils {

    private JSONUtils.Response response;
    private String json = "";

    @Before
    public void setup() {
        response = new JSONUtils.Response("SMS", "OPEN");
        json = "{ \"type\": \"SMS\", \"status\": \"OPEN\" }";
    }

    @Test
    public void testConvertJsonToObject() throws IOException {
        JSONUtils.Response response = convertJsonToObject(json);
        log.debug("response = " + response.toString());
        assertNotNull(response);
    }
    
    @Test
    public void testConvertObjectToJson() throws IOException {
        String json = convertObjectToJson(response);
        log.debug("json = " + json);
        assertNotNull(json);
    }
    
}
