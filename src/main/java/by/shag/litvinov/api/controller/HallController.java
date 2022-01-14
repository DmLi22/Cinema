package by.shag.litvinov.api.controller;

import by.shag.litvinov.api.dto.HallDto;
import by.shag.litvinov.api.dto.HallSearchCriteriaDto;
import by.shag.litvinov.service.HallService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/halls")
@Api(tags = "CRUD Hall Controller")
public class HallController {

    @Autowired
    private HallService service;

    @ApiOperation(value = "Save hall (Create)")
    @PostMapping
    public HallDto save(@Valid @RequestBody HallDto dto) {
        return service.save(dto);
    }

    @ApiOperation(value = "Find hall by id")
    @GetMapping("/{id}")
    public HallDto findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @ApiOperation(value = "Find all and find by search criteria")
    @GetMapping
    public List<HallDto> findAll(
            @RequestParam(value = "cinemaId", required = false) Integer cinemaId,
            @RequestParam(value = "cinemaName", required = false) String cinemaName,
            @RequestParam(value = "three3D", required = false) Boolean three3D,
            @RequestParam(value = "dolbyAtmosSound", required = false) Boolean dolbyAtmosSound,
            @RequestParam(value = "numberOfSeats", required = false) Integer numberOfSeats,
            @RequestParam(value = "minNumberOfSeats", required = false) Integer minNumberOfSeats,
            @RequestParam(value = "maxNumberOfSeats", required = false) Integer maxNumberOfSeats,
            @RequestParam(value = "numberOfPerson", required = false) Integer numberOfPerson,
            @RequestParam(value = "minNumberOfPerson", required = false) Integer minNumberOfPerson,
            @RequestParam(value = "maxNumberOfPerson", required = false) Integer maxNumberOfPerson,
            @RequestParam(value = "deluxe", required = false) Boolean deluxe
    ) {
        HallSearchCriteriaDto criteriaDto = new HallSearchCriteriaDto(cinemaId, cinemaName, three3D, dolbyAtmosSound,
                numberOfSeats, minNumberOfSeats, maxNumberOfSeats, numberOfPerson, minNumberOfPerson, maxNumberOfPerson,
                deluxe);
        return service.findAll(criteriaDto);
    }

    //+logger
    @ApiOperation(value = "Update hall")
    @PutMapping("/{id}")
    public HallDto update(@PathVariable("id") Integer id,
                          @Valid @RequestBody HallDto dto) {
        return service.update(id, dto);
    }

    //+logger
    @ApiOperation(value = "Delete hall by id")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        service.deleteById(id);
    }
}
