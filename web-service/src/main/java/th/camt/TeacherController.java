package th.camt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import th.camt.dto.TeacherDTO;
import th.camt.mapper.TeacherMapper;
import th.mfu.Teacher;
import th.mfu.TeacherRepository;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherMapper teacherMapper;

    @GetMapping
    public List<TeacherDTO> getAll() {
        return teacherMapper.toDtoList(teacherRepository.findAll());
    }

    @GetMapping("/{id}")
    public TeacherDTO getById(@PathVariable Long id) {
        return teacherRepository.findById(id)
                .map(teacherMapper::toDto)
                .orElse(null);
    }

    @PostMapping
    public TeacherDTO create(@RequestBody TeacherDTO dto) {
        Teacher teacher = teacherMapper.toEntity(dto);
        teacherRepository.save(teacher);
        return teacherMapper.toDto(teacher);
    }

    @PutMapping("/{id}")
    public TeacherDTO update(@PathVariable Long id, @RequestBody TeacherDTO dto) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow();
        teacherMapper.updateEntityFromDto(dto, teacher);
        teacherRepository.save(teacher);
        return teacherMapper.toDto(teacher);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        teacherRepository.deleteById(id);
    }
}
