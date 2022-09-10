package validation;

public class Validator {
    
    public static void validate(String expression){
        String sentences[] = expression.trim().split("\\s");
        
        initialOperands(sentences);
        lastElement(sentences);
        validElements(sentences);
    }

    private static void initialOperands(String[] sentences){
        for(int i = 0; i < 2; i++){
            if(notNumeric(sentences[i])){
                throw new NumberFormatException("Os dois primeiros elementos precisam ser numeros.");
            }
        }
    }

    private static void lastElement(String[] sentences){
        int size = sentences.length;
        if(!notNumeric(sentences[size-1])){
            throw new IllegalArgumentException("The last element must be an operator.");
        }
    }

    public static void validElements(String[] sentences){
        int numbers = 0;
        int operators = 0;
        for(String element : sentences){
            if(notNumeric(element)){
                operators++;
            } else if(!notNumeric(element)){
                numbers++;
            }
        }

        if(operators != numbers-1){
            throw new RuntimeException("Invalid amount of numbers and/or operators");
        }
    }

    private static boolean notNumeric(String ch){
        if (ch == null){ return true; }
        try {
            Float.parseFloat(ch);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

}
