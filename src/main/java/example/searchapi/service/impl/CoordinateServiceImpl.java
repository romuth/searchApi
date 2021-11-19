package example.searchapi.service.impl;

import example.searchapi.model.Coordinate;
import example.searchapi.repository.CoordinateRepository;
import example.searchapi.service.CoordinateService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CoordinateServiceImpl implements CoordinateService {
    private final CoordinateRepository repository;

    public CoordinateServiceImpl(CoordinateRepository repository) {
        this.repository = repository;
    }

    @Override
    public Coordinate save(Coordinate coordinate) {
        if (checkIfExist(coordinate.getLat(), coordinate.getLon())) {
            return coordinate;
        }
        return repository.save(coordinate);
    }

    @Override
    public List<Coordinate> getAll() {
        return repository.findAll();
    }

    @Override
    public boolean checkIfExist(Double lat, Double lon) {
        Optional<Coordinate> coordinateByLatAndLon = repository.findCoordinateByLatAndLon(lat, lon);
        return coordinateByLatAndLon.isPresent();
    }
}
