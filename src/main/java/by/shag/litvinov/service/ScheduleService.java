package by.shag.litvinov.service;

import by.shag.litvinov.api.dto.ScheduleDto;
import by.shag.litvinov.api.dto.ScheduleSearchCriteriaDto;
import by.shag.litvinov.exception.EntityNotFoundException;
import by.shag.litvinov.exception.EntityServiceException;
import by.shag.litvinov.jpa.model.Schedule;
import by.shag.litvinov.jpa.repository.ScheduleRepository;
import by.shag.litvinov.mapping.ScheduleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static by.shag.litvinov.jpa.specification.ScheduleSpecificationUtils.findBySearchCriteria;

@Service
@RequiredArgsConstructor
@Transactional
public class ScheduleService {

    @Autowired
    private ScheduleRepository repository;
    @Autowired
    private ScheduleMapper mapper;

    public ScheduleDto save(ScheduleDto dto) {
        Schedule model = mapper.mapToModel(dto);
        Schedule saved = repository.save(model);
        return mapper.mapToDto(saved);
    }

    public ScheduleDto findById(Integer id) {
        Optional<Schedule> model = repository.findById(id);
        return mapper.mapToDto(model.orElseThrow(() -> new EntityServiceException("Schedule with ID = " + id + " not found")));
    }

    public List<ScheduleDto> findAll(ScheduleSearchCriteriaDto criteriaDto) {
        return mapper.mapListToDto(repository.findAll(findBySearchCriteria(criteriaDto)));
    }

    public List<ScheduleDto> findByStartDateTimeBetween(Instant minStartDateTime, Instant maxStartDateTime) {
        List<Schedule> scheduleList = repository.findByStartDateTimeBetween(minStartDateTime, maxStartDateTime);
        return mapper.mapListToDto(scheduleList);
    }

    public List<ScheduleDto> findByEndDateTimeBetween(Instant minEndDateTime, Instant maxEndDateTime) {
        List<Schedule> scheduleList = repository.findByEndDateTimeBetween(minEndDateTime, maxEndDateTime);
        return mapper.mapListToDto(scheduleList);
    }

    public ScheduleDto update(Integer id, ScheduleDto dto) {
        Schedule model = mapper.mapToModel(dto).setId(id);
        Schedule updated = repository.save(model);
        return mapper.mapToDto(updated);
    }

    public void deleteById(Integer id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Schedule with ID = " + id + " cannot be deleted (not found)");
        }
    }
}
