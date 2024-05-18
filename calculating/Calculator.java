package com.oldlaptopguy.calculating;

import java.util.Scanner;

public class Calculator {
    private Scanner scanner;
    public static double add(double firstValue, double secondValue){
        return firstValue+secondValue;
    }
    public static double remove(double firstValue, double secondValue){
        return add(firstValue, -secondValue);
    }
    public static double multiply(double firstValue, double secondValue){
        return firstValue*secondValue;
    }
    public static double divide(double firstValue, double secondValue){
        return firstValue/secondValue;
    }
    public static double modulus(double firstValue, double secondValue){
        return firstValue%secondValue;
    }
    public static double power(double base, double exponent){
        return Math.pow(base,exponent);
    }
    public static double log10(double value){
        return Math.log10(value);
    }
    public static double logNatural(double value){
        return Math.log(value);
    }
    public static double log(double base, double value){
        return log10(value)/log10(base);
    }
    public static double sin(double value){
        return Math.sin(value);
    }
    public static double arcsin(double value){
        return Math.asin(value);
    }
    public static double hypersin(double value){
        return Math.sinh(value);
    }
    public static double pythagoras(double sideA, double sideB){
        return Math.hypot(sideA, sideB);
    }
    public static double cos(double value){
        return Math.cos(value);
    }
    public static double arccos(double value){
        return Math.acos(value);
    }
    public static double hypercos(double value){
        return Math.cosh(value);
    }
    public static double tan(double value){
        return Math.tan(value);
    }
    public static double arctan(double value){
        return Math.atan(value);
    }
    public static double hypertan(double value){
        return Math.tanh(value);
    }
    public static double radians(double degrees){
        return Math.toRadians(degrees);
    }
    public static double degrees(double radians){
        return Math.toDegrees(radians);
    }
    public static double sqrt(double value){
        return Math.sqrt(value);
    }
    public static double cbrt(double value){
        return Math.cbrt(value);
    }
    public static double customroot(double value, double nthRoot){
        return power(value, divide(1, nthRoot));
    }
    public Calculator(Scanner scanner){
        this.scanner = scanner;
    }
    public String getValueFromCommand(String command){
        double value = 0;
        double optionalValue = 0;
        try {
            if (command.trim().equalsIgnoreCase("add")) {
                double[] values = getTwoValues(scanner);
                value = values[0];
                optionalValue = values[1];
                return String.valueOf(add(value, optionalValue));
            }
            if (command.trim().equalsIgnoreCase("remove")) {
                double[] values = getTwoValues(scanner);
                value = values[0];
                optionalValue = values[1];
                return String.valueOf(remove(value, optionalValue));
            }
            if (command.trim().equalsIgnoreCase("divide")) {
                double[] values = getTwoValues(scanner);
                value = values[0];
                optionalValue = values[1];
                return String.valueOf(divide(value, optionalValue));
            }
            if (command.trim().equalsIgnoreCase("multiply")) {
                double[] values = getTwoValues(scanner);
                value = values[0];
                optionalValue = values[1];
                return String.valueOf(multiply(value, optionalValue));
            }
            if (command.trim().equalsIgnoreCase("modulus")) {
                double[] values = getTwoValues(scanner);
                value = values[0];
                optionalValue = values[1];
                return String.valueOf(modulus(value, optionalValue));
            }
            if (command.trim().equalsIgnoreCase("power")) {
                System.out.println("Enter the base:");
                value = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter the exponent:");
                optionalValue = Double.parseDouble(scanner.nextLine());
                return String.valueOf(power(value, optionalValue));
            }
            if (command.trim().equalsIgnoreCase("log10")) {
                value=getValue(scanner);
                return String.valueOf(log10(value));
            }
            if (command.trim().equalsIgnoreCase("logNatural")) {
                value=getValue(scanner);
                return String.valueOf(logNatural(value));
            }
            if (command.trim().equalsIgnoreCase("log")) {
                System.out.println("Enter the base of the log:");
                value = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter the number:");
                optionalValue = Double.parseDouble(scanner.nextLine());
                return String.valueOf(log(value, optionalValue));
            }
            if (command.trim().equalsIgnoreCase("sin")) {
                value = getValue(scanner);
                return String.valueOf(sin(value));
            }
            if (command.trim().equalsIgnoreCase("arcsin")) {
                value = getValue(scanner);
                return String.valueOf(arcsin(value));
            }
            if (command.trim().equalsIgnoreCase("sinh")) {
                value = getValue(scanner);
                return String.valueOf(hypersin(value));
            }
            if (command.trim().equalsIgnoreCase("cos")) {
                value = getValue(scanner);
                return String.valueOf(cos(value));
            }
            if (command.trim().equalsIgnoreCase("arccos")) {
                value = getValue(scanner);
                return String.valueOf(arccos(value));
            }
            if (command.trim().equalsIgnoreCase("cosh")) {
                value = getValue(scanner);
                return String.valueOf(hypercos(value));
            }
            if (command.trim().equalsIgnoreCase("tan")) {
                value = getValue(scanner);
                return String.valueOf(tan(value));
            }
            if (command.trim().equalsIgnoreCase("arctan")) {
                value = getValue(scanner);
                return String.valueOf(arctan(value));
            }
            if (command.trim().equalsIgnoreCase("tanh")) {
                value = getValue(scanner);
                return String.valueOf(hypertan(value));
            }
            if (command.trim().equalsIgnoreCase("hypot")) {
                System.out.println("Enter the non-hypotenuse side A:");
                value = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter the non-hypotenuse side B:");
                optionalValue = Double.parseDouble(scanner.nextLine());
                return String.valueOf(pythagoras(value, optionalValue));
            }
            if (command.trim().equalsIgnoreCase("radians")) {
                value = getValue(scanner);
                return String.valueOf(radians(value));
            }
            if (command.trim().equalsIgnoreCase("degrees")) {
                value = getValue(scanner);
                return String.valueOf(degrees(value));
            }
            if (command.trim().equalsIgnoreCase("sqrt")) {
                value = getValue(scanner);
                return String.valueOf(sqrt(value));
            }
            if (command.trim().equalsIgnoreCase("cbrt")) {
                value = getValue(scanner);
                return String.valueOf(cbrt(value));
            }
            if (command.trim().equalsIgnoreCase("root")) {
                System.out.println("Enter the number to be rooted:");
                value = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter the n root number:");
                optionalValue = Double.parseDouble(scanner.nextLine());
                return String.valueOf(customroot(value, optionalValue));
            }
        } catch(Exception e){
            return "valueWasInvalid";
        }
        if(command.trim().equalsIgnoreCase("exit")){
            return "exit";
        }
        if(command.trim().equalsIgnoreCase("h")||command.trim().equalsIgnoreCase("help")){
            return"Info: \nCos, sin etc functions use radians \nCommands:\nhelp - Get this page \nexit - Exit the program \npageOne - Get page one of maths commands \npageTwo - Get page two of maths commands";
        }
        if(command.trim().equalsIgnoreCase("pageOne")){
            return "Page one of maths commands:\nadd - Adds two numbers\nremove - Removes the second number from the first\ndivide - Returns the first number divided by the second\nmultiply - multiplies two numbers\nmodulus - Gives the remainder of the division of the two numbers\nlog10 - Returns the log base 10 of the number\nlogNatural - Gets the natural log of the number\nlog -  Gets a custom base log of the number\npower - Gets the a number to the power of another number\nsin - Returns the sin of a number\narcsin - Returns the arc sin of a number\nsinh - Returns the hyper sin of a number\ncos - Returns the cos of a number\narccos - Returns the arc cos of a number\ncosh - Returns the hyper cos of a number\ntan - Returns the tan of a number\narctan - Returns the arc tan of a number\ntanh - Returns the hyper tan of a number";

        }
        if(command.trim().equalsIgnoreCase("pageTwo")){
            return "Page two of maths commands:\nhypot - Gets the hypotenuse of a triangle with sides A and B\nradians - Converts degrees to radians\ndegrees - Converts radians to degrees\nsqrt - Gets the square root of a number\ncbrt - Gets the cube root of a number\nroot - Gets the nth root of a number";
        }
        return "Invalid command";
    }
    public static double[] getTwoValues(Scanner scanner){
        System.out.println("Enter the first number:");
        double value = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter the second number:");
        double optionalValue = Double.parseDouble(scanner.nextLine());
        return new double[]{value,optionalValue};
    }
    public static double getValue(Scanner scanner){
        System.out.println("Enter the number:");
        double value = Double.parseDouble(scanner.nextLine());
        return value;
    }
}
