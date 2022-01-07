package by.shag.litvinov.api.dto;

import by.shag.litvinov.api.validation.NotFoundSuchHall;
import by.shag.litvinov.api.validation.NotFoundSuchSchedule;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class HallsSchedulesDto {

    @ApiModelProperty(value = "Hall ID", example = "1", required = true, position = 1)
    @NotFoundSuchHall
    private Integer hallId;

    @ApiModelProperty(value = "Schedule ID", example = "1", required = true, position = 2)
    @NotFoundSuchSchedule
    private Integer scheduleId;
}
