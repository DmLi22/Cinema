package by.shag.litvinov.mapping;

import by.shag.litvinov.api.dto.CinemaDto;
import by.shag.litvinov.jpa.model.Cinema;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CinemaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    Cinema mapToModel(CinemaDto cinemaDto);

    @Mapping(target = "addressId", source = "address.id")
    CinemaDto mapToDto(Cinema cinema);

    List<Cinema> mapListToModel(List<CinemaDto> cinemaDtoList);

    List<CinemaDto> mapListToDto(List<Cinema> cinemaList);
}
