package in.kishanPandey.Day31_Jpa_Relationships.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne   // (optional = false)//this is for the entity for the java to meke the nonullable
    @JoinColumn(name = "dept_id") // nullable = false)//this is for the sql
    private Department departement;

//    private void addDepartement(Department department){
//        this.departement = department;
//        department.getStudents().add(this);
//    }
//
//    private void removeDepartement(Department department){
//        this.departement = null;
//        this.departement.remove();
//    }
}
