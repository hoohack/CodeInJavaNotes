package chapter17;

public class SimpleDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("I can quack");
    }

    @Override
    public void swim() {
        System.out.println("I can swim");
    }
}
