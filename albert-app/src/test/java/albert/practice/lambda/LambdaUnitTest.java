package albert.practice.lambda;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;

import albert.practice.lambda.LambdaExample.Person;
import lombok.extern.slf4j.Slf4j;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

@Slf4j
public class LambdaUnitTest {

    private LambdaExample lambdaTest = null;

    @Before
    public void setup() {
        lambdaTest = new LambdaExample();
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

    @Test
    public void testGetPersonOfAgeGreaterThan40() {
        List<String> names = lambdaTest.getPersonOfAgeGreaterThan40();
        log.debug("names = " + names.toString());
        assertEquals(names.size(), 3);
    }

    @Test
    public void testGetPersonOfAgeGreaterThan40WithLimit2() {
        List<String> names = lambdaTest.getPersonOfAgeGreaterThan40WithLimit2();
        log.debug("names with limit 2 = " + names.toString());
        assertEquals(names.size(), 2);
    }

    @Test
    public void testCountPeople() {
        long count = lambdaTest.countPeople();
        assertEquals(count, 4);
    }

    // Testing getter and setters methods
    @Test
    public void testPersonBean() {
        new BeanTester().testBean(LambdaExample.Person.class);
    }

    // Testing equals() and hashCode()
    @Test
    public void testEqualsAndHashcode() {
        EqualsVerifier.forClass(LambdaExample.Person.class)
                .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS).verify();
    }

}
