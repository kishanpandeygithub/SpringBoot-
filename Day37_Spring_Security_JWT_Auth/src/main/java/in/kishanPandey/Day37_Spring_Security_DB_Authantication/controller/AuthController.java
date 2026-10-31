package in.kishanPandey.Day37_Spring_Security_DB_Authantication.controller;

import in.kishanPandey.Day37_Spring_Security_DB_Authantication.dto.LoginRequestDto;
import in.kishanPandey.Day37_Spring_Security_DB_Authantication.dto.LoginResponceDto;
import in.kishanPandey.Day37_Spring_Security_DB_Authantication.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public LoginResponceDto login(
            @RequestBody LoginRequestDto loginRequestDto
    ) {
        Authentication authenticationRequest =
                UsernamePasswordAuthenticationToken.unauthenticated(
                        loginRequestDto.getUsername(),
                        loginRequestDto.getPassword()
                );

        Authentication authentication =authenticationManager.authenticate(authenticationRequest);

        String token = jwtService.generateToken(authentication);

        return new LoginResponceDto(token);
    }
}
