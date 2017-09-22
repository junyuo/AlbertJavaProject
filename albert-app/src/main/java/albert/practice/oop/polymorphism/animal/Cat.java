package albert.practice.oop.polymorphism.animal;

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

	@Override
	public void makeNoise() {
		log.info("喵~");
	}

}
