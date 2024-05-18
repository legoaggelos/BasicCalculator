package com.oldlaptopguy;

import com.oldlaptopguy.calculating.Calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator(scanner);
        System.out.println("Welcome to the calculator!" +
                "\nType a command or help for help.");
        String trigType = "radians";
        while(true){
            System.out.println("Enter a command:");
            String command = scanner.nextLine().trim();
            String valueFromCommand = calc.getValueFromCommand(command, trigType).trim();
            if(command.equalsIgnoreCase("type")){
                System.out.println("Trig functions are currently using "+valueFromCommand+".");
                continue;
            }
            if(command.equalsIgnoreCase("switch")){
                trigType=valueFromCommand;
                System.out.println("Trig functions now use "+valueFromCommand+".");
                continue;
            }
            if(valueFromCommand.equalsIgnoreCase("Invalid command")){
                System.out.println("Invalid command. Type help to see list of commands.");
                continue;
            }
            if(valueFromCommand.equalsIgnoreCase("exit")){
                System.out.println("Exiting...");
                return;
            }
            if(valueFromCommand.equalsIgnoreCase("valueWasInvalid")){
                System.out.println("The last value was invalid.");
                continue;
            }
            System.out.println(valueFromCommand);
        }
    }
}
