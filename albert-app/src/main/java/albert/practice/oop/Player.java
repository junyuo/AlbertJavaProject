package albert.practice.oop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Slf4j
/**
 * Encapsulation in Java is a mechanism of wrapping the data (variables) and
 * code acting on the data (methods) together as a single unit. In
 * encapsulation, the variables of a class will be hidden from other classes,
 * and can be accessed only through the methods of their current class.
 * Therefore, it is also known as data hiding.
 * 
 * To achieve encapsulation in Java −<br>
 * (1) Declare the variables of a class as private.<br>
 * (2) Provide public setter and getter methods to modify and view the variables
 * values.<br>
 */
public class Player {

	/**
	 * 球衣號碼
	 */
	private Integer jerseyNumber;

	/**
	 * 球員姓名
	 */
	private String name;

	public static void main(String[] args) {
		// this is object
		Player curry = new Player(30, "Stephen Curry");
		Player durant = new Player(35, "Kevin Durant");

		log.info("curry = " + curry.toString());
		log.info("durant = " + durant.toString());
	}

}
