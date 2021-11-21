package example.searchapi.service.impl;

import example.searchapi.model.Role;
import example.searchapi.model.User;
import example.searchapi.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserDetailsServiceImplTest {
    private UserDetailsService userDetailsService;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = Mockito.mock(UserService.class);
        userDetailsService = new UserDetailsServiceImpl(userService);
    }

    @Test
    void loadUserByUsername_Ok() {
        User tom = new User();
        tom.setLogin("tom@test.com");
        tom.setPassword("5555");
        tom.setRoles(Set.of(new Role(){{setName("USER");}}));
        String email = "tom@test.com";
        Mockito.when(userService.getByLogin(email)).thenReturn(Optional.of(tom));
        UserDetails actual = userDetailsService.loadUserByUsername(email);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(email, actual.getUsername());
        Assertions.assertEquals("5555", actual.getPassword());
    }

    @Test
    void loadByUserName_NotOk() {
        Assertions.assertThrows(UsernameNotFoundException.class, () ->
                userDetailsService.loadUserByUsername("test@test"));
    }
}