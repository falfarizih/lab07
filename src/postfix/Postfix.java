package postfix;

import stack.LinkedListStack;
import stack.Stack;
import stack.Underflow;
import java.util.Scanner;


public class Postfix {


	public double evaluate(String postfix) throws Underflow {
		Stack<Double> stack = new LinkedListStack<>();
		String[] tokens = postfix.split(" ");

		for (String token : tokens) {
			if (isOperator(token)) {
				double operand2 = stack.pop();
				double operand1 = stack.pop();
				double result = performOperation(token, operand1, operand2);
				stack.push(result);
			} else {
				stack.push(Double.parseDouble(token));
			}
		}

		return stack.pop();
	}
	public void evaluatePostfixFromConsole() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a postfix expression: ");
		String input = scanner.nextLine();
		System.out.println("Postfix input received: " + input);

		try {
			double result = evaluate(input);
			System.out.println("Result: " + result);
		} catch (Underflow e) {
			System.out.println("Error: The postfix expression is not well-formed.");
		} catch (NumberFormatException e) {
			System.out.println("Error: Invalid number format in the postfix expression.");
		}
	}

	public void evaluateInfixFromConsole() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter an infix expression: ");
		String input = scanner.nextLine();
		System.out.println("Infix input received: " + input);

		try {
			Infix infixConverter = new Infix();
			String postfix = infixConverter.toPostfix(input);
			System.out.println("Converted to postfix: " + postfix);
			double result = evaluate(postfix);
			System.out.println("Result: " + result);
		} catch (Underflow e) {
			System.out.println("Error: The infix expression is not well-formed.");
		} catch (NumberFormatException e) {
			System.out.println("Error: Invalid number format in the infix expression.");
		}
	}
	private static boolean isOperator(String token) {
		return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
	}

	private double performOperation(String operator, double operand1, double operand2) {
		switch (operator) {
			case "+":
				return operand1 + operand2;
			case "-":
				return operand1 - operand2;
			case "*":
				return operand1 * operand2;
			case "/":
				return operand1 / operand2;
			default:
				throw new IllegalArgumentException("Invalid operator: " + operator);
		}
	}
}
