package albert.practice.lambda;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import albert.practice.lambda.LambdaTest.Person;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LambdaUnitTest {

    private LambdaTest lambdaTest = null;

    @Before
    public void setup() {
        lambdaTest = new LambdaTest();
    }

    @Test
    public void testCreateData() {
        List<Person> people = lambdaTest.createData();
        assertEquals(people.size(), 4);
    }

    @Test
    public void testFilterData() {
        List<Person> people = lambdaTest.filterData();
        log.debug("testFilterData = " + people.toString());
        assertEquals(people.size(), 2);
    }
    
    @Test
    public void testFilterDataWithSort() {
        List<Person> people = lambdaTest.filterDataWithSort();
        log.debug("testFilterDataWithSort = " + people.toString());
        assertEquals(people.size(), 3);
    }

}
