package albert.practice.oop.relationship;

import lombok.extern.slf4j.Slf4j;

/**
 * https://stackoverflow.com/questions/21967841/aggregation-vs-composition-vs-association-vs-direct-association
 * http://beginnersbook.com/2013/05/association/
 * http://www.codedata.com.tw/java/umltutorial-03/
 * @author albert
 *
 */
@Slf4j
public class Person {

	// composition has-a relationship
	private Job job;

	public Person() {
		this.job = new Job();
		job.setSalary(1000L);
	}

	public long getSalary() {
		return job.getSalary();
	}

	public static void main(String[] args) {
		Person person = new Person();
		log.info("Salary is " + person.getSalary());
	}

}
