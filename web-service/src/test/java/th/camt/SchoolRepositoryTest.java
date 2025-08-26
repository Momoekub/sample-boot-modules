package th.camt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import th.mfu.School;
import th.mfu.SchoolRepository;

import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SchoolRepositoryTest {

    @Autowired
    private SchoolRepository schoolRepository;

    @Test
    void testCRUD() {
        // CREATE
        School school = new School();
        school.setName("Bangkok International School");
        school.setAddress("123 Sukhumvit Rd, Bangkok");
        school.setPhoneNumber("02-123-4567");
        School saved = schoolRepository.save(school);

        assertThat(saved.getId()).isNotNull();

        // READ
        Optional<School> fetched = schoolRepository.findById(saved.getId());
        assertThat(fetched).isPresent();
        assertThat(fetched.get().getName()).isEqualTo("Bangkok International School");

        // UPDATE
        saved.setPhoneNumber("02-999-9999");
        School updated = schoolRepository.save(saved);
        assertThat(updated.getPhoneNumber()).isEqualTo("02-999-9999");

        // DELETE
        schoolRepository.delete(updated);
        assertThat(schoolRepository.findById(updated.getId())).isEmpty();
    }
}
