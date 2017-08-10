package albert.practice.oop.abstractConcept;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Prius extends Automobile {

	@Override
	void run() {
		log.info("Prius 4 is running");
	}
	
	public static void main(String[] args) {
		Automobile prius = new Prius();
		prius.run();
	}
	
}
