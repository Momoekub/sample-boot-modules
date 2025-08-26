package th.camt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import th.camt.dto.SchoolDTO;
import th.camt.mapper.SchoolMapper;

import th.mfu.School;
import th.mfu.SchoolRepository;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private SchoolMapper schoolMapper;

    @GetMapping
    public List<SchoolDTO> getAll() {
        return schoolMapper.toDtoList(schoolRepository.findAll());
    }

    @GetMapping("/{id}")
    public SchoolDTO getById(@PathVariable Long id) {
        return schoolRepository.findById(id)
                .map(schoolMapper::toDto)
                .orElse(null);
    }

    @PostMapping
    public SchoolDTO create(@RequestBody SchoolDTO dto) {
        School school = schoolMapper.toEntity(dto);
        schoolRepository.save(school);
        return schoolMapper.toDto(school);
    }

    @PutMapping("/{id}")
    public SchoolDTO update(@PathVariable Long id, @RequestBody SchoolDTO dto) {
        School school = schoolRepository.findById(id).orElseThrow();
        schoolMapper.updateEntityFromDto(dto, school);
        schoolRepository.save(school);
        return schoolMapper.toDto(school);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        schoolRepository.deleteById(id);
    }
}
