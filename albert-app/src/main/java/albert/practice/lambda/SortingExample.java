package albert.practice.lambda;

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SortingExample {

	public static void main(String[] args) {
		SortingExample test = new SortingExample();
		List<String> fruits = test.getFruits();
		log.debug("fruits = " + fruits.toString());

		fruits.sort((x, y) -> {
			return x.compareTo(y);
		});
		log.debug("fruits (A-z) = " + fruits.toString());

		fruits.sort((x, y) -> {
			return x.compareToIgnoreCase(y);
		});
		log.debug("fruits (Ignoring case) = " + fruits.toString());

		List<User> users = test.getUsers();
		log.debug("users = " + users.toString());
		users.sort((x, y)->{
			return x.getLastName().compareToIgnoreCase(y.getLastName());
		});
		log.debug("users (sory by last name, ignoring case) = " + users.toString());
		
		Comparator<User> byLastName = comparing(User::getLastName);
		users.sort(byLastName.thenComparing(User::getFirstName).thenComparing(User::getAge));
		log.debug(users.toString());
	}

	private List<String> getFruits() {
		return Arrays.asList("apple", "Guava", "Orange", "mango", "grapes");
	}

	private List<User> getUsers() {
		return Arrays.asList(new User("Chris", "Pruitt", 34), new User("Matt", "Bates", 15),
				new User("John", "Wagner", 82), new User("Vernon", "McGuire", 31), new User("Mary", "Bates", 37),
				new User("Mary", "Bates", 23));
	}

	@Data
	@AllArgsConstructor
	@ToString
	private static class User {
		private String firstName;
		private String lastName;
		private int age;
	}
}
