package by.shag.litvinov.mapping;

import by.shag.litvinov.api.dto.ArmchairTypeDto;
import by.shag.litvinov.jpa.model.ArmchairType;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ArmchairTypeMapper {

    @Mapping(target = "id", ignore = true)
    ArmchairType mapToModel(ArmchairTypeDto armchairTypeDto);

    @InheritInverseConfiguration
    ArmchairTypeDto mapToDto(ArmchairType armchairTypeJpa);

    List<ArmchairType> mapListToModel(List<ArmchairTypeDto> armchairTypeDtoList);

    List<ArmchairTypeDto> mapListToDto(List<ArmchairType> armchairTypeList);
}
