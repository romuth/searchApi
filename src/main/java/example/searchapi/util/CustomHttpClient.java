package example.searchapi.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import example.searchapi.model.dto.AddressDto;
import example.searchapi.model.dto.SearchRequestDto;
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

    public SearchRequestDto getByAddress(String url) {
        return get(url)[0];
    }

    public AddressDto getAllAddresses(String url) {
        return getAll(url).getAddress();
    }

    private SearchRequestDto[] get(String url) {
        HttpGet request = new HttpGet(url);
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            return objectMapper
                    .readValue(response.getEntity().getContent(), SearchRequestDto[].class);
        } catch (Exception e) {
            throw new RuntimeException("Can't send get request", e);
        }
    }

    private SearchRequestDto getAll(String url) {
        HttpGet request = new HttpGet(url);
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            return objectMapper
                    .readValue(response.getEntity().getContent(), SearchRequestDto.class);
        } catch (Exception e) {
            throw new RuntimeException("Can't send get", e);
        }
    }
}
