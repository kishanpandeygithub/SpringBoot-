package in.kishanPandey.Day31_Jpa_Relationships.repository;

import in.kishanPandey.Day31_Jpa_Relationships.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    @PersistenceContext
    public EntityManager entityManager;

    public StudentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Student student){
        entityManager.persist(student);
    }


}
