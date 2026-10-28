package in.kishanPandey.Day31_Jpa_Relationships.repository;

import in.kishanPandey.Day31_Jpa_Relationships.model.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Department department){
        entityManager.persist(department);
    }

    public Department getDepartmentById(Long id){
        return entityManager.find(Department.class , id);
    }
}
