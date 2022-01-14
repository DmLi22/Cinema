package by.shag.litvinov.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ArmchairTypeDto {

    @ApiModelProperty(value = "ID", example = "1", position = 1)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;

    @ApiModelProperty(value = "Armchair type", example = "Chair", required = true, position = 2)
    @NotBlank(message = "Armchair type must be not null and not empty")
    private String armchairType;

    @ApiModelProperty(value = "Description", example = "Standard chair", required = true, position = 3)
    @NotBlank(message = "Description must be not null and not empty")
    private String description;
}
