import javax.swing.*;
import java.awt.event.*;

class CalculatorGUI {
    public static void main(String[] args) {
        JFrame f = new JFrame("Calculator");

        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JTextField result = new JTextField();

        JButton add = new JButton("+");
        JButton sub = new JButton("-");
        JButton mul = new JButton("*");
        JButton div = new JButton("/");

        t1.setBounds(50, 50, 100, 30);
        t2.setBounds(200, 50, 100, 30);
        result.setBounds(125, 100, 100, 30);

        add.setBounds(50, 150, 50, 30);
        sub.setBounds(110, 150, 50, 30);
        mul.setBounds(170, 150, 50, 30);
        div.setBounds(230, 150, 50, 30);

        f.add(t1); f.add(t2); f.add(result);
        f.add(add); f.add(sub); f.add(mul); f.add(div);

        add.addActionListener(e -> {
            int a = Integer.parseInt(t1.getText());
            int b = Integer.parseInt(t2.getText());
            result.setText("" + (a + b));
        });

        sub.addActionListener(e -> {
            int a = Integer.parseInt(t1.getText());
            int b = Integer.parseInt(t2.getText());
            result.setText("" + (a - b));
        });

        mul.addActionListener(e -> {
            int a = Integer.parseInt(t1.getText());
            int b = Integer.parseInt(t2.getText());
            result.setText("" + (a * b));
        });

        div.addActionListener(e -> {
            int a = Integer.parseInt(t1.getText());
            int b = Integer.parseInt(t2.getText());
            result.setText("" + (a / b));
        });

        f.setSize(400, 300);
        f.setLayout(null);
        f.setVisible(true);
    }
}