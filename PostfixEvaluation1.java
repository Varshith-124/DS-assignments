/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package postfixevaluation1;
//package postfixevaluationasgntq;

import java.util.Stack;

public class PostfixEvaluation1 {

    // Method to evaluate a postfix expression
    public static int evaluatePostfix(String expression) {
        // Create a stack to store operands
        Stack<Integer> stack = new Stack<>();

        // Split the expression by spaces
        String[] tokens = expression.split(" ");

        // Loop through each token in the expression
        for (String token : tokens) {
            // Check if the token is an operand (number)
            if (isNumeric(token)) {
                // Push the operand onto the stack
                stack.push(Integer.parseInt(token));
            } else {
                // Token is an operator; pop two operands from the stack
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                // Apply the operator and push the result back onto the stack
                int result = applyOperator(token, operand1, operand2);
                stack.push(result);
            }
        }

        // The final result should be the only element left in the stack
        return stack.pop();
    }

    // Helper method to check if a string is numeric
    private static boolean isNumeric(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Helper method to apply an operator to two operands
    private static int applyOperator(String operator, int operand1, int operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
                return operand1 / operand2;
            case "^":
                return (int) Math.pow(operand1, operand2);
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    public static void main(String[] args) {
        // Postfix expression to be evaluated
        String expression = "6 2 3 + - 3 8 2 / + * 2 ^ 3 +";

        // Evaluate the expression
        int result = evaluatePostfix(expression);

        // Output the result
        System.out.println("The result of the postfix expression is: " + result);
    }
}