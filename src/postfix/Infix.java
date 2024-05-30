package postfix;

import stack.LinkedListStack;
import stack.Stack;
import stack.Underflow;

public class Infix {

    public String toPostfix(String infix) throws Underflow {
        Stack<Character> operatorStack = new LinkedListStack<>();
        StringBuilder postfix = new StringBuilder();
        char[] tokens = infix.toCharArray();

        for (char token : tokens) {
            if (Character.isDigit(token)) {
                postfix.append(token).append(' '); // Append operand with a space
            } else if (token == '(') {
                operatorStack.push(token);
            } else if (token == ')') {
                while (!operatorStack.isEmpty() && operatorStack.top() != '(') {
                    postfix.append(operatorStack.pop()).append(' ');
                }
                operatorStack.pop();
            } else if (isOperator(token)) {
                while (!operatorStack.isEmpty() && precedence(token) <= precedence(operatorStack.top())) {
                    postfix.append(operatorStack.pop()).append(' ');
                }
                operatorStack.push(token);
            }
        }

        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop()).append(' ');
        }

        return postfix.toString().trim(); // Remove trailing space and return
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        } else {
            return -1;
        }
    }

}
