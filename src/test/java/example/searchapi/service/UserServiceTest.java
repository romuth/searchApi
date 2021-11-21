package example.searchapi.service;

import example.searchapi.model.Role;
import example.searchapi.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.NoSuchElementException;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Test
    public void save_Ok() {
        User actual = userService.save(new User());
        Assertions.assertNotNull(actual.getId());
    }

    @Test
    public void getByLogin_OK() {
        User user = new User();
        user.setLogin("login.test");
        user.setRoles(Set.of(roleService.save(new Role())));
        userService.save(user);
        User actual = userService.getByLogin("login.test").get();
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(user.getLogin(), actual.getLogin(),
                "Expected: " + user.getLogin() + ", but: " + actual.getLogin());
    }

    @Test
    public void getByLogin_NotOk() {
        Assertions.assertThrows(NoSuchElementException.class, () ->
                userService.getByLogin("wrongLogin").get());
    }

    @Test
    public void add_Ok() {
        User user = new User();
        user.setPassword("4444");
        User actual = userService.add(user);
        Assert.assertNotEquals("4444", actual.getPassword());
    }
}