package calculator;

import structures.Stack;

public class Calculator {

    private static String operators[] = {"+", "-", "*", "/"};
    private static Stack<Integer> stack = new Stack<>(200);

    public static void parse(String expression) {
        String sentences[] = expression.trim().split("\\s");

        Integer value1;
        Integer value2;
        String operator;
        

        for(int i = 0; i < sentences.length; i++){

            if(belongsTo(sentences[i])){
                operator = sentences[i];
                
            } else {
                stack.push(Integer.parseInt(sentences[i]));
            }

        }

    }

    private static boolean belongsTo(String ch){
        for(String op : operators){
            if(ch.equals(op)) { return true; }
        }
        return false;
    }
    
}
