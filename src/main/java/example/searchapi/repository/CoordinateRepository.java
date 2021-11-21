package example.searchapi.repository;

import example.searchapi.model.Coordinate;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordinateRepository extends JpaRepository<Coordinate, Long> {
    Optional<Coordinate> findCoordinateByLatAndLon(Double lat, Double lon);
}
