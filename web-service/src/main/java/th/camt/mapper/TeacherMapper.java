package th.camt.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import th.mfu.Teacher;
import th.camt.dto.TeacherDTO;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    TeacherDTO toDto(Teacher teacher);

    Teacher toEntity(TeacherDTO dto);

    List<TeacherDTO> toDtoList(List<Teacher> teachers);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(TeacherDTO dto, @MappingTarget Teacher teacher);
}
