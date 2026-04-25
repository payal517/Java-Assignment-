import javax.swing.*;
import java.awt.event.*;

class MatrixGUI {
    public static void main(String[] args) {
        JFrame f = new JFrame("Matrix Addition");

        JTextField a[][] = new JTextField[2][2];
        JTextField b[][] = new JTextField[2][2];
        JTextField c[][] = new JTextField[2][2];

        JButton add = new JButton("Add");

        int x = 50, y = 50;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                a[i][j] = new JTextField();
                b[i][j] = new JTextField();
                c[i][j] = new JTextField();

                a[i][j].setBounds(x + j*50, y + i*50, 40, 30);
                b[i][j].setBounds(x + 150 + j*50, y + i*50, 40, 30);
                c[i][j].setBounds(x + 300 + j*50, y + i*50, 40, 30);

                f.add(a[i][j]); f.add(b[i][j]); f.add(c[i][j]);
            }
        }

        add.setBounds(200, 200, 100, 30);
        f.add(add);

        add.addActionListener(e -> {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    int sum = Integer.parseInt(a[i][j].getText())
                            + Integer.parseInt(b[i][j].getText());
                    c[i][j].setText("" + sum);
                }
            }
        });

        f.setSize(500, 350);
        f.setLayout(null);
        f.setVisible(true);
    }
}