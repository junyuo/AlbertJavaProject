package albert.practice.json;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class JSONUtils {

    public Response convertJsonToObject(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
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
        private String type;
        private String status;
    }
}
