package by.shag.litvinov.mapping;

import by.shag.litvinov.api.dto.AddressDto;
import by.shag.litvinov.jpa.model.Address;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AddressMapper {

    @Mapping(target = "id", ignore = true)
    Address mapToModel(AddressDto addressDto);

    AddressDto mapToDto(Address address);

    List<Address> mapListToModel(List<AddressDto> addressDtoList);

    List<AddressDto> mapListToDto(List<Address> addressList);
}
