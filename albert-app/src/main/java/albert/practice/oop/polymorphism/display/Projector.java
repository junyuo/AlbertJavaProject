package albert.practice.oop.polymorphism.display;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Projector implements DisplayModule {

	@Override
	public void display() {
		log.debug("Display through projector");
	}

}
