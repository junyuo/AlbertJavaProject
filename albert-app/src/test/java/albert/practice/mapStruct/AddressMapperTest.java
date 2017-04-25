package albert.practice.mapStruct;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import albert.practice.mapStruct.mapper.AddressMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AddressMapperTest {

	private AddressMapper addressMapper;

	@Before
	public void setup() {
		addressMapper = Mappers.getMapper(AddressMapper.class);
	}

	@Test
	public void covertPersonAndAddressToDeliveryAddressDto() {
		Person person = new Person("Albert", "Kuo");
		Address address = new Address("No.7, Sec. 5, Xinyi Rd., Xinyi Dist., Taipei City 110, Taiwan (R.O.C.) ");
		DeliveryAddressDto deliveryDto = addressMapper.covertPersonAndAddressToDeliveryAddressDto(person, address);
		assertTrue("Albert Kuo".equals(deliveryDto.getReceiver()));
		assertTrue("No.7, Sec. 5, Xinyi Rd., Xinyi Dist., Taipei City 110, Taiwan (R.O.C.) ".equals(deliveryDto.getAddressString()));
	}

}
