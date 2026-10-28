package in.kishanPandey.Day30_Hibernate_Internals.repository;

import in.kishanPandey.Day30_Hibernate_Internals.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public StudentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //create
    public void save(Student student){
        entityManager.persist(student);
    }
    //read
    public Student findById(Long id){
        return entityManager.find(Student.class , id);
    }

    public void remove(Student student){
        entityManager.remove(student);
    }

    public Student attachAgain(Student student) {
        return entityManager.merge(student);
    }

    public void detach(Student student){
        entityManager.detach(student);
    }
}
