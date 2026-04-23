class Calculator {
    double num1, num2;

    Calculator(double a, double b) {
        num1 = a;
        num2 = b;
    }

    void calculate() {
        System.out.println("Addition: " + (num1 + num2));
        System.out.println("Subtraction: " + (num1 - num2));
        System.out.println("Multiplication: " + (num1 * num2));
        if (num2 != 0) {
            System.out.println("Division: " + (num1 / num2));
        } else {
            System.out.println("Division: Cannot divide by zero");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator obj = new Calculator(10, 5);
        obj.calculate();
    }
}   