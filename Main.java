package com.oldlaptopguy;

import com.oldlaptopguy.calculating.Calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator(scanner);
        System.out.println("Welcome to the calculator!" +
                "\nType a command or help for help.");
        while(true){
            System.out.println("Enter a command:");
            String command = scanner.nextLine();
            String valueFromCommand = calc.getValueFromCommand(command);
            if(valueFromCommand.trim().equals("Invalid command")){
                System.out.println(command);
                continue;
            }
            if(valueFromCommand.trim().equals("exit")){
                System.out.println("Exiting...");
                return;
            }
            if(valueFromCommand.trim().equals("valueWasInvalid")){
                System.out.println("The last value was invalid.");
                continue;
            }
            System.out.println(valueFromCommand);
        }
    }
}
