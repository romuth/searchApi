package example.searchapi.controller;

import example.searchapi.model.User;
import example.searchapi.model.dto.UserRequestDto;
import example.searchapi.model.dto.UserResponseDto;
import example.searchapi.service.AuthenticationService;
import example.searchapi.service.mapper.UserMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authService;
    private final UserMapper mapper;

    public AuthenticationController(AuthenticationService authService, UserMapper mapper) {
        this.authService = authService;
        this.mapper = mapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto requestDto) {
        User user = authService.register(requestDto.getLogin(), requestDto.getPassword());
        return mapper.toDto(user);
    }
}
