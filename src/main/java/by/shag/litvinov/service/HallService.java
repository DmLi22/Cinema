package by.shag.litvinov.service;

import by.shag.litvinov.api.dto.HallDto;
import by.shag.litvinov.api.dto.HallSearchCriteriaDto;
import by.shag.litvinov.exception.EntityNotFoundException;
import by.shag.litvinov.exception.EntityServiceException;
import by.shag.litvinov.jpa.model.Hall;
import by.shag.litvinov.jpa.repository.HallRepository;
import by.shag.litvinov.mapping.HallMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static by.shag.litvinov.jpa.specification.HallSpecificationUtils.findBySearchCriteria;

@Service
@RequiredArgsConstructor
@Transactional
public class HallService {

    @Autowired
    private HallRepository repository;
    @Autowired
    private HallMapper mapper;

    public HallDto save(HallDto dto) {
        Hall model = mapper.mapToModel(dto);
        Hall saved = repository.save(model);
        return mapper.mapToDto(saved);
    }

    public HallDto findById(Integer id) {
        Optional<Hall> model = repository.findById(id);
        return mapper.mapToDto(model.orElseThrow(() -> new EntityServiceException("Hall with ID = " + id + " not found")));
    }

    public List<HallDto> findAll(HallSearchCriteriaDto criteriaDto) {
        return mapper.mapListToDto(repository.findAll(findBySearchCriteria(criteriaDto)));
    }

    public List<HallDto> findByCinemaNameStartingWithIgnoreCase(String cinemaName) {
        List<Hall> hallList = repository.findByCinemaNameStartingWithIgnoreCase(cinemaName);
        return mapper.mapListToDto(hallList);
    }

    public List<HallDto> findByNumberOfSeatsBetween(Integer minNumberOfSeats, Integer maxNumberOfSeats) {
        List<Hall> hallList = repository.findByNumberOfSeatsBetween(minNumberOfSeats, maxNumberOfSeats);
        return mapper.mapListToDto(hallList);
    }

    public List<HallDto> findByNumberOfPersonBetween (Integer minNumberOfPerson, Integer maxNumberOfPerson) {
        List<Hall> hallList = repository.findByNumberOfPersonBetween(minNumberOfPerson, maxNumberOfPerson);
        return mapper.mapListToDto(hallList);
    }

    public HallDto update(Integer id, HallDto dto) {
//        validateAlreadyExists(id, dto);
        Hall model = mapper.mapToModel(dto).setId(id);
        Hall updated = repository.save(model);
        return mapper.mapToDto(updated);
    }

    public void deleteById(Integer id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Address with ID = " + id + " cannot be deleted (not found)");
        }
    }
}
