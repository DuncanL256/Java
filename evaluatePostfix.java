import java.util.Stack;

public class evaluatePostfix {
    // Method to evaluate value of a postfix expression
    static int evaluatePostfix(String exp) {
        // Create a stack
        Stack<Integer> stack = new Stack<>();
        
        // This splits the expression with spaces so we can handle multiple didgit numbers
        String[] tokens = exp.trim().split("\\s+");
        
        // Scan all f the tokens individually
        for (String token : tokens) {
            // If the token is a number, push it to the stack
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            }
            // If the token is an operator, pop two elements from stack and apply the operator
            else {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid expression: not enough operands");
                }
                int val1 = stack.pop();
                int val2 = stack.pop();
                
                char operator = token.charAt(0);
                switch (operator) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '/':
                        if (val1 == 0) {
                            throw new ArithmeticException("Division by zero");
                        }
                        stack.push(val2 / val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                    case '^':
                        stack.push((int) Math.pow(val2, val1)); // this is the secret sauce to the power methods
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + operator);
                }
            }
        }
        
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression: too many operands");
        }
        
        return stack.pop();
    }
    
    // Helper method to check if a token is a number
    private static boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // This is the code to test our methods work
    public static void main(String[] args) {
        // Test cases with multi-digit numbers
        String[] testExpressions = {
            "5 2 *",                    // answer should be 10
            "25 10 -",                  // answer should be 15
            "3 25 15 - *",             // answer should be 30
            "100 10 /",                // answer should be 10
            "2 3 ^",                   // answer should be 8. This one was put in to check that we can do powers
            "15 7 1 1 + - / 3 * 2 1 1 + + -"  // answer should be 5
        };
        
        for (String exp : testExpressions) {
            try {
                System.out.println("Expression: " + exp);
                System.out.println("Result: " + evaluatePostfix(exp));
                System.out.println();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println();
            }
        }
    }
}
