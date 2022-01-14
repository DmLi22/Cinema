package by.shag.litvinov.api.controller;

import by.shag.litvinov.api.dto.ScheduleDto;
import by.shag.litvinov.api.dto.ScheduleSearchCriteriaDto;
import by.shag.litvinov.service.ScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/schedules")
@Api(tags = "CRUD Schedule Controller")
public class ScheduleController {

    @Autowired
    private ScheduleService service;

    @ApiOperation(value = "Save schedule (Create)")
    @PostMapping
    public ScheduleDto save(@Valid @RequestBody ScheduleDto dto) {
        return service.save(dto);
    }

    @ApiOperation(value = "Find schedule by id")
    @GetMapping("/{id}")
    public ScheduleDto findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @ApiOperation(value = "Find all and find by search criteria")
    @GetMapping
    public List<ScheduleDto> findAll(
            @RequestParam(value = "movieId", required = false) Integer movieId,
            @RequestParam(value = "movieName", required = false) String movieName,
            @RequestParam(value = "startDateTime", required = false) Instant startDateTime,
            @RequestParam(value = "minStartDateTime", required = false) Instant minStartDateTime,
            @RequestParam(value = "maxStartDateTime", required = false) Instant maxStartDateTime,
            @RequestParam(value = "endDateTime", required = false) Instant endDateTime,
            @RequestParam(value = "minEndDateTime", required = false) Instant minEndDateTime,
            @RequestParam(value = "maxEndDateTime", required = false) Instant maxEndDateTime
    ) {
        ScheduleSearchCriteriaDto criteriaDto = new ScheduleSearchCriteriaDto(movieId, movieName, startDateTime,
                minStartDateTime, maxStartDateTime, endDateTime, minEndDateTime, maxEndDateTime);
        return service.findAll(criteriaDto);
    }

    //+logger
    @ApiOperation(value = "Update schedule")
    @PutMapping("/{id}")
    public ScheduleDto update(@PathVariable("id") Integer id,
                              @Valid @RequestBody ScheduleDto dto) {
        return service.update(id, dto);
    }

    //+logger
    @ApiOperation(value = "Delete schedule by id")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        service.deleteById(id);
    }
}
