package in.kishanPandey.Day38_OauthDemo.repository;

import in.kishanPandey.Day38_OauthDemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User  ,Long> {
    Optional<User> findByProviderAndProviderSubject(String provider ,
                                                    String providerSubject);
}
