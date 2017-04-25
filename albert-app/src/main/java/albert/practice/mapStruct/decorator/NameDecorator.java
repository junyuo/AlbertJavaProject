package albert.practice.mapStruct.decorator;

import albert.practice.mapStruct.Address;
import albert.practice.mapStruct.DeliveryAddressDto;
import albert.practice.mapStruct.Person;
import albert.practice.mapStruct.mapper.AddressMapper;

public class NameDecorator implements AddressMapper {

	private final AddressMapper delegate;

	public NameDecorator(AddressMapper delegate) {
		this.delegate = delegate;
	}

	@Override
	public DeliveryAddressDto covertPersonAndAddressToDeliveryAddressDto(Person person, Address address) {
		DeliveryAddressDto dto = delegate.covertPersonAndAddressToDeliveryAddressDto(person, address);
		dto.setReceiver(person.getFirstName() + " " + person.getLastName());
		return dto;
	}

}
