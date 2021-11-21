package example.searchapi.service.mapper;

import example.searchapi.model.Coordinate;
import example.searchapi.model.dto.SearchRequestDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoordinateMapperTest {
    private CoordinateMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new CoordinateMapper();
    }

    @Test
    void toModel_Ok() {
        SearchRequestDto dto = new SearchRequestDto();
        dto.setLat(1.0);
        dto.setLon(2.0);
        Coordinate actual = mapper.toModel(dto);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(dto.getLon(), actual.getLon(),
                "Expected: " +  dto.getLon() + ", but: " + actual.getLon());
    }
}