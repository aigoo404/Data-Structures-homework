package week10;

import java.util.*;

public class MyLIFO_App {
    // reserves the given array
    public static <E> void reserve(E[] array) {
        Stack<E> stack = new Stack<>();
        for (E e : array) {
            stack.push(e);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
    }

    // check if the input is correct or not
    public static boolean isCorrect(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty() || !isMatching(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // return true if the opening and closing brackets match
    public static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')' || open == '[' && close == ']' || open == '{' && close == '}');
    }

    // use to add blanks to the expression
    public static String insertBlanks(String s) {
        String result = " ";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')' || s.charAt(i) == '+' || s.charAt(i) == '-'
                    || s.charAt(i) == '*' || s.charAt(i) == '/') {
                result += " " + s.charAt(i) + " ";
            } else {
                result += s.charAt(i);
            }
        }
        return result;
    }

    // evaluates the value of an expression
    public static int evaluateExpression(String expression) {
        Stack<Integer> operandStack = new Stack<Integer>();
        Stack<Character> operatorStack = new Stack<Character>();
        expression = insertBlanks(expression);
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if (token.length() == 0) {
                continue;
            } else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                while (!operatorStack.isEmpty() && (operatorStack.peek() == '+' || operatorStack.peek() == '-'
                        || operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0));
            } else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
                while (!operatorStack.isEmpty() &&
                        (operatorStack.peek() == '*' ||
                                operatorStack.peek() == '/')) {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0));
            } else if (token.trim().charAt(0) == '(') {
                operatorStack.push('(');
            } else if (token.trim().charAt(0) == ')') {
                while (operatorStack.peek() != '(') {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.pop();
            } else {
                operandStack.push(Integer.valueOf(token));
            }
        }
        while (!operatorStack.isEmpty()) {
            processAnOperator(operandStack, operatorStack);
        }
        return operandStack.pop();
    }

    public static void processAnOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
        char operator = operatorStack.pop();
        int operand1 = operandStack.pop();
        int operand2 = operandStack.pop();
        if (operator == '+') {
            operandStack.push(operand2 + operand1);
        } else if (operator == '-') {
            operandStack.push(operand2 - operand1);
        } else if (operator == '*') {
            operandStack.push(operand2 * operand1);
        } else if (operator == '/') {
            operandStack.push(operand2 / operand1);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 3, 4, 5 };
        String s1 = "(){}[]";
        String s2 = "){[]}()";
        String e = "51+(54*(3+2))";
        System.out.println("--------------------------------------");
        System.out.println("Original array: " + Arrays.toString(arr));
        reserve(arr);
        System.out.println("Reversed array: " + Arrays.toString(arr));
        System.out.println("--------------------------------------");
        System.out.println("String s1 is " + (isCorrect(s1) ? "correct" : "incorrect"));
        System.out.println("String s2 is " + (isCorrect(s2) ? "correct" : "incorrect"));
        System.out.println("--------------------------------------");
        System.out.println("Expression " + e + "=" + evaluateExpression(e));
        System.out.println("--------------------------------------");
    }
}
