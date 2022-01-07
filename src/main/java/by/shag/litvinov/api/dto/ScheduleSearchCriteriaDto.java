package by.shag.litvinov.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleSearchCriteriaDto {

    private Integer id;

    private Integer movieId;

    private Instant startDateTime;

    private Instant endDateTime;
}
