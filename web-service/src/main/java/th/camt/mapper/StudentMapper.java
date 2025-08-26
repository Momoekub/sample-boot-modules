package th.camt.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import th.mfu.Student;
import th.camt.dto.StudentDTO;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(target = "schoolId", source = "school.id")
    StudentDTO toDto(Student student);

    @Mapping(target = "school", ignore = true)
    Student toEntity(StudentDTO dto);

    List<StudentDTO> toDtoList(List<Student> students);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "school", ignore = true)
    void updateEntityFromDto(StudentDTO dto, @MappingTarget Student student);
}
