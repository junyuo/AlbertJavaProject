package albert.practice.oop.abstractConcept;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Mini extends Automobile {

	@Override
	void run() {
		log.info("Mini Cooper is running");
	}
	
	public static void main(String[] args) {
		Automobile mini = new Mini();
		mini.run();
	}

}
