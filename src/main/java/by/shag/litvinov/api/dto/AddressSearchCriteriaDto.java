package by.shag.litvinov.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressSearchCriteriaDto {

    private Integer id;

    private String country;

    private String city;

    private String street;

    private Integer houseNumber;
}
