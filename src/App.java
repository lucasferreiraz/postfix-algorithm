import java.util.Scanner;

import calculator.Calculator;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        //3 4 +
        System.out.println("Type the expression in postfix format: ");
        String expression = input.nextLine();

        System.out.println(Calculator.parse(expression)); 

        input.close();
    }
}
