import java.util.Scanner;

class ArrayOperations {
    int[] arr = new int[5];

    // Method to take input from user
    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 5 integers for the array:");
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }
    }

    // Output 1: Standard for loop
    void output1() {
        System.out.print("Output (Standard Loop): ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Output 2: Enhanced for-each loop
    void output2() {
        System.out.print("Output (For-each Loop): ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    // Method to print array in reverse
    void reverse() {
        System.out.print("Array in Reverse: ");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayOperations obj = new ArrayOperations();
        obj.input();
        obj.output1();
        obj.output2();
        obj.reverse();
    }
}
