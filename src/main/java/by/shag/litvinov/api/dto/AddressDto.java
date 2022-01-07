package by.shag.litvinov.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AddressDto {

    @ApiModelProperty(value = "id", example = "1", position = 1)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;

    @ApiModelProperty(value = "Country", example = "Poland", required = true, position = 2)
    @NotBlank(message = "Country must be not null, and not empty")
    private String country;

    @ApiModelProperty(value = "City", example = "Wroclaw", required = true, position = 3)
    @NotBlank(message = "City must be not null, and not empty")
    private String city;

    @ApiModelProperty(value = "Street", example = "Pomorska", required = true, position = 4)
    @NotBlank(message = "Street must be not null, and not empty")
    private String street;

    @ApiModelProperty(value = "House number", example = "1", required = true, position = 5)
    @NotNull(message = "House number must be not null")
    @Min(value = 1, message = "House number must be more than 0")
    private Integer houseNumber;
}
