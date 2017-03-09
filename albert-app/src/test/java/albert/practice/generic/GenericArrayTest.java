package albert.practice.generic;

import org.junit.Test;

public class GenericArrayTest {

    @Test
    public void testPrintArray() {
        GenericArray array = new GenericArray();

        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.2, 2.3, 3.4, 5.6};
        String[] stringArray = {"測試1", "測試2"};
        
        array.printArray(intArray);
        array.printArray(doubleArray);
        array.printArray(stringArray);
    }

}
