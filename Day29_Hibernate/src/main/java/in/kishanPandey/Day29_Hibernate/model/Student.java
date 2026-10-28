package in.kishanPandey.Day29_Hibernate.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "student_name" ,
            nullable = false ,
            length = 100
    )
    private String name;

    @Column(
            unique = true ,
            nullable = false ,
            length = 150 ,
            insertable = true ,
            updatable = true
    )
    private String email;

    private int age;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "houseNo",
                    column = @Column(name = "current_house_no")
            ),
            @AttributeOverride(
                    name = "street",
                    column = @Column(name = "current_street")
            ) ,
            @AttributeOverride(
                    name = "city" ,
                    column = @Column(name = "current_city")
            ),
            @AttributeOverride(
                    name = "state" ,
                    column = @Column(name = "current_state")
            ) ,
            @AttributeOverride(
                    name = "pincode" ,
                    column = @Column(name = "current_pincode")
            )
    })
    private Address currentAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "houseNo",
                    column = @Column(name = "permanent_house_no")
            ),
            @AttributeOverride(
                    name = "street",
                    column = @Column(name = "permanent_street")
            ) ,
            @AttributeOverride(
                    name = "city" ,
                    column = @Column(name = "permanent_city")
            ),
            @AttributeOverride(
                    name = "state" ,
                    column = @Column(name = "permanent_state")
            ) ,
            @AttributeOverride(
                    name = "pincode" ,
                    column = @Column(name = "permanent_pincode")
            )
    })
    private Address permanentAddress;

    @ElementCollection
    @CollectionTable(
            name = "student_skills" ,
            joinColumns = @JoinColumn(
                    name = "student_id"
            )
    )
    private Set<String> skills;

    @ElementCollection
    @CollectionTable(
            name = "sudent_address" ,
            joinColumns = @JoinColumn(
                    name = "student_id"
            )
    )
    private Set<Address> addresses;

//    @Column(precision = 5 , scale = 2)
//    private BigDecimal percentage;
//
//    private LocalDate dateOfBirth;
//
//    private LocalDateTime createdAt;
//
//    @Enumerated(EnumType.STRING)
//    private StudentStatus status;
//
//    @Lob
//    private String profileDescription;
//
//    @Transient
//    private String displayName;
//
//    @Convert(converter = BooleanToStringConverter.class)
//    private Boolean isMonitor;

    public Student() {
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    public Student(Long id, String name, String email, int age,
                   Address currentAddress, Address permanentAddress,
                   Set<String> skills, Set<Address> addresses) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.currentAddress = currentAddress;
        this.permanentAddress = permanentAddress;
        this.skills = skills;
        this.addresses = addresses;
    }

    public Address getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(Address currentAddress) {
        this.currentAddress = currentAddress;
    }

    public Address getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(Address permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public BigDecimal getPercentage() {
//        return percentage;
//    }
//
//    public void setPercentage(BigDecimal percentage) {
//        this.percentage = percentage;
//    }
//
//    public LocalDate getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(LocalDate dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public StudentStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(StudentStatus status) {
//        this.status = status;
//    }
//
//    public String getProfileDescription() {
//        return profileDescription;
//    }
//
//    public void setProfileDescription(String profileDescription) {
//        this.profileDescription = profileDescription;
//    }
//
//    public String getDisplayName() {
//        return displayName;
//    }
//
//    public void setDisplayName(String displayName) {
//        this.displayName = displayName;
//    }
//
//    public Boolean getMonitor() {
//        return isMonitor;
//    }
//
//    public void setMonitor(Boolean monitor) {
//        isMonitor = monitor;
//    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}