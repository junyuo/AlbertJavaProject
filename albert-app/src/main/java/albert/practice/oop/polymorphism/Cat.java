package albert.practice.oop.polymorphism;

import lombok.extern.slf4j.Slf4j;

/**
 * A Cat is-a animal
 */
@Slf4j
public class Cat implements Animal {

	@Override
	public void run() {
		log.info("Cat is running");
	}
	
	public static void main(String[] args) {
		Animal cat = new Cat();
		cat.run();
	}

}
