package albert.practice.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.base.Strings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LambdaTest {

    public static void main(String[] args) {
        LambdaTest test = new LambdaTest();
        log.debug("initial data = " + test.createData().toString());
        log.debug("filterData = " + test.filterData().toString());
        log.debug("filterDataWithSort = " + test.filterDataWithSort().toString());
    }

    public List<Person> filterData() {
        List<Person> people = createData();
        return people.stream().filter(p -> p.age >= 35).filter(p -> !Strings.isNullOrEmpty(p.email))
                .collect(Collectors.toList());
    }

    public List<Person> filterDataWithSort() {
        List<Person> people = createData();
        return people.stream().filter(p -> p.age >= 35).sorted((p1, p2) -> (p1.age - p2.age))
                .sorted((p1, p2) -> p2.name.compareTo(p1.name)).collect(Collectors.toList());
    }

    public List<Person> createData() {
        Person ben = new Person("Ben Whittaker", 70, "ben@gmail.com");
        Person jules = new Person("Jules Ostin", 30, "jules@gmail.com");
        Person fiona = new Person("Fiona Farwell", 68, null);
        Person matt = new Person("Matt", 35, "matt@gmail.com");
        
        return Arrays.asList(ben, jules, fiona, matt);
    }

    @Data
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Person {
        private String name;
        private int age;
        private String email;
    }

}
