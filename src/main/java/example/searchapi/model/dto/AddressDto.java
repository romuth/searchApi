package example.searchapi.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDto {
    private String shop;
    private String road;
    private String neighbourhood;
    private String region;
    private String suburb;
    private String borough;
    private String city;
    private String state;
    private String postcode;
    private String country;
    @JsonProperty("country_code")
    private String countryCode;
}
