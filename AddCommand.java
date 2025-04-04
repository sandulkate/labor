package calculator;

public class AddCommand implements Command {
    private Calculator calculator;
    private double a, b;

    public AddCommand(Calculator calculator, double a, double b) {
        this.calculator = calculator;
        this.a = a;
        this.b = b;
    }

    @Override
    public void execute() {
        calculator.add(a, b);
    }
}
