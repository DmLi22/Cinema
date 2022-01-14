package by.shag.litvinov.api.controller;

import by.shag.litvinov.api.dto.ArmchairTypeDto;
import by.shag.litvinov.api.dto.ArmchairTypeSearchCriteriaDto;
import by.shag.litvinov.service.ArmchairTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/armchairs-types")
@Api(tags = "CRUD Armchair Controller")
public class ArmchairTypeController {

    @Autowired
    private ArmchairTypeService service;

    @ApiOperation(value = "Save armchair (Create)")
    @PostMapping
    public ArmchairTypeDto save(@Valid @RequestBody ArmchairTypeDto dto) {
        return service.save(dto);
    }

    @ApiOperation(value = "Find armchair by id")
    @GetMapping("/{id}")
    public ArmchairTypeDto findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @ApiOperation(value = "Find all and find by search criteria")
    @GetMapping
    public List<ArmchairTypeDto> findAll(
            @RequestParam(value = "armchairType", required = false) String armchairType,
            @RequestParam(value = "description", required = false) String description
    ) {
        ArmchairTypeSearchCriteriaDto criteriaDto = new ArmchairTypeSearchCriteriaDto(armchairType, description);
        return service.findAll(criteriaDto);
    }

    //+logger
    @ApiOperation(value = "Update armchair")
    @PutMapping("/{id}")
    public ArmchairTypeDto update(@PathVariable("id") Integer id,
                                  @Valid @RequestBody ArmchairTypeDto dto) {
        return service.update(id, dto);
    }

    //+logger
    @ApiOperation(value = "Delete armchair by id")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        service.deleteById(id);
    }
}
