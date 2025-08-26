package th.camt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import th.mfu.School;
import th.mfu.SchoolRepository;
import th.mfu.Student;
import th.mfu.StudentRepository;

import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Test
    void testCRUD() {
        // CREATE school first
        School school = new School("Bangkok International School", "123 Sukhumvit Rd", "02-123-4567");
        school = schoolRepository.save(school);

        // CREATE student
        Student s = new Student("S1001", "Tom", "Brown", "tom@email.com", "082-111-1111", 10, school);
        Student saved = studentRepository.save(s);
        assertThat(saved.getId()).isNotNull();

        // READ
        Optional<Student> fetched = studentRepository.findById(saved.getId());
        assertThat(fetched).isPresent();
        assertThat(fetched.get().getFirstName()).isEqualTo("Tom");

        // UPDATE
        saved.setGrade(11);
        Student updated = studentRepository.save(saved);
        assertThat(updated.getGrade()).isEqualTo(11);

        // DELETE
        studentRepository.delete(updated);
        assertThat(studentRepository.findById(updated.getId())).isEmpty();
    }
}