package albert.practice.mapStruct.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import albert.practice.mapStruct.Car;
import albert.practice.mapStruct.CarDto;

@Mapper(uses = MfgDateMapper.class)
public interface CarMapper {

	@Mapping(target = "mfgDate", source = "mfgDateString")
	@Mapping(target = "make", source = "manufacturer")
	@Mapping(target = "numberOfSeats", source = "seatCount")
	CarDto convertCarToCarDto(Car car);

	@Mapping(target = "mfgDateString", source = "mfgDate")
	@Mapping(target = "manufacturer", source = "make")
	@Mapping(target = "seatCount", source = "numberOfSeats")
	Car convertCarDtoToCar(CarDto carDto);

}
