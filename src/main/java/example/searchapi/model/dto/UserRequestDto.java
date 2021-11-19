package example.searchapi.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    private String login;
    private String password;
}
