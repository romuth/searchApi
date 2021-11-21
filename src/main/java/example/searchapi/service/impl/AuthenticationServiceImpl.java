package example.searchapi.service.impl;

import example.searchapi.model.User;
import example.searchapi.service.AuthenticationService;
import example.searchapi.service.RoleService;
import example.searchapi.service.UserService;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final RoleService roleService;

    public AuthenticationServiceImpl(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public User register(String login, String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setRoles(Set.of(roleService.getRoleByName("USER")));
        return userService.add(user);
    }
}
