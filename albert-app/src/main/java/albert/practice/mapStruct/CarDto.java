package albert.practice.mapStruct;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CarDto {
	private String make;
	private int numberOfSeats;
	private Date mfgDate;
}
