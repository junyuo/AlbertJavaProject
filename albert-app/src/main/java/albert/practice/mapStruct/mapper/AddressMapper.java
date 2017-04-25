package albert.practice.mapStruct.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import albert.practice.mapStruct.Address;
import albert.practice.mapStruct.DeliveryAddressDto;
import albert.practice.mapStruct.Person;
import albert.practice.mapStruct.decorator.NameDecorator;

@Mapper
@DecoratedWith(NameDecorator.class)
public interface AddressMapper {
	
	AddressMapper INSTANCE = Mappers.getMapper( AddressMapper.class );

	@Mapping(target = "receiver", source = "person.lastName")
	@Mapping(target = "addressString", source = "address.addressString")
	DeliveryAddressDto covertPersonAndAddressToDeliveryAddressDto(Person person, Address address);
	
}
