package by.shag.litvinov.mapping;

import by.shag.litvinov.api.dto.ScheduleDto;
import by.shag.litvinov.jpa.model.Hall;
import by.shag.litvinov.jpa.model.Schedule;
import by.shag.litvinov.jpa.repository.HallRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = HallMapper.class,
        imports = {Instant.class})
public abstract class ScheduleMapper {

    @Autowired
    private HallRepository repository;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "startDateTime", expression = "java(Instant.now())")
    @Mapping(target = "endDateTime", expression = "java(Instant.now())")
    @Mapping(target = "halls", ignore = true)
    public abstract Schedule mapToModel(ScheduleDto scheduleDto);

    @Mapping(target = "halls", ignore = true)
    public abstract ScheduleDto mapToDto(Schedule schedule);

    public abstract List<Schedule> mapListToModel(List<ScheduleDto> scheduleDtoList);

    public abstract List<ScheduleDto> mapListToDto(List<Schedule> scheduleList);

    @AfterMapping
    public void mapHalls(ScheduleDto dto, @MappingTarget Schedule model) {
        Set<Integer> hallsId = dto.getHalls();
        Set<Hall> halls = new HashSet<>();
        for (Integer hallId : hallsId) {
            Hall hall = repository.getOne(hallId);
            halls.add(hall);
        }
        model.setHalls(halls);
    }
}
