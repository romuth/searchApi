package example.searchapi.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import example.searchapi.model.dto.SearchResponseDto;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;

@Component
public class CustomHttpClient {
    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    private final ObjectMapper objectMapper = new ObjectMapper();

    {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public SearchResponseDto[] get(String url) {
        HttpGet request = new HttpGet(url);
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            return objectMapper
                    .readValue(response.getEntity().getContent(), SearchResponseDto[].class);
        } catch (Exception e) {
            throw new RuntimeException("Can't send get request", e);
        }
    }

    public SearchResponseDto getAll(String url) {
        HttpGet request = new HttpGet(url);
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            return objectMapper
                    .readValue(response.getEntity().getContent(), SearchResponseDto.class);
        } catch (Exception e) {
            throw new RuntimeException("Can't send get", e);
        }
    }
}
