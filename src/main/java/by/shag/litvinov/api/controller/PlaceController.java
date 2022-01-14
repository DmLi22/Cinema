package by.shag.litvinov.api.controller;

import by.shag.litvinov.api.dto.AddressDto;
import by.shag.litvinov.api.dto.PlaceDto;
import by.shag.litvinov.api.dto.PlaceSearchCriteriaDto;
import by.shag.litvinov.service.PlaceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/places")
@Api(tags = "CRUD Place Controller")
public class PlaceController {

    @Autowired
    private PlaceService service;

    @ApiOperation(value = "Save place (Create)")
    @PostMapping
    public PlaceDto save(@Valid @RequestBody PlaceDto dto) {
        return service.save(dto);
    }

    @ApiOperation(value = "Find place by id")
    @GetMapping("/{id}")
    public PlaceDto findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @ApiOperation(value = "Find all and find by search criteria")
    @GetMapping
    public List<PlaceDto> findAll(
            @RequestParam(value = "hallId", required = false) Integer hallId,
            @RequestParam(value = "armchairTypeId", required = false) Integer armchairTypeId,
            @RequestParam(value = "armchairType", required = false) String armchairType,
            @RequestParam(value = "row", required = false) Integer row,
            @RequestParam(value = "minRow", required = false) Integer minRow,
            @RequestParam(value = "maxRow", required = false) Integer maxRow,
            @RequestParam(value = "place", required = false) Integer place,
            @RequestParam(value = "minPlace", required = false) Integer minPlace,
            @RequestParam(value = "maxPlace", required = false) Integer maxPlace
    ) {
        PlaceSearchCriteriaDto criteriaDto = new PlaceSearchCriteriaDto(hallId, armchairTypeId, armchairType, row,
                minRow, maxRow, place, minPlace, maxPlace);
        return service.findAll(criteriaDto);
    }

    //+logger
    @ApiOperation(value = "Update place")
    @PutMapping("/{id}")
    public PlaceDto update(@PathVariable("id") Integer id,
                             @Valid @RequestBody PlaceDto dto) {
        return service.update(id, dto);
    }

    //+logger
    @ApiOperation(value = "Delete place by id")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        service.deleteById(id);
    }
}
