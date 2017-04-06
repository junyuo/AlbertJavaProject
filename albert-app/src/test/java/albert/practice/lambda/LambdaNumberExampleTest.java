package albert.practice.lambda;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LambdaNumberExampleTest {

    private List<Double> numbers = null;
    private LambdaNumberExample lambdaNumberExample = null;

    @Before
    public void setup() {
        numbers = Arrays.asList(90d, 93d, 61d, 84d, 26d, 95d, 61d, 19d, 51d, 44d);
        lambdaNumberExample = new LambdaNumberExample();
    }

    @Test
    public void testGetAverage() {
        double average = lambdaNumberExample.getAverage(numbers);
        log.debug("average = " + average);
        assertEquals(62.4, average, 2);
    }

    @Test
    public void testGetMax() {
        Double max = lambdaNumberExample.getMax(numbers);
        log.debug("max = " + max);
        assertEquals(95, max, 2);
    }

    @Test
    public void testGetMin() {
        Double min = lambdaNumberExample.getMin(numbers);
        log.debug("min = " + min);
        assertEquals(19, min, 2);
    }

    @Test
    public void testGetSummaryStatistics() {
        DoubleSummaryStatistics summaryStatisics = lambdaNumberExample
                .getSummaryStatistics(numbers);
        log.debug("summaryStatisics = " + summaryStatisics.toString());
        assertEquals(10, summaryStatisics.getCount(), 0);
        assertEquals(624, summaryStatisics.getSum(), 0);
        assertEquals(62.4, summaryStatisics.getAverage(), 2);
        assertEquals(19, summaryStatisics.getMin(), 2);
        assertEquals(95, summaryStatisics.getMax(), 2);
    }
}
