package example.searchapi.service.impl;

import static org.springframework.security.core.userdetails.User.*;

import example.searchapi.model.Role;
import example.searchapi.model.User;
import example.searchapi.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.getByLogin(login).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));
        UserBuilder builder = withUsername(login);
        builder.password(user.getPassword());
        builder.roles(user.getRoles().stream()
                .map(Role::getName)
                .toArray(String[]::new));
        return builder.build();
    }
}
