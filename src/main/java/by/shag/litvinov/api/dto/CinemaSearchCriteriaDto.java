package by.shag.litvinov.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinemaSearchCriteriaDto {

    private Integer id;

    private String name;

    private Integer addressId;

    private Integer numberOfHall;

    private Boolean parking;

    private Boolean cafe;
}
