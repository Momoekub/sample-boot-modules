package th.camt.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import th.mfu.School;
import th.camt.dto.SchoolDTO;

@Mapper(componentModel = "spring")
public interface SchoolMapper {

    SchoolMapper INSTANCE = Mappers.getMapper(SchoolMapper.class);

    @Mapping(target = "principalId", source = "principal.id")
    SchoolDTO toDto(School school);

    @Mapping(target = "principal", ignore = true) // set แยกใน controller/service
    School toEntity(SchoolDTO dto);

    List<SchoolDTO> toDtoList(List<School> schools);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "principal", ignore = true)
    void updateEntityFromDto(SchoolDTO dto, @MappingTarget School school);
}
