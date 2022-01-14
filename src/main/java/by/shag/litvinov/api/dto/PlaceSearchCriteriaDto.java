package by.shag.litvinov.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceSearchCriteriaDto {

    private Integer hallId;

    private Integer armchairTypeId;

    private String armchairType;

    private Integer row;

    private Integer minRow;

    private Integer maxRow;

    private Integer place;

    private Integer minPlace;

    private Integer maxPlace;
}

