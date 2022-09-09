package calculator;

import structures.Stack;

public class Calculator {

    private static String operators[] = {"+", "-", "*", "/"};
    private static Stack<Integer> stack = new Stack<>(200);

    public static Stack<Integer> parse(String expression) {
        String sentences[] = expression.trim().split("\\s");
        String operator;

        for(int i = 0; i < sentences.length; i++){

            if(belongsTo(sentences[i])){
                operator = sentences[i];
                operate(operator);
            } else {
                stack.push(Integer.parseInt(sentences[i]));
            }

        }

        return stack;
    }

    private static boolean belongsTo(String ch){
        for(String op : operators){
            if(ch.equals(op)) { return true; }
        }
        return false;
    }

    private static void operate(String operator){
        Integer last = stack.peek();
        Integer penult = stack.penult();
        Integer result = null;

        switch (operator) {
            case "+":
                result = penult + last;
                break;
            case "-":
                result = penult - last;
                break;
            
            case "*":
                result = penult * last;
                break;

            case "/":
                result = penult / last;
                break;
        }

        stack.pop();
        stack.pop();
        stack.push(result);
    }
    
}
