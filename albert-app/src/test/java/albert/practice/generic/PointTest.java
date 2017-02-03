package albert.practice.generic;

import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;

import lombok.extern.slf4j.Slf4j;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

@Slf4j
public class PointTest {

    private Point<Integer, Integer> point1;
    private Point<Double, String> point2;

    @Before
    public void setup() {
        point1 = new Point<>();
        point2 = new Point<>();
    }

    @Test
    public void setPoint() {
        point1.setX(10);
        point1.setY(20);
        log.debug("point1 = " + point1.toString());
        
        point2.setX(25.4);
        point2.setY("ªF¸g180«×");
        log.debug("point2 = " + point2.toString());
    }
    
    @Test
    public void testPointBean() {
        new BeanTester().testBean(Point.class);
    }
    
    @Test
    public void testEqualsAndHashcode() {
        EqualsVerifier.forClass(Point.class)
                .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS).verify();
    }

}
