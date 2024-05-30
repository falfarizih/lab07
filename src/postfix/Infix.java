package postfix;

import stack.LinkedListStack;
import stack.Underflow;

public class Infix {

    public String toPostfix(String infix) {
        LinkedListStack<Character> stack = new LinkedListStack<>();
        StringBuilder postfix = new StringBuilder();
        char[] chars = infix.toCharArray();

        for (char c : chars) {
            if (Character.isDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                try {
                    while (!stack.isEmpty() && stack.top() != '(') {
                        postfix.append(stack.pop());
                    }
                    if (!stack.isEmpty() && stack.top() == '(') {
                        stack.pop();
                    }
                } catch (Underflow e) {
                    System.err.println("Stack underflow occurred while processing ')'");
                }
            } else if (isOperator(c)) {
                try {
                    while (!stack.isEmpty() && precedence(c) <= precedence(stack.top())) {
                        postfix.append(stack.pop());
                    }
                } catch (Underflow e) {
                    System.err.println("Stack underflow occurred while processing operator");
                }
                stack.push(c);
            }
        }

        try {
            while (!stack.isEmpty()) {
                postfix.append(stack.pop());
            }
        } catch (Underflow e) {
            System.err.println("Stack underflow occurred while emptying the stack");
        }

        return postfix.toString();
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }
}
