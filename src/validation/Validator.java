package validation;

public class Validator {

    private static String operators[] = {"+", "-", "*", "/"};
    
    public static void initialOperands(String expression){
        String sentences[] = expression.trim().split("\\s");

        for(int i = 0; i < 2; i++){
            if(isNumeric(sentences[i])){
            } else {
                throw new NumberFormatException("Os dois primeiros elementos precisam ser numeros.");
            }
        }

    }

    private static boolean isNumeric(String ch){
        if (ch == null){ return false; }

        try {
            Integer num = Integer.parseInt(ch);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

}
