package in.kishanPandey.Day32_JPA_Cascading.repository;

import in.kishanPandey.Day32_JPA_Cascading.model.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public DepartmentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public Department findById(Long id){
        return entityManager.find(Department.class , id);
    }
    public void save(Department department){
        entityManager.persist(department);
    }

    public void remove(Department department){
        entityManager.remove(department);
    }

}
