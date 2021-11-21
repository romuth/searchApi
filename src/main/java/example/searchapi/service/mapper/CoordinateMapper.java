package example.searchapi.service.mapper;

import example.searchapi.model.Coordinate;
import example.searchapi.model.dto.SearchRequestDto;
import org.springframework.stereotype.Component;

@Component
public class CoordinateMapper {
    public Coordinate toModel(SearchRequestDto dto) {
        Coordinate coordinate = new Coordinate();
        coordinate.setLat(dto.getLat());
        coordinate.setLon(dto.getLon());
        return coordinate;
    }

}
