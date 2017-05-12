package albert.practice.json;

import java.io.IOException;

import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class JSONUtils {

    public Response convertJsonToObject(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);
        Response response = null;
        try {
            response = mapper.readValue(json, Response.class);
        } catch (IOException e) {
            throw e;
        }
        return response;
    }

    public static String convertObjectToJson(Response response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(response);
        } catch (IOException e) {
            throw e;
        }
        return jsonString;
    }

    @Data
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        @JsonProperty("Type")
        private String type;
        @JsonProperty("Status")
        private String status;
    }
}
