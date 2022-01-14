package by.shag.litvinov.api.controller;

import by.shag.litvinov.api.dto.AddressDto;
import by.shag.litvinov.api.dto.AddressSearchCriteriaDto;
import by.shag.litvinov.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addresses")
@Api(tags = "CRUD Address Controller")
public class AddressController {

    @Autowired
    private AddressService service;

    @ApiOperation(value = "Save address (Create)")
    @PostMapping
    public AddressDto save(@Valid @RequestBody AddressDto dto) {
        return service.save(dto);
    }

    @ApiOperation(value = "Find address by id")
    @GetMapping("/{id}")
    public AddressDto findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @ApiOperation(value = "Find all and find by search criteria")
    @GetMapping
    public List<AddressDto> findAll(
            @RequestParam(value = "country", required = false) String country,  //???
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "street", required = false) String street,
            @RequestParam(value = "houseNumber", required = false) Integer houseNumber
    ) {
        AddressSearchCriteriaDto criteriaDto = new AddressSearchCriteriaDto(country, city, street, houseNumber);
     return service.findAll(criteriaDto);
    }

    //+logger
    @ApiOperation(value = "Update address")
    @PutMapping("/{id}")
    public AddressDto update(@PathVariable("id") Integer id,
                             @Valid @RequestBody AddressDto dto) {
        return service.update(id, dto);
    }

    //+logger
    @ApiOperation(value = "Delete address by id")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        service.deleteById(id);
    }
}
