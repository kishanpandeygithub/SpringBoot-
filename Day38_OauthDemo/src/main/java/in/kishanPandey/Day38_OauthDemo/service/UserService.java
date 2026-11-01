package in.kishanPandey.Day38_OauthDemo.service;

import in.kishanPandey.Day38_OauthDemo.entity.User;
import in.kishanPandey.Day38_OauthDemo.repository.UserRepository;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerOrUpdate(String provider , OidcUser oidcUser){
        String providerSubject  = oidcUser.getSubject();

        Optional<User> existingUser = userRepository.findByProviderAndProviderSubject(provider , providerSubject);

        String name = oidcUser.getClaimAsString("name");
        String email = oidcUser.getClaimAsString("email");
        if(existingUser.isPresent()){
            User user = existingUser.get();
            user.setName(name);
            user.setEmail(email);
            return user;
        }

        User newUser =
                new User(name ,email ,provider , providerSubject );
        return userRepository.save(newUser);
    }


    public Optional<User> findByProviderAndSubject(
            String provider , String subject
    ){
        return userRepository.findByProviderAndProviderSubject(provider , subject);
    }
}
