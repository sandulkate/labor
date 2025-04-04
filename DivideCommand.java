package calculator;

public class DivideCommand implements Command {
    private Calculator calculator;
    private double a, b;

    public DivideCommand(Calculator calculator, double a, double b) {
        this.calculator = calculator;
        this.a = a;
        this.b = b;
    }

    @Override
    public void execute() {
        calculator.divide(a, b);
    }
}

