package in.kishanPandey.Day37_Spring_Security_DB_Authantication.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterRequestDto {
    private String username;

    private String password;
}
