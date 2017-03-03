package albert.practice.designPattern.factory;

import static org.junit.Assert.assertEquals;

import java.util.function.Supplier;

import org.junit.Test;

public class ShapeFactoryTest {

    @Test
    public void testDifferentShape() {
        Supplier<ShapeFactory> shapeFactory = ShapeFactory::new;
        shapeFactory.get().getShape(ShapeEnum.CIRCLE).draw();
        shapeFactory.get().getShape(ShapeEnum.RECTANGLE).draw();
        shapeFactory.get().getShape(ShapeEnum.OVAL).draw();
        shapeFactory.get().getShape(ShapeEnum.SQUARE).draw();
        shapeFactory.get().getShape(ShapeEnum.TRIANGLE).draw();
    }

    @Test
    public void testShapeEnum() {
        ShapeEnum[] shapeEnums = ShapeEnum.values();
        assertEquals(5, shapeEnums.length);
    }

}
