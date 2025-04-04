package calculator;

import javax.swing.*;

public class OutputBuffer {
    private static JTextArea outputArea;

    public static void setBuffer(JTextArea area) {
        outputArea = area;
    }

    public static void print(String text) {
        if (outputArea != null) {
            outputArea.append(text + "\n");
        }
    }
}
