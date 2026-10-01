package in.kishanPandey.Day13_CrudOperationInSpring.repository;

import in.kishanPandey.Day13_CrudOperationInSpring.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface StudentRepository extends JpaRepository<Student , Long> {

     Optional<Student> findByIdAndDeletedIsFalse(Long Id);

     List<Student> findByDeletedIsFalse();
}
