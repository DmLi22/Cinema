package by.shag.litvinov.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleSearchCriteriaDto {

    private Integer movieId;

    private String movieName;

    private Instant startDateTime;

    private Instant minStartDateTime;

    private Instant maxStartDateTime;

    private Instant endDateTime;

    private Instant minEndDateTime;

    private Instant maxEndDateTime;
}
