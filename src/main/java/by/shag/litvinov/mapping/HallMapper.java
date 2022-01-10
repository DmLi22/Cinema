package by.shag.litvinov.mapping;

import by.shag.litvinov.api.dto.HallDto;
import by.shag.litvinov.jpa.model.Hall;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface HallMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cinema", ignore = true)
    Hall mapToModel(HallDto hallDto);

    @Mapping(target = "cinemaId", source = "cinema.id")
    HallDto mapToDto(Hall hall);

    List<Hall> mapListToModel(List<HallDto> hallDtoList);

    List<HallDto> mapListToDto(List<Hall> hallList);
}
