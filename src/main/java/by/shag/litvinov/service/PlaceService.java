package by.shag.litvinov.service;

import by.shag.litvinov.api.dto.PlaceDto;
import by.shag.litvinov.api.dto.PlaceSearchCriteriaDto;
import by.shag.litvinov.exception.EntityDuplicationException;
import by.shag.litvinov.exception.EntityNotFoundException;
import by.shag.litvinov.exception.EntityServiceException;
import by.shag.litvinov.jpa.model.Place;
import by.shag.litvinov.jpa.repository.PlaceRepository;
import by.shag.litvinov.mapping.PlaceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static by.shag.litvinov.jpa.specification.PlaceSpecificationUtils.findBySearchCriteria;

@Service
@RequiredArgsConstructor
@Transactional
public class PlaceService {

    @Autowired
    private PlaceRepository repository;
    @Autowired
    private PlaceMapper mapper;

    public PlaceDto save(PlaceDto dto) {
        validateAlreadyExists(null, dto);
        Place model = mapper.mapToModel(dto);
        Place saved = repository.save(model);
        return mapper.mapToDto(saved);
    }

    public PlaceDto findById(Integer id) {
        Optional<Place> model = repository.findById(id);
        return mapper.mapToDto(model.orElseThrow(() -> new EntityServiceException("Place with ID = " + id + " not found")));
    }

    public List<PlaceDto> findAll(PlaceSearchCriteriaDto criteriaDto) {
        return mapper.mapListToDto(repository.findAll(findBySearchCriteria(criteriaDto)));
    }

    // не работает, закоментай IgnoreCase
    public List<PlaceDto> findByArmchairTypeStartingWithOrderByArmchairTypeAsc(String armchairType) {
        List<Place> placeList = repository.findByArmchairTypeStartingWithOrderByArmchairTypeAsc(armchairType);
        return mapper.mapListToDto(placeList);
    }

    public List<PlaceDto> findByRowBetweenOrderByRow(Integer minRow, Integer maxRow) {
        List<Place> placeList = repository.findByRowBetweenOrderByRow(minRow, maxRow);
        return mapper.mapListToDto(placeList);
    }

    public List<PlaceDto> findByPlaceBetweenOrderByPlace(Integer minPlace, Integer maxPlace) {
        List<Place> placeList = repository.findByPlaceBetweenOrderByPlace(minPlace, maxPlace);
        return mapper.mapListToDto(placeList);
    }

    public PlaceDto update(Integer id, PlaceDto dto) {
        validateAlreadyExists(id, dto);
        Place model = mapper.mapToModel(dto).setId(id);
        Place updated = repository.save(model);
        return mapper.mapToDto(updated);
    }

    public void deleteById(Integer id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Place with ID = " + id + " cannot be deleted (not found)");
        }
    }

    private void validateAlreadyExists(Integer id, PlaceDto dto) {
        Optional<Place> model = repository.findByRowAndPlaceOrderByArmchairType(dto.getRow(), dto.getPlace());
        if (model.isPresent() && model.get().getId().equals(id)) {
            throw new EntityDuplicationException("Exception: The record with row " + dto.getRow() +
                    ", place " + dto.getPlace() + " already exist");
        }
    }


}
