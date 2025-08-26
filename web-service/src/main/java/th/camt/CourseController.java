package th.camt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import th.camt.dto.CourseDTO;
import th.camt.mapper.CourseMapper;

import th.mfu.Course;
import th.mfu.CourseRepository;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    @GetMapping
    public List<CourseDTO> getAll() {
        return courseMapper.toDtoList(courseRepository.findAll());
    }

    @GetMapping("/{id}")
    public CourseDTO getById(@PathVariable Long id) {
        return courseRepository.findById(id)
                .map(courseMapper::toDto)
                .orElse(null);
    }

    @PostMapping
    public CourseDTO create(@RequestBody CourseDTO dto) {
        Course course = courseMapper.toEntity(dto);
        courseRepository.save(course);
        return courseMapper.toDto(course);
    }

    @PutMapping("/{id}")
    public CourseDTO update(@PathVariable Long id, @RequestBody CourseDTO dto) {
        Course course = courseRepository.findById(id).orElseThrow();
        courseMapper.updateEntityFromDto(dto, course);
        courseRepository.save(course);
        return courseMapper.toDto(course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        courseRepository.deleteById(id);
    }
}
