package in.kishanPandey.Day37_Spring_Security_DB_Authantication.service;

import in.kishanPandey.Day37_Spring_Security_DB_Authantication.entity.Role;
import in.kishanPandey.Day37_Spring_Security_DB_Authantication.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void addRole(Role role){
        roleRepository.save(role);
    }
}
