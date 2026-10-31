package in.kishanPandey.Day37_Spring_Security_DB_Authantication.repository;

import in.kishanPandey.Day37_Spring_Security_DB_Authantication.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role , Long> {
    Optional<Role> findByRole(String role);
}
