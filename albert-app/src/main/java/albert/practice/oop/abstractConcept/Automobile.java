package albert.practice.oop.abstractConcept;

import lombok.extern.slf4j.Slf4j;

/**
 * abstraction is a process of hiding the implementation details from the user,
 * only the functionality will be provided to the user. In other words, the user
 * will have the information on what the object does instead of how it does it.
 */
@Slf4j
public abstract class Automobile {

	public Automobile() {
		log.info("Automobile is created");
	}

	abstract void run();
}
