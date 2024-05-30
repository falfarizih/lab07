import postfix.Postfix;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Postfix postfixEvaluator = new Postfix();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Choose input type (1 for infix, 2 for postfix, 0 to exit): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                postfixEvaluator.evaluateInfixFromConsole();
            } else if (choice == 2) {
                postfixEvaluator.evaluatePostfixFromConsole();
            } else if (choice == 0) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }


    }
}
