package scanner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Scanner {

    private String input;

    public Scanner(String input) {
        // Remove any whitespace from the input string
        this.input = input.replaceAll("\\s+", "");
    }

    public String[] getToken() {
        List<String> tokens = new ArrayList<>();
        int position = 0;

        while (position < input.length()) {
            char currentChar = input.charAt(position);

            if (Character.isDigit(currentChar)) {
                // Handle multi-digit numbers
                StringBuilder number = new StringBuilder();
                while (position < input.length() && Character.isDigit(input.charAt(position))) {
                    number.append(input.charAt(position));
                    position++;
                }
                tokens.add(number.toString());
            } else {
                // Handle single character tokens (operators, parentheses, etc.)
                tokens.add(Character.toString(currentChar));
                position++;
            }
        }

        return tokens.toArray(new String[0]);
    }
}

