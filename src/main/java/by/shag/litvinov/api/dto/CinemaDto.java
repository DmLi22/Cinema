package by.shag.litvinov.api.dto;

import by.shag.litvinov.api.validation.NotFoundSuchAddress;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CinemaDto {

    @ApiModelProperty(value = "id", example = "1", position = 1)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;

    @ApiModelProperty(value = "Name", example = "Central Cinema", required = true, position = 2)
    @NotBlank(message = "Name must be not null and not empty")
    private String name;

    @ApiModelProperty(value = "Address id", example = "1", required = true, position = 3)
    @NotFoundSuchAddress
    private Integer addressId;

    @ApiModelProperty(value = "Number Of Hall", example = "1", required = true, position = 4)
    @NotNull(message = "Number Of Hall must be not null")
    @Min(value = 1, message = "Number Of Hall must be more than 0")
    private Integer numberOfHall;

    @ApiModelProperty(value = "Parking", example = "true", required = true, position = 5)
    @NotNull(message = "Parking must be not null")
    private Boolean parking;

    @ApiModelProperty(value = "Cafe", example = "true", required = true, position = 6)
    @NotNull(message = "Cafe must be not null")
    private Boolean cafe;
}
