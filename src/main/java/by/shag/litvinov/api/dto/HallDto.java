package by.shag.litvinov.api.dto;

import by.shag.litvinov.api.validation.NotFoundSuchCinema;
import by.shag.litvinov.jpa.model.Schedule;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
public class HallDto {

    @ApiModelProperty(value = "id", example = "1", position = 1)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;

    @ApiModelProperty(value = "Cinema id", example = "1", required = true, position = 2)
    @NotFoundSuchCinema
    private Integer cinemaId;

    @ApiModelProperty(value = "3D", example = "true", required = true, position = 3)
    @NotNull(message = "3D must be not null")
    private Boolean three3D;

    @ApiModelProperty(value = "Dolby Atmos Sound", example = "true", required = true, position = 4)
    @NotNull(message = "Dolby Atmos Sound must be not null")
    private Boolean dolbyAtmosSound;

    @ApiModelProperty(value = "Number Of Seats", example = "1", required = true, position = 5)
    @NotNull(message = "Number Of Seats must be not null")
    @Min(value = 1, message = "Number Of Seats must be more than 0")
    private Integer numberOfSeats;

    @ApiModelProperty(value = "Number Of Person", example = "1", required = true, position = 6)
    @NotNull(message = "Number Of Person must be not null")
    @Min(value = 1, message = "Number Of Person must be more than 0")
    private Integer numberOfPerson;

    @ApiModelProperty(value = "Deluxe", example = "true", required = true, position = 7)
    @NotNull(message = "Deluxe must be not null")
    private Boolean deluxe;

    // @ApiModelProperty итд не забудь!
    private Set<ScheduleDto> schedules/*DtoSet*/ = new HashSet<>();
}
