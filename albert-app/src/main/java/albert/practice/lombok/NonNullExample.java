package albert.practice.lombok;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NonNullExample {

	public void sayHello(@NonNull String name) {
		log.debug("Hello, " + name);
	}
	
	public static void main(String[] args) {
		new NonNullExample().sayHello(null);
	}

}
