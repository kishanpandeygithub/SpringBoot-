package in.kishanPandey.Day37_Spring_Security_DB_Authantication.repository;

import in.kishanPandey.Day37_Spring_Security_DB_Authantication.entity.User;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User , Long> {

    @EntityGraph(attributePaths = "roles")
    Optional<User> findByUsername(String username);
}
