package example.searchapi.util;

import example.searchapi.model.Role;
import example.searchapi.model.User;
import example.searchapi.service.RoleService;
import example.searchapi.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final UserService userService;
    private final RoleService roleService;

    public DataInitializer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void init() {
        Role adminRole = new Role();
        adminRole.setName("ADMIN");
        Role userRole = new Role();
        userRole.setName("USER");
        roleService.save(adminRole);
        roleService.save(userRole);
        User user = new User();
        user.setLogin("bob@test.com");
        user.setPassword("1234");
        user.setRoles(Set.of(userRole));
        User admin = new User();
        admin.setLogin("admin@test.com");
        admin.setPassword("5555");
        admin.setRoles(Set.of(adminRole));
        userService.add(user);
        userService.add(admin);
    }
}
