package albert.practice.oop.polymorphism;

import org.junit.Test;

import albert.practice.oop.polymorphism.animal.Animal;
import albert.practice.oop.polymorphism.animal.Cat;
import albert.practice.oop.polymorphism.animal.Dog;

public class AnimalTest {

	@Test
	public void doTest() {
		Animal dog = new Dog();
		dog.run();
		dog.makeNoise();
		
		Animal cat = new Cat();
		cat.run();
		cat.makeNoise();
	}

}
