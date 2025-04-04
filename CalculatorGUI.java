package calculator;

import javax.swing.*;
import java.awt.*;

public class CalculatorGUI {
    private JFrame frame;
    private JTextField fieldA, fieldB;
    private JTextArea resultArea;
    private Calculator calculator;
    private Command customCommand;
    private JComboBox<String> operationCombo;
    public CalculatorGUI() {
        calculator = new Calculator();
        createUI();
    }

    private void createUI() {
        frame = new JFrame("Клавиатура настраимаемого калькулятора");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350); 

        JPanel panel = new JPanel(new GridLayout(7, 2, 5, 5));

        fieldA = new JTextField();
        fieldB = new JTextField();
        resultArea = new JTextArea(4, 20);
        resultArea.setEditable(false);

        //выпадающий список операций
        operationCombo = new JComboBox<>(new String[]{"Сложение", "Вычитание", "Умножение", "Деление"});

        JButton addBtn = new JButton("Сложить");
        JButton subBtn = new JButton("Вычесть");
        JButton mulBtn = new JButton("Умножить");
        JButton divBtn = new JButton("Делить");
        JButton assignCustomBtn = new JButton("Назначить на кнопку");
        JButton customBtn = new JButton("Пользовательская кнопка");

        //Основные команды
        addBtn.addActionListener(e -> executeCommand(new AddCommand(calculator, getA(), getB())));
        subBtn.addActionListener(e -> executeCommand(new SubtractCommand(calculator, getA(), getB())));
        mulBtn.addActionListener(e -> executeCommand(new MultiplyCommand(calculator, getA(), getB())));
        divBtn.addActionListener(e -> executeCommand(new DivideCommand(calculator, getA(), getB())));

        assignCustomBtn.addActionListener(e -> {
            double a = getA();
            double b = getB();
            String selectedOp = (String) operationCombo.getSelectedItem();

            switch(selectedOp) {
                case "Сложение":
                    customCommand = new AddCommand(calculator, a, b);
                    break;
                case "Вычитание":
                    customCommand = new SubtractCommand(calculator, a, b);
                    break;
                case "Умножение":
                    customCommand = new MultiplyCommand(calculator, a, b);
                    break;
                case "Деление":
                    customCommand = new DivideCommand(calculator, a, b);
                    break;
            }

            resultArea.setText("Назначена операция: " + selectedOp);
        });

        //выполнения назначенной команды
        customBtn.addActionListener(e -> {
            if (customCommand != null) {
                executeCommand(customCommand);
            } else {
                resultArea.setText("Сначала назначьте операцию!");
            }
        });

        // Добавление элементов на панель
        panel.add(new JLabel("A:"));
        panel.add(fieldA);
        panel.add(new JLabel("B:"));
        panel.add(fieldB);
        panel.add(new JLabel("Операция:")); 
        panel.add(operationCombo);       
        panel.add(addBtn);
        panel.add(subBtn);
        panel.add(mulBtn);
        panel.add(divBtn);
        panel.add(assignCustomBtn);
        panel.add(customBtn);

        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.add(new JScrollPane(resultArea), BorderLayout.SOUTH);
        frame.setVisible(true);
    }

   
    private double getA() {
        return Double.parseDouble(fieldA.getText());
    }

    private double getB() {
        return Double.parseDouble(fieldB.getText());
    }

    private void executeCommand(Command cmd) {
        OutputBuffer.setBuffer(resultArea);
        cmd.execute();
    }
}
