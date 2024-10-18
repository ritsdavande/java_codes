package mymath;
public class Arithmetic {
    public float add(float a, float b) {
        return a + b;
    }
    public float subtract(float a, float b) {
        return a - b;
    }
    public float multiply(float a, float b) {
        return a * b;
    }
    public float divide(float a, float b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}
