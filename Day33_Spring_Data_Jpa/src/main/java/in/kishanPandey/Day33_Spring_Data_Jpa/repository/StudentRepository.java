package in.kishanPandey.Day33_Spring_Data_Jpa.repository;

import in.kishanPandey.Day33_Spring_Data_Jpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository
        extends JpaRepository<Student , Long> {

//    void save(Student student);
//    Optional<Student> findById(Long id);

    @Query(value = """
            select * from student
            where email= :email
            """ , nativeQuery = true)
    Optional<Student> findByEmail(@Param("email") String email);
}
