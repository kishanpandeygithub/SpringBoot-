package in.kishanPandey.Day32_JPA_Cascading.repository;

import in.kishanPandey.Day32_JPA_Cascading.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    @PersistenceContext
    public EntityManager entityManager;

    public StudentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void  save(Student student){
        entityManager.persist(student);
    }

    @EntityGraph(attributePaths = {"department" , "profile"})
    public Student findById(Long id){
        return entityManager.find(Student.class , id);
    }

    @EntityGraph(attributePaths = "profile")
    public List<Student> findAllProfile(){
        return  null;
    };
}
