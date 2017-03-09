package albert.practice.json;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;

import albert.practice.json.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

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
    
    @Test
    public void testPersonBean() {
        new BeanTester().testBean(JSONUtils.Response.class);
    }

    @Test
    public void testEqualsAndHashcode() {
        EqualsVerifier.forClass(JSONUtils.Response.class)
                .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS).verify();
    }
    
}
