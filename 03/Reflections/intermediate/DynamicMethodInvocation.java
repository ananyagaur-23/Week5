package intermediate;

import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvocation {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        MathOperations mathOperations = new MathOperations();

        System.out.println("Enter method name (add, subtract, multiply): ");
        String methodName = scanner.nextLine();

        System.out.println("Enter two numbers: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        Method method = MathOperations.class.getMethod(methodName, int.class, int.class);
        int result = (int) method.invoke(mathOperations, num1, num2);

        System.out.println("Result: " + result);
    }
}
