package in.kishanPandey.Day37_Spring_Security_DB_Authantication.service;

import in.kishanPandey.Day37_Spring_Security_DB_Authantication.entity.CustomUserDetails;
import in.kishanPandey.Day37_Spring_Security_DB_Authantication.entity.User;
import in.kishanPandey.Day37_Spring_Security_DB_Authantication.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(
                ()-> new UsernameNotFoundException("user not found"));

        return new CustomUserDetails(user);
    }
}
