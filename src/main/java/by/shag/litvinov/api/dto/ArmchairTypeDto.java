package by.shag.litvinov.api.dto;

import by.shag.litvinov.jpa.model.ArmchairTypeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ArmchairTypeDto {

    @ApiModelProperty(value = "ID", example = "1", position = 1)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;

    @ApiModelProperty(value = "Armchair type", example = "Seat", required = true, position = 2)
    @NotBlank(message = "Armchair type must be not null and not empty")
    private ArmchairTypeEnum armchairType;
}
