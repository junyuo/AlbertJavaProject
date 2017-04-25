package albert.practice.mapStruct.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import albert.practice.mapStruct.Car;
import albert.practice.mapStruct.CarDto;

@Mapper(uses = MfgDateMapper.class)
public interface CarMapper {
	// By convention, a mapper interface should define a member called INSTANCE
	// which holds a single instance of the mapper type:
	CarMapper CarMapper = Mappers.getMapper(CarMapper.class);

	@Mapping(target = "mfgDate", source = "mfgDateString")
	@Mapping(target = "make", source = "manufacturer")
	@Mapping(target = "numberOfSeats", source = "seatCount")
	CarDto convertCarToCarDto(Car car);

	@Mapping(target = "mfgDateString", source = "mfgDate")
	@Mapping(target = "manufacturer", source = "make")
	@Mapping(target = "seatCount", source = "numberOfSeats")
	Car convertCarDtoToCar(CarDto carDto);

	List<CarDto> convertCarsToCarDto(List<Car> cars);
}
