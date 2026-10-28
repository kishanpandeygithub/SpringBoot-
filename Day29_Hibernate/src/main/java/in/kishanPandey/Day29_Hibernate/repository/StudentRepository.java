package in.kishanPandey.Day29_Hibernate.repository;

import in.kishanPandey.Day29_Hibernate.model.Student;
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

    //update
    //read
    public Student findById(Long id){
        Student  s =entityManager.find(Student.class , id);
        entityManager.detach(s);
        return s;
    }
     
    //delete

    public void remove(Student student){
        entityManager.remove(student);
    }

    public Student attachAgain(Student student){
       return entityManager.merge(student);
    }
}
