import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrationForm extends JFrame implements ActionListener {

    JTextField nameField, emailField;
    JPasswordField passwordField;
    JRadioButton male, female;
    JCheckBox terms;
    JButton registerBtn, clearBtn;

    RegistrationForm() {
        setTitle("Registration Form");
        setSize(400, 350);
        setLayout(null); // manual layout

        // Name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 50, 100, 30);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 50, 150, 30);
        add(nameField);

        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 90, 100, 30);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150, 90, 150, 30);
        add(emailField);

        // Password
        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 130, 100, 30);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 130, 150, 30);
        add(passwordField);

        // Gender
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(50, 170, 100, 30);
        add(genderLabel);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");

        male.setBounds(150, 170, 70, 30);
        female.setBounds(220, 170, 80, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        add(male);
        add(female);

        // Terms
        terms = new JCheckBox("I accept terms & conditions");
        terms.setBounds(100, 210, 200, 30);
        add(terms);

        // Buttons
        registerBtn = new JButton("Register");
        registerBtn.setBounds(80, 250, 100, 30);
        add(registerBtn);

        clearBtn = new JButton("Clear");
        clearBtn.setBounds(200, 250, 100, 30);
        add(clearBtn);

        registerBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == registerBtn) {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            String gender = "";
            if (male.isSelected()) gender = "Male";
            else if (female.isSelected()) gender = "Female";

            if (name.equals("") || email.equals("") || password.equals("") || gender.equals("") || !terms.isSelected()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields!");
            } else {
                JOptionPane.showMessageDialog(this,
                        "Registration Successful!\nName: " + name +
                        "\nEmail: " + email +
                        "\nGender: " + gender);
            }
        }

        if (e.getSource() == clearBtn) {
            nameField.setText("");
            emailField.setText("");
            passwordField.setText("");
            male.setSelected(false);
            female.setSelected(false);
            terms.setSelected(false);
        }
    }

    public static void main(String[] args) {
        new RegistrationForm();
    }
}