package example.searchapi.controller;

import example.searchapi.model.Coordinate;
import example.searchapi.model.dto.SearchResponseDto;
import example.searchapi.service.CoordinateService;
import example.searchapi.service.mapper.CoordinateMapper;
import example.searchapi.util.CustomHttpClient;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
    private final CustomHttpClient httpClient;
    private final CoordinateService coordinateService;
    private final CoordinateMapper mapper;

    public SearchController(CustomHttpClient httpClient,
                            CoordinateService coordinateService, CoordinateMapper mapper) {
        this.httpClient = httpClient;
        this.coordinateService = coordinateService;
        this.mapper = mapper;
    }

    @GetMapping("/search")
    public SearchResponseDto[] find(@RequestParam String q) {
        String url = String.format("https://nominatim.openstreetmap.org/?addressdetails=1&q=%s&format=json&limit=1",
                q.replace(",", "").replace(" +", "+"));
        SearchResponseDto[] searchResponseDtos =
                httpClient.get(url);
        coordinateService.save(mapper.toModel(searchResponseDtos[0]));
        return searchResponseDtos;
    }

    @GetMapping("/addresses")
    public List<SearchResponseDto> getAll() {
        List<Coordinate> all = coordinateService.getAll();
        List<SearchResponseDto> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (Coordinate coordinate : all) {
            builder.append(String.format("https://nominatim.openstreetmap.org/reverse?format=json&lat=%s&lon=%s",
                    coordinate.getLat(), coordinate.getLon()));
            list.add(httpClient.getAll(builder.toString()));
            builder.delete(0, builder.length());
        }
        return list;
    }
}
