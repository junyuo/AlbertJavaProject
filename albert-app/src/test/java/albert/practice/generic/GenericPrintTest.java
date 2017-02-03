package albert.practice.generic;

import org.junit.Test;

public class GenericPrintTest {

    @Test
    public void testPrint() {
        GenericPrint genericPrint = new GenericPrint();
        genericPrint.print("test123");
        genericPrint.print(20);
        genericPrint.print(30.2);
        genericPrint.print(genericPrint);
    }
    
}
