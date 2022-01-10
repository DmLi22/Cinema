package by.shag.litvinov.service;

import by.shag.litvinov.api.dto.AddressDto;
import by.shag.litvinov.api.dto.AddressSearchCriteriaDto;
import by.shag.litvinov.exception.EntityDuplicationException;
import by.shag.litvinov.exception.EntityNotFoundException;
import by.shag.litvinov.exception.EntityServiceException;
import by.shag.litvinov.jpa.model.Address;
import by.shag.litvinov.jpa.repository.AddressRepository;
import by.shag.litvinov.mapping.AddressMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static by.shag.litvinov.jpa.specification.AddressSpecificationUtils.findBySearchCriteria;

@Service
@RequiredArgsConstructor
@Transactional
public class AddressService {

    @Autowired
    private AddressRepository repository;
    @Autowired
    private AddressMapper mapper;

    public AddressDto save(AddressDto dto) {
        validateAlreadyExists(null, dto);
        Address model = mapper.mapToModel(dto);
        Address saved = repository.save(model);
        return mapper.mapToDto(saved);
    }

    public AddressDto findById(Integer id) {
        Optional<Address> model = repository.findById(id);
        return mapper.mapToDto(model.orElseThrow(() -> new EntityServiceException("Address with ID = " + id + " not found")));
    }

    public List<AddressDto> findAll(AddressSearchCriteriaDto criteriaDto) {
        return mapper.mapListToDto(repository.findAll(findBySearchCriteria(criteriaDto)));
    }

    public AddressDto update(Integer id, AddressDto dto) {
        validateAlreadyExists(id, dto);
        Address model = mapper.mapToModel(dto).setId(id);
        Address updated = repository.save(model);
        return mapper.mapToDto(updated);
    }

    public void deleteById(Integer id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Address with ID = " + id + " cannot be deleted (not found)");
        }
    }

    private void validateAlreadyExists(Integer id, AddressDto dto) {
        Optional<Address> model = repository.findByCountryAndCityAndStreetAndHouseNumber(dto.getCountry(),
                dto.getCity(), dto.getStreet(), dto.getHouseNumber());
        if (model.isPresent() && !model.get().getId().equals(id)) {
            throw new EntityDuplicationException("Exception The record with country " + dto.getCountry() +
                    ", city" + dto.getCity() + ", street" + dto.getStreet() +
                    ", house number()" + dto.getHouseNumber() + "already exists");
        }
    }
}
