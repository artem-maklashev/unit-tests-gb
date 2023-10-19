package seminars.fourth.http_client;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class WebServiceTest {
    @Test
       void httpRequestTest() {
            HttpClient httpClient = mock(HttpClient.class);
            WebService webService = new WebService(httpClient);
            when(httpClient.get(anyString())).thenReturn("Site");
            String url = "pam.com";

            webService.getHttp(url);

            verify(httpClient, times(1)).get(anyString());


    }
}
