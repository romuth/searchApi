package example.searchapi.service;

import example.searchapi.model.Role;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTest {
    @Autowired
    RoleService roleService;

    @Test
    public void save_OK() {
        Role role = new Role();
        role.setName("TEST");
        Role actual = roleService.save(role);
        Assertions.assertNotNull(actual.getId(),
                "id field should not be null");
    }

    @Test
    public void getRoleByName_Ok() {
        Role role = new Role();
        role.setName("TEST");
        roleService.save(role);
        Role actual = roleService.getRoleByName("TEST");
        Assertions.assertNotNull(actual);
        Assertions.assertEquals("TEST", actual.getName(),
                "expected role name: " + "TEST" + ", but : " + actual.getName());
    }

    @Test
    public void getRoleByName_NotOk() {
        Assertions.assertThrows(NullPointerException.class, () ->
                roleService.getRoleByName("WrongRole").getName());
    }
}