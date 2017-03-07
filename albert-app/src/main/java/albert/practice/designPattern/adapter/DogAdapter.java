package albert.practice.designPattern.adapter;

public class DogAdapter implements Dog {

    Dog dog;

    public DogAdapter(Dog dog) {
        this.dog = dog;
    }

    @Override
    public void bark() {
        dog.bark();
    }

    @Override
    public void eat() {
        dog.eat();
    }

    @Override
    public void walk() {
        dog.walk();
    }

}
