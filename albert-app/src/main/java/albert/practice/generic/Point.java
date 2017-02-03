package albert.practice.generic;

import lombok.ToString;

@ToString
public class Point<T1, T2> {

    private T1 x;
    private T2 y;
    
    public T1 getX() {
        return x;
    }
    
    public void setX(T1 x) {
        this.x = x;
    }
    
    public T2 getY() {
        return y;
    }
    
    public void setY(T2 y) {
        this.y = y;
    }

}
