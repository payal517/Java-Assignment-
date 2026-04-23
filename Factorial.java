class Factorial {
    public static void main(String[] args) {
        // 1. Choose the number you want to calculate
        int number = 5; 
        
        // 2. This variable will store our final answer. 
        // We start at 1 because multiplying by 0 would make everything 0!
        long result = 1;

        // 3. The loop: starts at 1 and goes up to our number
        for (int i = 1; i <= number; i++) {
            result = result * i; // Multiply the current result by the next number
        }

        // 4. Show the answer in the console
        System.out.println("Factorial of " + number + " is: " + result);
    }
}