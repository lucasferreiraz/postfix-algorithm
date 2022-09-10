package calculator;

import structures.Stack;

public class Calculator {

    private static String operators[] = {"+", "-", "*", "/"};
    private static Stack<Float> stack = new Stack<>(200);

    public static Stack<Float> parse(String expression) {
        String sentences[] = expression.trim().split("\\s");
        String operator;

        for(int i = 0; i < sentences.length; i++){

            if(belongsTo(sentences[i])){
                operator = sentences[i];
                operate(operator);
            } else {
                stack.push(Float.parseFloat(sentences[i]));
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
        Float last = stack.peek();
        Float penult = stack.penult();
        Float result = null;

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
