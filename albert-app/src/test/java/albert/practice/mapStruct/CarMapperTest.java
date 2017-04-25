package albert.practice.mapStruct;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import albert.practice.mapStruct.mapper.CarMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CarMapperTest {

	CarMapper carMapper;
	List<Car> cars = new ArrayList<>();

	@Before
	public void setup() {
		carMapper = Mappers.getMapper(CarMapper.class);

		Car car1 = new Car("Benz S350", 5, "2015-01-01");
		Car car2 = new Car("Benz C180", 5, "2016-01-01");
		cars = Arrays.asList(car1, car2);
	}

	@Test
	public void testConvertCarToCarDto() {
		Car car = new Car("Toyota Camry", 5, "2017-04-01");
		CarDto carDto = carMapper.convertCarToCarDto(car);

		log.debug("[testConvertCarToCarDto] car = " + car.toString());
		log.debug("[testConvertCarToCarDto] carDto = " + carDto.toString());

		assertTrue(carDto.getMake().equals(car.getManufacturer()));
		assertTrue(carDto.getNumberOfSeats() == car.getSeatCount());
	}

	@Test
	public void testConvertCarDtoToCar() {
		CarDto carDto = new CarDto("MINI Cooper S", 4, new Date());
		Car car = carMapper.convertCarDtoToCar(carDto);

		log.debug("[testConvertCarDtoToCar] carDto = " + carDto.toString());
		log.debug("[testConvertCarDtoToCar] car = " + car.toString());

		assertTrue(car.getManufacturer().equals(carDto.getMake()));
		assertTrue(car.getSeatCount() == carDto.getNumberOfSeats());
	}

	@Test
	public void testConvertCarsToCarDtos() {
		List<CarDto> carDtos = carMapper.convertCarsToCarDto(cars);
		log.debug("carDtos = " + carDtos.toString());
	}

}
