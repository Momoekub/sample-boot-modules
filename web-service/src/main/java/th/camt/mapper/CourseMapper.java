package th.camt.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import th.mfu.Course;
import th.camt.dto.CourseDTO;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    @Mapping(target = "teacherId", source = "teacher.id")
    CourseDTO toDto(Course course);

    @Mapping(target = "teacher", ignore = true)
    Course toEntity(CourseDTO dto);

    List<CourseDTO> toDtoList(List<Course> courses);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "teacher", ignore = true)
    void updateEntityFromDto(CourseDTO dto, @MappingTarget Course course);
}
