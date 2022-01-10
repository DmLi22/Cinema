package by.shag.litvinov.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HallSearchCriteriaDto {

    private Integer cinemaId;

    private String cinemaName;

    private Boolean three3D;

    private Boolean dolbyAtmosSound;

    private Integer numberOfSeats;

    private Integer minNumberOfSeats;

    private Integer maxNumberOfSeats;

    private Integer numberOfPerson;

    private Integer minNumberOfPerson;

    private Integer maxNumberOfPerson;

    private Boolean deluxe;
}
