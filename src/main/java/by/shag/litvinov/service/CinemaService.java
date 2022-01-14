package by.shag.litvinov.service;

import by.shag.litvinov.api.dto.CinemaDto;
import by.shag.litvinov.api.dto.CinemaSearchCriteriaDto;
import by.shag.litvinov.exception.EntityDuplicationException;
import by.shag.litvinov.exception.EntityNotFoundException;
import by.shag.litvinov.exception.EntityServiceException;
import by.shag.litvinov.jpa.model.Cinema;
import by.shag.litvinov.jpa.repository.CinemaRepository;
import by.shag.litvinov.mapping.CinemaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static by.shag.litvinov.jpa.specification.CinemaSpecificationUtils.findBySearchCriteria;

@Service
@RequiredArgsConstructor
@Transactional
public class CinemaService {

    @Autowired
    private CinemaRepository repository;
    @Autowired
    private CinemaMapper mapper;

    public CinemaDto save(CinemaDto dto) {
        validateAlreadyExists(null, dto);
        Cinema model = mapper.mapToModel(dto);
        Cinema saved = repository.save(model);
        return mapper.mapToDto(saved);
    }

    public CinemaDto findById(Integer id) {
        Optional<Cinema> model = repository.findById(id);
        return mapper.mapToDto(model.orElseThrow(() -> new EntityServiceException("Cinema with ID = " + id + " not found")));
    }

    public List<CinemaDto> findAll(CinemaSearchCriteriaDto criteriaDto) {
        return mapper.mapListToDto(repository.findAll(findBySearchCriteria(criteriaDto)));
    }

    public CinemaDto update(Integer id, CinemaDto dto) {
        validateAlreadyExists(id, dto);
        Cinema model = mapper.mapToModel(dto).setId(id);
        Cinema updated = repository.save(model);
        return mapper.mapToDto(updated);
    }

    public void deleteById(Integer id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Cinema with ID = " + id + " cannot be deleted (not found)");
        }
    }

    private void validateAlreadyExists(Integer id, CinemaDto dto) {
        Optional<Cinema> model = repository.findByNameAndAddress_Id(dto.getName(), dto.getAddressId());
        if (model.isPresent() && !model.get().getId().equals(id)) {
            throw new EntityDuplicationException("Exception: The record with cinema " + dto.getName() +
                    " and address id" + dto.getAddressId() + "already exists");
        }
    }
}
