package by.shag.litvinov.mapping;

import by.shag.litvinov.api.dto.HallsSchedulesDto;
import by.shag.litvinov.jpa.model.HallsSchedules;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface HallsSchedulesMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "hall", ignore = true)
    @Mapping(target = "schedule", ignore = true)
    HallsSchedules mapToModel(HallsSchedulesDto hallsSchedulesDto);

    @Mapping(target = "hallId", source = "hall.id")
    @Mapping(target = "scheduleId", source = "schedule.id")
    HallsSchedulesDto mapToDto(HallsSchedules hallsSchedulesJpa);

    List<HallsSchedules> mapListToModel(List<HallsSchedulesDto> hallsSchedulesDtoList);

    List<HallsSchedulesDto> mapListToDto(List<HallsSchedules> hallsSchedulesList);
}
