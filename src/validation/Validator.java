package validation;

public class Validator {

    private static String operators[] = {"+", "-", "*", "/"};
    
    public static void validate(String expression){
        String sentences[] = expression.trim().split("\\s");

        initialOperands(sentences);
    }

    private static void initialOperands(String[] sentences){

        for(int i = 0; i < 2; i++){
            if(notNumeric(sentences[i])){
                throw new NumberFormatException("Os dois primeiros elementos precisam ser numeros.");
            }
        }

    }

    private static boolean notNumeric(String ch){
        if (ch == null){ return true; }

        try {
            Integer num = Integer.parseInt(ch);
        } catch (NumberFormatException e) {
            return true;
        }

        return false;
    }

}
