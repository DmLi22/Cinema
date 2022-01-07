package by.shag.litvinov.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.Instant;

@Data
public class ScheduleDto {

    @ApiModelProperty(value = "ID", example = "1", position = 1)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;

    @ApiModelProperty(value = "Movie ID", example = "1", required = true, position = 2)
    @NotNull(message = "Movie ID must be not null")
    @Min(value = 1, message = "Movie ID must be more than 0")
    private Integer movieId;

    @ApiModelProperty(value = "Show start date and time", example = "2022-01-07T14:00:00.0Z", required = true, position = 3)
    @NotNull(message = "Show start date and time must be not null")
    @Past(message = "Show start date and time cannot be later than current date and time")
    private Instant startDateTime;

    @ApiModelProperty(value = "Show end date and time", example = "2022-01-07T16:00:00.0Z", required = true, position = 4)
    @NotNull(message = "Show end date and time must be not null")
    @Past(message = "Show end date and time cannot be later than current date and time")
    private Instant endDateTime;
}
