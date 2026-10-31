package in.kishanPandey.Day37_Spring_Security_DB_Authantication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestBody;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponceDto {
    private String accessToken;

}
