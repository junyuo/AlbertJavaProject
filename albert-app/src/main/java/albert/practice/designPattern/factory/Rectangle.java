package albert.practice.designPattern.factory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Rectangle implements Shape {

    @Override
    public void draw() {
        log.debug("Inside Rectangle::draw() method.");
    }

}
