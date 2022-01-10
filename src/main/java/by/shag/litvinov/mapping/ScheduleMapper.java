package by.shag.litvinov.mapping;

import by.shag.litvinov.api.dto.ScheduleDto;
import by.shag.litvinov.jpa.model.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.time.Instant;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, imports = {Instant.class})
public interface ScheduleMapper {

    @Mapping(target = "id", ignore = true)
    //@Mapping(target = "movie", ignore = true)
    @Mapping(target = "startDateTime", expression = "java(Instant.now())")
    @Mapping(target = "endDateTime", expression = "java(Instant.now())")
    Schedule mapToModel(ScheduleDto scheduleDto);


    //@Mapping(target = "movieId", source = "movie.id")
    ScheduleDto mapToDto(Schedule schedule);

    List<Schedule> mapListToModel(List<ScheduleDto> scheduleDtoList);

    List<ScheduleDto> mapListToDto(List<Schedule> scheduleList);
}
