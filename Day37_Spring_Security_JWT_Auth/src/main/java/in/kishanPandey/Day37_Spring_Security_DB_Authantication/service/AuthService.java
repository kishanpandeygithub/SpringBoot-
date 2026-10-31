package in.kishanPandey.Day37_Spring_Security_DB_Authantication.service;

import in.kishanPandey.Day37_Spring_Security_DB_Authantication.dto.UserRegisterRequestDto;
import in.kishanPandey.Day37_Spring_Security_DB_Authantication.dto.UserRegisterResponceDto;
import in.kishanPandey.Day37_Spring_Security_DB_Authantication.entity.Role;
import in.kishanPandey.Day37_Spring_Security_DB_Authantication.entity.User;
import in.kishanPandey.Day37_Spring_Security_DB_Authantication.repository.RoleRepository;
import in.kishanPandey.Day37_Spring_Security_DB_Authantication.repository.UserRepository;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class AuthService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository ,RoleRepository roleRepository , PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserRegisterResponceDto register(
            UserRegisterRequestDto registerRequestDto){
        User user = new User();
        user.setUsername(registerRequestDto.getUsername());
        String encodedPassword = passwordEncoder.encode(registerRequestDto.getPassword());
        user.setPassword(encodedPassword);

        //adding the roles
        Role role = roleRepository.findByRole("ROLE_USER").get();
        user.getRoles().add(role);
        userRepository.save(user);

        UserRegisterResponceDto responceDto = new UserRegisterResponceDto();
        responceDto.setUsername(user.getUsername());
        responceDto.setMessage("User Registered Successfull");
        return responceDto;
    }


}
