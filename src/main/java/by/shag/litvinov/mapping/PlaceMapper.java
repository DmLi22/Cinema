package by.shag.litvinov.mapping;

import by.shag.litvinov.api.dto.PlaceDto;
import by.shag.litvinov.jpa.model.Place;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface PlaceMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "hall.id", source = "hallId")
    @Mapping(target = "armchairType.id", source = "armchairTypeId")
    Place mapToModel(PlaceDto placeDto);

    @Mapping(target = "hallId", source = "hall.id")
    @Mapping(target = "armchairTypeId", source = "armchairType.id")
    PlaceDto mapToDto(Place place);

    List<Place> mapListToModel(List<PlaceDto> placeDtoList);

    List<PlaceDto> mapListToDto(List<Place> placeList);
}
