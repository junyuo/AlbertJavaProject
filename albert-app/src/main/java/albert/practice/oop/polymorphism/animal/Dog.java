package albert.practice.oop.polymorphism.animal;

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

	@Override
	public void makeNoise() {
		log.info("汪汪~");		
	}

}
