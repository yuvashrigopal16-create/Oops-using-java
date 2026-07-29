import java.util.Scanner;

// Define the interface
interface Calculator {
    double add(double a, double b);
    double subtract(double a, double b);
    double multiply(double a, double b);
    double divide(double a, double b);
}

// Implement the interface in a class
class BasicCalculator implements Calculator {
    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return 0;
        }
        return a / b;
    }
}

// Main class to run test cases
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new BasicCalculator();

        System.out.print("First Number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Second Number: ");
        double num2 = scanner.nextDouble();

        System.out.println("\nSelect Operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Enter choice (1-4): ");
        int choice = scanner.nextInt();

        double result = 0;
        switch (choice) {
            case 1:
                result = calc.add(num1, num2);
                break;
            case 2:
                result = calc.subtract(num1, num2);
                break;
            case 3:
                result = calc.multiply(num1, num2);
                break;
            case 4:
                result = calc.divide(num1, num2);
                break;
            default:
                System.out.println("Invalid Choice!");
                scanner.close();
                return;
        }

        // Format to display clean integers if there are no decimals
        if (result == (long) result) {
            System.out.println("\nOutput");
            System.out.println("Result = " + (long) result);
        } else {
            System.out.println("\nOutput");
            System.out.println("Result = " + result);
        }

        scanner.close();
    }
}
