package seminars.fourth.http_client;

public class WebService {
    private HttpClient client;

    public WebService(HttpClient client) {
        this.client = client;
    }

    public void getHttp(String url){
        System.out.println(client.get(url));
    }
}
