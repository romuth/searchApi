package example.searchapi.service;

import example.searchapi.model.User;
import java.util.Optional;

public interface UserService {
    User save(User user);

    Optional<User> getByLogin(String login);

    User add(User user);
}
