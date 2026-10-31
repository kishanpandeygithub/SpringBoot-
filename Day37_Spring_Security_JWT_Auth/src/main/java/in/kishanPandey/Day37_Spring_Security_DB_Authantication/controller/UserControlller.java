package in.kishanPandey.Day37_Spring_Security_DB_Authantication.controller;

import in.kishanPandey.Day37_Spring_Security_DB_Authantication.dto.UserRegisterRequestDto;
import in.kishanPandey.Day37_Spring_Security_DB_Authantication.dto.UserRegisterResponceDto;
import in.kishanPandey.Day37_Spring_Security_DB_Authantication.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserControlller {

    private AuthService authService;

    public UserControlller(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/hello")
    public String sayHello(Authentication authentication){
        return "Hello you are loged in as " + authentication.getName() ;
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponceDto> register(@RequestBody UserRegisterRequestDto registerRequestDto){
        UserRegisterResponceDto responceDto =
                authService.register(registerRequestDto);

        return ResponseEntity.ok(responceDto);
    }



    @GetMapping("/token")
    public CsrfToken getToken(CsrfToken csrfToken){
        return csrfToken;
    }
}
