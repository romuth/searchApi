package example.searchapi.service;

import example.searchapi.model.Coordinate;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoordinateServiceTest {
    @Autowired
    CoordinateService coordinateService;

    @Test
    public void save_Ok() {
        Coordinate coordinate = new Coordinate();
        coordinate.setLon(1.0);
        coordinate.setLat(2.0);
        Coordinate actual = coordinateService.save(coordinate);
        Assertions.assertNotNull(actual);
        Assertions.assertNotNull(actual.getId());
        Assertions.assertEquals(1.0, actual.getLon(),
                "Expected : " + coordinate.getLon() + ", but: " + actual.getLon());
    }

    @Test
    public void getAll_Ok() {
        coordinateService.save(new Coordinate());
        coordinateService.save(new Coordinate());
        coordinateService.save(new Coordinate());
        List<Coordinate> all = coordinateService.getAll();
        Assertions.assertNotNull(all, "expected List of coordinate, but :" + all);
        Assertions.assertNotNull(all.get(0));
    }

    @Test
    public void getAll_notOk() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                coordinateService.getAll().get(0));
    }
}