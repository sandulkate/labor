package calculator;

public class Calculator {
    public void add(double a, double b) {
        OutputBuffer.print("Result: " + (a + b));
    }

    public void subtract(double a, double b) {
        OutputBuffer.print("Result: " + (a - b));
    }

    public void multiply(double a, double b) {
        OutputBuffer.print("Result: " + (a * b));
    }

    public void divide(double a, double b) {
        if (b != 0)
            OutputBuffer.print("Result: " + (a / b));
        else
            OutputBuffer.print("Error: Division by zero");
    }
}
