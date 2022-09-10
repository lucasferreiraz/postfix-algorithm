import java.util.Scanner;

import calculator.Calculator;
import validation.Validator;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("Type the expression in postfix format: ");
        String expression = input.nextLine();

        Validator.validate(expression);
        System.out.println("The result is: " + Calculator.parse(expression)); 
        
        input.close();
    }
}
