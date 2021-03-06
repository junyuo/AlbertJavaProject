package albert.practice.designPattern.factory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Triangle implements Shape {

    @Override
    public void draw() {
        log.debug("Inside Square::draw() method.");
    }

}
