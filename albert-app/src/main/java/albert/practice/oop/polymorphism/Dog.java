package albert.practice.oop.polymorphism;

import lombok.extern.slf4j.Slf4j;

/**
 * A Dog is-a animal
 */
@Slf4j
public class Dog implements Animal {

	@Override
	public void run() {
		log.info("Dog is running");
	}

	public static void main(String[] args) {
		Animal dog = new Dog();
		dog.run();
	}

}
