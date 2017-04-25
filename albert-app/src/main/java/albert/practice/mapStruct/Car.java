package albert.practice.mapStruct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Car {
	private String manufacturer;
	private int seatCount;
	private String mfgDateString;
}
