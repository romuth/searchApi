package example.searchapi.service;

import example.searchapi.model.Coordinate;
import java.util.List;

public interface CoordinateService {
    Coordinate save(Coordinate coordinate);

    List<Coordinate> getAll();

    boolean checkIfExist(Double lat, Double lon);
}
