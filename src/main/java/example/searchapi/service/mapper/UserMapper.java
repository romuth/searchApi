package example.searchapi.service.mapper;

import example.searchapi.model.User;
import example.searchapi.model.dto.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDto toDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setLogin(user.getLogin());
        dto.setId(user.getId());
        return dto;
    }
}
