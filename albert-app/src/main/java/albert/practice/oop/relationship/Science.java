package albert.practice.oop.relationship;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Is-A Relation
 */
@Data
@Slf4j
public class Science extends Faculty {
	private Integer bonus = 5000;
	
	public static void main(String[] args) {
		Science object = new Science();
		log.info("Salary is " + object.getSalary());
		log.info("Bonus is " + object.getBonus());
	}
}
