package albert.practice.mapStruct.decorator;

import java.text.DecimalFormat;

import albert.practice.mapStruct.Address;
import albert.practice.mapStruct.DeliveryAddressDto;
import albert.practice.mapStruct.Person;
import albert.practice.mapStruct.ShoppingItems;
import albert.practice.mapStruct.mapper.AddressMapper;

public class AddressDecorator implements AddressMapper {

	private final AddressMapper delegate;
	private DecimalFormat decimalFormat = new DecimalFormat( "NT$#,###,###,##0" );

	public AddressDecorator(AddressMapper delegate) {
		this.delegate = delegate;
	}

	@Override
	public DeliveryAddressDto covertPersonAndAddressToDeliveryAddressDto(Person person, Address address,
			ShoppingItems shoppingItems) {
		DeliveryAddressDto dto = delegate.covertPersonAndAddressToDeliveryAddressDto(person, address, shoppingItems);
		dto.setReceiver(person.getFirstName() + " " + person.getLastName());
		dto.setTotalString(decimalFormat.format(shoppingItems.getTotal()));
		return dto;
	}

}
