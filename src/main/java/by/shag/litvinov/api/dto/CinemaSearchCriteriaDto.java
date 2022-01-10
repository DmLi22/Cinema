package by.shag.litvinov.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinemaSearchCriteriaDto {

    private String name;

    private Integer addressId;

    private String country;

    private String city;

    private String street;

    private Integer numberOfHall;

    private Boolean parking;

    private Boolean cafe;
}
