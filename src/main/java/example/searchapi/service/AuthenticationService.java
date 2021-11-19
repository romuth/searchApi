package example.searchapi.service;

import example.searchapi.model.User;

public interface AuthenticationService {

    User register(String login, String password);
}
