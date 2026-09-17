// evaluates an expression written in prefix notation

public class PrefixEvaluator {
    private static int index = 0;
    
    public static int evaluate(String[] tokens) {
        index = 0;
        return evaluateHelper(tokens);
    }
    
    private static int evaluateHelper(String[] tokens) {
        String token = tokens[index++];
        
        // Check if token is an operator
        if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
            int operand1 = evaluateHelper(tokens);
            int operand2 = evaluateHelper(tokens);
            
            switch (token) {
                case "+": return operand1 + operand2;
                case "-": return operand1 - operand2;
                case "*": return operand1 * operand2;
                case "/": return operand1 / operand2;
                default: throw new IllegalArgumentException("Unknown operator: " + token);
            }
        } else {
            // Token is an operand (number)
            return Integer.parseInt(token);
        }
    }
    
    //small main tester
    public static void main(String[] args) {
        // Test case 1: "- 5 2" = 3
        String[] expression1 = "- 5 2".split("\\s+");
        System.out.println("- 5 2 = " + evaluate(expression1));
        
        // Test case 2: "* - 5 2 4" = 12
        String[] expression2 = "* - 5 2 4".split("\\s+");
        System.out.println("* - 5 2 4 = " + evaluate(expression2));
        
        // Additional test case: "+ * 2 3 / 8 2" = 10
        String[] expression3 = "+ * 2 3 / 8 2".split("\\s+");
        System.out.println("+ * 2 3 / 8 2 = " + evaluate(expression3));
        // aditional case added to show understanding of the subject
    }
}