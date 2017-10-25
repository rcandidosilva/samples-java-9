package samples;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.net.URI;

public class HTTP2 {

    public static void main(String[] args) throws Exception {
        URI uri = new URI("https://www.google.com.br");
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        HttpResponse<String> response = client.send(
                request, HttpResponse.BodyHandler.asString());

        System.out.println(response.statusCode());
        System.out.println(response.version());
        System.out.println(response.body());
    }

}
