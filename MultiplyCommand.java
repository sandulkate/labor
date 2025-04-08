package calculator;

public class MultiplyCommand implements Command {
    private Calculator calculator;
    private double a, b;

    public MultiplyCommand(Calculator calculator, double a, double b) {
        this.calculator = calculator;
        this.a = a;
        this.b = b;
    }

    @Override
    public void execute() {
        calculator.multiply(a, b);
    }
}

