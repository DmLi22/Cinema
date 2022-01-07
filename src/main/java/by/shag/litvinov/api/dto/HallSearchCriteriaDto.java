package by.shag.litvinov.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HallSearchCriteriaDto {

    private Integer id;

    private Integer cinemaId;

    private Boolean three3D;

    private Boolean dolbyAtmosSound;

    private Integer numberOfSeats;

    private Integer numberOfPerson;

    private Boolean deluxe;
}
