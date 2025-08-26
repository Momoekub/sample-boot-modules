package th.camt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import th.camt.dto.StudentDTO;
import th.camt.mapper.StudentMapper;
import th.mfu.Student;
import th.mfu.StudentRepository;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping
    public List<StudentDTO> getAll() {
        return studentMapper.toDtoList(studentRepository.findAll());
    }

    @GetMapping("/{id}")
    public StudentDTO getById(@PathVariable Long id) {
        return studentRepository.findById(id)
                .map(studentMapper::toDto)
                .orElse(null);
    }

    @PostMapping
    public StudentDTO create(@RequestBody StudentDTO dto) {
        Student student = studentMapper.toEntity(dto);
        studentRepository.save(student);
        return studentMapper.toDto(student);
    }

    @PutMapping("/{id}")
    public StudentDTO update(@PathVariable Long id, @RequestBody StudentDTO dto) {
        Student student = studentRepository.findById(id).orElseThrow();
        studentMapper.updateEntityFromDto(dto, student);
        studentRepository.save(student);
        return studentMapper.toDto(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }
}
