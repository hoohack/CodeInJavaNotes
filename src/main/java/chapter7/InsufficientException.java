package chapter7;

public class InsufficientException extends Exception {

    private int number;

    public InsufficientException(String message, int remain) {
        super(message);
        this.number = remain;
    }

    public int getNumber() {
        return number;
    }

}
