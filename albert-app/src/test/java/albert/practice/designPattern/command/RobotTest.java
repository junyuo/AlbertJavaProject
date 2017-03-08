package albert.practice.designPattern.command;

import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class RobotTest {

    Robot robot;
    
    @Before
    public void setup() {
        robot = new Robot("瓦力");
    }
    
    @Test
    public void testCommand() {
        new GoAheadCommand(robot).execute();
        new TurnLeftCommand(robot).execute();
        new TurnRightCommand(robot).execute();
        new TurnBackCommand(robot).execute();
    }
    
    @Test
    public void testRobotBean() {
        new BeanTester().testBean(Robot.class);
    }
    
    @Test
    public void testRobotBeanEqualsAndHashcode() {
        EqualsVerifier.forClass(Robot.class)
                .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS).verify();
    }
    
}
