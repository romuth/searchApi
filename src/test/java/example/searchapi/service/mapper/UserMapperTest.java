package example.searchapi.service.mapper;

import example.searchapi.model.User;
import example.searchapi.model.dto.UserResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserMapperTest {
    UserMapper userMapper;

    @BeforeEach
    void setUp() {
        userMapper = new UserMapper();
    }

    @Test
    void toModel_Ok() {
        User user = new User();
        user.setId(1L);
        user.setLogin("test");
        UserResponseDto actual = userMapper.toDto(user);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(user.getLogin(), actual.getLogin(),
                "Expected: " + user.getLogin() + ", but: " + actual.getLogin());
    }
}