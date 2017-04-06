package albert.practice.lambda;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LambdaNumberExample {

    /**
     * Returns a Collector that produces the arithmetic mean of a double-valued function applied to
     * the input elements.
     * 
     * @param numbers
     * @return
     */
    public double getAverage(List<Double> numbers) {
        return numbers.stream().collect(Collectors.averagingDouble(x -> x));
    }

    /**
     * Returns a Collector that produces the maximal element according to a given Comparator.
     * 
     * @param numbers
     * @return
     */
    public Double getMax(List<Double> numbers) {
        Optional<Double> max = numbers.stream().collect(Collectors.maxBy(Double::compare));
        return max.get();
    }

    /**
     * Returns a Collector that produces the minimal element according to a given Comparator.
     * 
     * @param numbers
     * @return
     */
    public Double getMin(List<Double> numbers) {
        Optional<Double> min = numbers.stream().collect(Collectors.minBy(Double::compare));
        return min.get();
    }

    /**
     * Return a state object for collecting statistics such as count, min, max, sum, and average.
     * 
     * @param numbers
     * @return
     */
    public DoubleSummaryStatistics getSummaryStatistics(List<Double> numbers) {
        DoubleSummaryStatistics summaryStatisics = numbers.stream()
                .collect(Collectors.summarizingDouble(x -> x));
        return summaryStatisics;
    }

}
