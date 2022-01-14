package by.shag.litvinov.api.controller;

import by.shag.litvinov.api.dto.CinemaDto;
import by.shag.litvinov.api.dto.CinemaSearchCriteriaDto;
import by.shag.litvinov.service.CinemaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cinemas")
@Api(tags = "CRUD Cinema Controller")
public class CinemaController {

    @Autowired
    private CinemaService service;

    @ApiOperation(value = "Save cinema (Create)")
    @PostMapping
    public CinemaDto save(@Valid @RequestBody CinemaDto dto) {
        return service.save(dto);
    }

    @ApiOperation(value = "Find cinema by id")
    @GetMapping("/{id}")
    public CinemaDto findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }


    @ApiOperation(value = "Find all and find by search criteria")
    @GetMapping
    public List<CinemaDto> findAll(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "addressId", required = false) Integer addressId,
            @RequestParam(value = "country", required = false) String country,
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "street", required = false) String street,
            @RequestParam(value = "numberOfHall", required = false) Integer numberOfHall,
            @RequestParam(value = "parking", required = false) Boolean parking,
            @RequestParam(value = "cafe", required = false) Boolean cafe
    ) {
        CinemaSearchCriteriaDto criteriaDto = new CinemaSearchCriteriaDto(name, addressId, country, city,
                street, numberOfHall, parking, cafe);
        return service.findAll(criteriaDto);
    }

    //+logger
    @ApiOperation(value = "Update cinema")
    @PutMapping("/{id}")
    public CinemaDto update(@PathVariable("id") Integer id,
                            @Valid @RequestBody CinemaDto dto) {
        return service.update(id, dto);
    }

    //+logger
    @ApiOperation(value = "Delete cinema by id")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        service.deleteById(id);
    }
}
