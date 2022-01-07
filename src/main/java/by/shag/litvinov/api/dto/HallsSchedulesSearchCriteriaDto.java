package by.shag.litvinov.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HallsSchedulesSearchCriteriaDto {

    private Integer hallId;

    private Integer scheduleId;
}
