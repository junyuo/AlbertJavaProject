package albert.practice.httpClient;

import java.io.IOException;

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.io.IOUtils;

import com.google.common.base.Charsets;

public class HttpClientExample {

    private String post_uri = "http://10.12.14.28:5555/rest/cctv.restful.RestTest2";
    private String get_uri = "http://10.12.14.28:5555/rest/cctv.restful.RestTest3";
    private String inputJson = "{\"NvrIP\":\"10.10.12.66\",\"State\": \"OFFLINE\"}";
    
    public int sendPost() throws HttpException, IOException {
        AuthScope authScope = getAuthScope();
        Credentials credentials = getCredentials();
        
        HttpClient client = new HttpClient();
        client.getState().setCredentials(authScope, credentials);
        
        PostMethod httpPost = new PostMethod(post_uri);
        httpPost.setDoAuthentication(true);
        httpPost.setParameter("data", inputJson);

        return client.executeMethod(httpPost);
    }

    public String sendGet() throws HttpException, IOException {
        String responseString = "";
        
        AuthScope authScope = getAuthScope();
        Credentials credentials = getCredentials();
        
        HttpClient client = new HttpClient();
        client.getState().setCredentials(authScope, credentials);
        GetMethod httpGet = new GetMethod(get_uri+"?input=albert");
        
        int statusCode = client.executeMethod(httpGet);
        if (HttpStatus.SC_OK == statusCode) {
            responseString = IOUtils.toString(httpGet.getResponseBodyAsStream(), Charsets.UTF_8);    
        }
        return responseString;
    }

    private AuthScope getAuthScope() {
        String ip = "10.12.14.28";
        int port = 5555;
        String realm = AuthScope.ANY_REALM;

        AuthScope authScope = new AuthScope(ip, port, realm);
        return authScope;
    }

    private Credentials getCredentials() {
        String username = "cctv";
        String password = "cctv";
        Credentials credentials = new UsernamePasswordCredentials(username, password);
        return credentials;
    }

}
