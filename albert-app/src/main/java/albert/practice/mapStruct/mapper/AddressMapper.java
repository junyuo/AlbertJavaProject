package albert.practice.mapStruct.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import albert.practice.mapStruct.Address;
import albert.practice.mapStruct.DeliveryAddressDto;
import albert.practice.mapStruct.Person;
import albert.practice.mapStruct.ShoppingItems;
import albert.practice.mapStruct.decorator.AddressDecorator;

@Mapper
@DecoratedWith(AddressDecorator.class)
public interface AddressMapper {
	// By convention, a mapper interface should define a member called INSTANCE
	// which holds a single instance of the mapper type:
	AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

	@Mapping(target = "totalString", source = "shoppingItems.total")
	@Mapping(target = "receiver", source = "person.lastName")
	@Mapping(target = "addressString", source = "address.addressString")
	DeliveryAddressDto covertPersonAndAddressToDeliveryAddressDto(Person person, Address address,
			ShoppingItems shoppingItems);

}
