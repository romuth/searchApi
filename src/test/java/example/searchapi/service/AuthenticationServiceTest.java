package example.searchapi.service;

import example.searchapi.model.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthenticationServiceTest {
    @Autowired
    AuthenticationService authService;

    @Test
    public void register_Ok() {
        String login = "tom@123";
        User user = authService.register(login, "3333");
        Assertions.assertNotNull(user);
        Assertions.assertEquals(login, user.getLogin());
    }
}