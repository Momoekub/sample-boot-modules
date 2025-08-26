package th.mfu;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String phoneNumber;

    // One-to-One with Teacher (Principal)
    @OneToOne
    @JoinColumn(name = "principal_id")
    private Teacher principal;

    // One-to-Many with Students
    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private List<Student> students;


    public School() {
    }
    public School(String name, String address, String phoneNumber) {
    this.name = name;
    this.address = address;
    this.phoneNumber = phoneNumber;
}
    // Getter & Setter
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Teacher getPrincipal() {
        return principal;
    }

    public void setPrincipal(Teacher principal) {
        this.principal = principal;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
