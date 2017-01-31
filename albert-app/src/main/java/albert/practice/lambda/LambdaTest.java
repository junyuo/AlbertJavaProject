package albert.practice.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LambdaTest {

	public static void main(String[] args) {
		LambdaTest test = new LambdaTest();
		log.debug(test.filterData().toString());
		log.debug(test.filterDataWithSort().toString());
	}

	public List<Person> filterData() {
		List<Person> people = createData();
		return people.stream().filter(p -> p.age > 40)
				.collect(Collectors.toList());
	}

	public List<Person> filterDataWithSort() {
		List<Person> people = createData();
		return people.stream().filter(p -> p.age > 40).sorted((p1, p2) -> (p1.age - p2.age)).collect(Collectors.toList());
	}

	public List<Person> createData() {
		List<Person> people = null;
		people = Arrays.asList(new Person("Ben", 70), new Person("Jules", 30),
				new Person("Fiona", 68));
		return people;
	}

	@Data
	@ToString
	@AllArgsConstructor
	@NoArgsConstructor
	private static class Person {
		private String name;
		private int age;
	}

}
