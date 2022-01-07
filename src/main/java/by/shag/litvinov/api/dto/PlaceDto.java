package by.shag.litvinov.api.dto;

import by.shag.litvinov.api.validation.NotFoundSuchArmchairType;
import by.shag.litvinov.api.validation.NotFoundSuchHall;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class PlaceDto {

    @ApiModelProperty(value = "ID", example = "1", position = 1)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;

    @ApiModelProperty(value = "Hall ID", example = "1", required = true, position = 2)
    @NotFoundSuchHall
    private Integer hallId;

    @ApiModelProperty(value = "Armchair type ID", example = "1", required = true, position = 3)
    @NotFoundSuchArmchairType
    private Integer armchairTypeId;

    @ApiModelProperty(value = "Row", example = "1", required = true, position = 4)
    @NotNull(message = "Row must be not null")
    @Min(value = 1, message = "Row must be more than 0")
    private Integer row;

    @ApiModelProperty(value = "Place", example = "1", required = true, position = 5)
    @NotNull(message = "Place must be not null")
    @Min(value = 1, message = "Place must be more than 0")
    private Integer place;
}
