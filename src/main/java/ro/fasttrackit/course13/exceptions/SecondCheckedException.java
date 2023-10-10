package ro.fasttrackit.course13.exceptions;

public class SecondCheckedException extends Exception {
    private final int minValue;

    public SecondCheckedException(String message, int minValue) {
        super(message);
        this.minValue = minValue;
    }

    public int getMinValue() {
        return minValue;
    }
}
