package th.camt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import th.mfu.Teacher;
import th.mfu.TeacherRepository;

import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    void testCRUD() {
        // CREATE
        Teacher t = new Teacher("Alice", "Smith", "alice@email.com", "081-111-2222", "Math");
        Teacher saved = teacherRepository.save(t);
        assertThat(saved.getId()).isNotNull();

        // READ
        Optional<Teacher> fetched = teacherRepository.findById(saved.getId());
        assertThat(fetched).isPresent();
        assertThat(fetched.get().getFirstName()).isEqualTo("Alice");

        // UPDATE
        saved.setPhoneNumber("081-999-8888");
        Teacher updated = teacherRepository.save(saved);
        assertThat(updated.getPhoneNumber()).isEqualTo("081-999-8888");

        // DELETE
        teacherRepository.delete(updated);
        assertThat(teacherRepository.findById(updated.getId())).isEmpty();
    }
}