package albert.practice.oop.polymorphism.display;

import lombok.Setter;

/**
 * 
 * Remember to always code through an interface so you can change your strategy
 * at runtime with actual implementation. Figure out the variable parts of your
 * problem statement and make it abstract so we can change strategy further. The
 * interface in "programming through the interface" means the java interface or
 * abstract class.
 * https://dzone.com/articles/programming-to-an-interface
 */
public class Computer {

	@Setter
	private DisplayModule displayModule;

	public void display() {
		displayModule.display();
	}

	public static void main(String[] args) {
		Computer computer = new Computer();

		DisplayModule monitor = new Monitor();
		DisplayModule projector = new Projector();

		computer.setDisplayModule(monitor);
		computer.display();

		computer.setDisplayModule(projector);
		computer.display();
	}

}
