package by.shag.litvinov.mapping;

import by.shag.litvinov.api.dto.ScheduleDto;
import by.shag.litvinov.jpa.model.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.time.Instant;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = HallMapper.class,
        imports = {Instant.class})
public interface ScheduleMapper {

    @Mapping(target = "id", ignore = true)
    //@Mapping(target = "movie", ignore = true)
    @Mapping(target = "startDateTime", expression = "java(Instant.now())")
    @Mapping(target = "endDateTime", expression = "java(Instant.now())")
//    @Mapping(target = "halls", source = "hallDtoSet")
//    @Mapping(target = "schedule.id", source = "scheduleId")
//    @Mapping(target = "halls.id", source = "hallsId")
    @Mapping(target = "halls", ignore = true)
    Schedule mapToModel(ScheduleDto scheduleDto);


    //@Mapping(target = "movieId", source = "movie.id")
//    @Mapping(target = "hallDtoSet", source = "halls")  //this
//    @Mapping(target = "scheduleId", source = "schedule.id")
//    @Mapping(target = "hallsId", source = "halls.Id")
    @Mapping(target = "halls", ignore = true)
    ScheduleDto mapToDto(Schedule schedule);

    List<Schedule> mapListToModel(List<ScheduleDto> scheduleDtoList);

    List<ScheduleDto> mapListToDto(List<Schedule> scheduleList);
}
