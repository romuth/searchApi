package example.searchapi.service.mapper;

import example.searchapi.model.Coordinate;
import example.searchapi.model.dto.SearchResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CoordinateMapper {
    public Coordinate toModel(SearchResponseDto dto) {
        Coordinate coordinate = new Coordinate();
        coordinate.setLat(dto.getLat());
        coordinate.setLon(dto.getLon());
        return coordinate;
    }
}
