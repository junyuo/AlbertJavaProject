package albert.practice.designPattern.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ShapeFactory {
    
    final static Map<String, Supplier<Shape>> map = new HashMap<>();
    
    static {
        map.put(ShapeEnum.CIRCLE.toString(), Circle::new);
        map.put(ShapeEnum.RECTANGLE.toString(), Rectangle::new);
        map.put(ShapeEnum.OVAL.toString(), Oval::new);
        map.put(ShapeEnum.SQUARE.toString(), Square::new);
        map.put(ShapeEnum.TRIANGLE.toString(), Triangle::new);
    }
    
    public Shape getShape(ShapeEnum shapeEnum) {
        Supplier<Shape> shape = map.get(shapeEnum.toString());
        return shape.get();
    }
    
}
