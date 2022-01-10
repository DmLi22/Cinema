package by.shag.litvinov.api.dto;

import by.shag.litvinov.jpa.model.ArmchairTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArmchairTypeSearchCriteriaDto {

    private ArmchairTypeEnum armchairType;
}
