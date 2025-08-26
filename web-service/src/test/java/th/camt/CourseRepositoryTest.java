package th.camt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import th.mfu.Course;
import th.mfu.CourseRepository;
import th.mfu.Teacher;
import th.mfu.TeacherRepository;

import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    void testCRUD() {
        // CREATE teacher first
        Teacher t = new Teacher("Alice", "Smith", "alice@email.com", "081-111-2222", "Math");
        t = teacherRepository.save(t);

        // CREATE course
        Course c = new Course("Algebra", "MATH101", "Basic Algebra Course", 3, t);
        Course saved = courseRepository.save(c);
        assertThat(saved.getId()).isNotNull();

        // READ
        Optional<Course> fetched = courseRepository.findById(saved.getId());
        assertThat(fetched).isPresent();
        assertThat(fetched.get().getName()).isEqualTo("Algebra");

        // UPDATE
        saved.setCredits(4);
        Course updated = courseRepository.save(saved);
        assertThat(updated.getCredits()).isEqualTo(4);

        // DELETE
        courseRepository.delete(updated);
        assertThat(courseRepository.findById(updated.getId())).isEmpty();
    }
}