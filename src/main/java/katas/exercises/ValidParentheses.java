package katas.exercises;

import java.util.Stack;

public class ValidParentheses {

    /**
     * Checks if a given string has valid parentheses (try in O(n)).
     *
     * A string has valid parentheses if:
     * 1. Every opening parenthesis has a matching closing parenthesis.
     * 2. The parentheses are correctly nested.
     *
     * @param s the input string containing parentheses
     * @return true if the string has valid parentheses, false otherwise
     */
    public static boolean isValidParentheses(String s) {

        if (s == null ){
            throw new IllegalArgumentException("Can't Be Null");
        }

        for (char ch : s.toCharArray()) {
            if (ch != '(' && ch != ')' && ch != '{' && ch != '}' && ch != '[' && ch != ']') {
                return false;
            }
        }


        Stack<Character> mystack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                mystack.push(ch);
            else if (ch == ')' || ch == ']' || ch == '}') {

                if (mystack.isEmpty()) {
                    return false;
                }
                char top = mystack.pop();
                if ((ch == ')' && top != '(') ||
                        (ch == ']' && top != '[') ||
                        (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return mystack.isEmpty();
}

    public static void main(String[] args) {
        String validInput = "()[]{}";
        String invalidInput1 = "(]";
        String invalidInput2 = "([)]";
        String validInputNested = "{[()]}";

        System.out.println("Is valid: " + isValidParentheses(validInput));
        System.out.println("Is valid: " + isValidParentheses(invalidInput1));
        System.out.println("Is valid: " + isValidParentheses(invalidInput2));
        System.out.println("Is valid: " + isValidParentheses(validInputNested));
    }
}
