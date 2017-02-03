package albert.practice.generic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenericPrint {

    public <T> void print(T x) {
        log.debug("your input is : " + x + ", data type is " + x.getClass().getName());
    }

}
