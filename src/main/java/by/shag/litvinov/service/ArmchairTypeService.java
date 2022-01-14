package by.shag.litvinov.service;

import by.shag.litvinov.api.dto.ArmchairTypeDto;
import by.shag.litvinov.api.dto.ArmchairTypeSearchCriteriaDto;
import by.shag.litvinov.exception.EntityDuplicationException;
import by.shag.litvinov.exception.EntityNotFoundException;
import by.shag.litvinov.jpa.model.ArmchairType;
import by.shag.litvinov.jpa.repository.ArmchairTypeRepository;
import by.shag.litvinov.mapping.ArmchairTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static by.shag.litvinov.jpa.specification.ArmchairTypeSpecificationUtils.findBySearchCriteria;

@Service
@RequiredArgsConstructor
@Transactional
public class ArmchairTypeService {

    @Autowired
    private ArmchairTypeRepository repository;
    @Autowired
    private ArmchairTypeMapper mapper;

    public ArmchairTypeDto save(ArmchairTypeDto dto) {
        validateAlreadyExists(null, dto);
        ArmchairType model = mapper.mapToModel(dto);
        ArmchairType saved = repository.save(model);
        return mapper.mapToDto(saved);
    }

    public ArmchairTypeDto findById(Integer id) {
        Optional<ArmchairType> model = repository.findById(id);
        return mapper.mapToDto(model.orElseThrow(() -> new EntityNotFoundException("ArmchairType with ID = " + id + " not found")));
    }

    public List<ArmchairTypeDto> findAll(ArmchairTypeSearchCriteriaDto search) {
        return mapper.mapListToDto(repository.findAll(findBySearchCriteria(search)));
    }
    //если не работает закоментать игноркейс !!!
    public List<ArmchairTypeDto> findByArmchairTypeStartingWithIgnoreCase(String armchairType) {
        List<ArmchairType> modelList = repository.findByArmchairTypeStartingWithIgnoreCase(armchairType);
        return mapper.mapListToDto(modelList);
    }

    public ArmchairTypeDto update(Integer id, ArmchairTypeDto dto) {
        validateAlreadyExists(id, dto);
        ArmchairType model = mapper.mapToModel(dto).setId(id);
        ArmchairType updated = repository.save(model);
        return mapper.mapToDto(updated);
    }

    public void deleteById(Integer id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("ArmchairType with ID = " + id + " cannot be deleted (not found)");
        }
    }

    private void validateAlreadyExists(Integer id, ArmchairTypeDto dto) {
        Optional<ArmchairType> model = repository.findByArmchairType(dto.getArmchairType());
        if (model.isPresent() && !Objects.equals(model.get().getId(), id)) {
            throw new EntityDuplicationException("Exception: The record with armchair type "
                                                 + dto.getArmchairType() + " already exist");
        }
    }
}
