package in.kishanPandey.Day32_JPA_Cascading.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String name;
//    @OneToMany(mappedBy = "departement"
//    )
//    private List<Student> students = new ArrayList<>();

//    public void setStudents(ArrayList<Student> students) {
//        this.students = students;
//    }
}
