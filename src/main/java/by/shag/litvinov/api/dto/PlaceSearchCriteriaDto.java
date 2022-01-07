package by.shag.litvinov.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceSearchCriteriaDto {

    private Integer id;

    private Integer hallId;

    private Integer armchairTypeId;

    private Integer row;

    private Integer place;
}
