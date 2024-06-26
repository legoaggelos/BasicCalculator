package com.legoaggelos.calculating;

import java.util.Scanner;

public class Calculator {
    private final Scanner scanner;

    public static double add(double firstValue, double secondValue) {
        return firstValue + secondValue;
    }

    public static double remove(double firstValue, double secondValue) {
        return add(firstValue, -secondValue);
    }

    public static double multiply(double firstValue, double secondValue) {
        return firstValue * secondValue;
    }

    public static double divide(double firstValue, double secondValue) {
        return firstValue / secondValue;
    }

    public static double modulus(double firstValue, double secondValue) {
        return firstValue % secondValue;
    }

    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public static double log10(double value) {
        return Math.log10(value);
    }

    public static double logNatural(double value) {
        return Math.log(value);
    }

    public static double log(double base, double value) {
        return log10(value) / log10(base);
    }

    public static double sin(double value) {
        return Math.sin(value);
    }

    public static double arcsin(double value) {
        return Math.asin(value);
    }

    public static double hypersin(double value) {
        return Math.sinh(value);
    }

    public static double pythagoras(double sideA, double sideB) {
        return Math.hypot(sideA, sideB);
    }

    public static double cos(double value) {
        return Math.cos(value);
    }

    public static double arccos(double value) {
        return Math.acos(value);
    }

    public static double hypercos(double value) {
        return Math.cosh(value);
    }

    public static double tan(double value) {
        return Math.tan(value);
    }

    public static double arctan(double value) {
        return Math.atan(value);
    }

    public static double hypertan(double value) {
        return Math.tanh(value);
    }

    public static double radians(double degrees) {
        return Math.toRadians(degrees);
    }

    public static double degrees(double radians) {
        return Math.toDegrees(radians);
    }

    public static double sqrt(double value) {
        return Math.sqrt(value);
    }

    public static double cbrt(double value) {
        return Math.cbrt(value);
    }

    public static double customroot(double value, double nthRoot) {
        return power(value, divide(1, nthRoot));
    }

    public Calculator(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getValueFromCommand(String command, String trigType, double lastValue) {
        double value;
        double optionalValue;
        command = command.trim();
        try {
            if (command.equalsIgnoreCase("add")) {
                double[] values = getTwoValues(scanner, lastValue);
                value = values[0];
                optionalValue = values[1];
                return String.valueOf(add(value, optionalValue));
            }
            if (command.equalsIgnoreCase("remove")) {
                double[] values = getTwoValues(scanner, lastValue);
                value = values[0];
                optionalValue = values[1];
                return String.valueOf(remove(value, optionalValue));
            }
            if (command.equalsIgnoreCase("divide")) {
                double[] values = getTwoValues(scanner, lastValue);
                value = values[0];
                optionalValue = values[1];
                return String.valueOf(divide(value, optionalValue));
            }
            if (command.equalsIgnoreCase("multiply")) {
                double[] values = getTwoValues(scanner, lastValue);
                value = values[0];
                optionalValue = values[1];
                return String.valueOf(multiply(value, optionalValue));
            }
            if (command.equalsIgnoreCase("modulus")) {
                double[] values = getTwoValues(scanner, lastValue);
                value = values[0];
                optionalValue = values[1];
                return String.valueOf(modulus(value, optionalValue));
            }
            if (command.equalsIgnoreCase("power")) {
                System.out.println("Enter the base:");
                value = customParseDouble(scanner.nextLine(), lastValue);
                System.out.println("Enter the exponent:");
                optionalValue = customParseDouble(scanner.nextLine(), lastValue);
                return String.valueOf(power(value, optionalValue));
            }
            if (command.equalsIgnoreCase("log10")) {
                value = getValue(scanner, lastValue);
                return String.valueOf(log10(value));
            }
            if (command.equalsIgnoreCase("logNatural")) {
                value = getValue(scanner, lastValue);
                return String.valueOf(logNatural(value));
            }
            if (command.equalsIgnoreCase("log")) {
                System.out.println("Enter the base of the log:");
                value = customParseDouble(scanner.nextLine(), lastValue);
                System.out.println("Enter the number:");
                optionalValue = customParseDouble(scanner.nextLine(), lastValue);
                return String.valueOf(log(value, optionalValue));
            }
            if (command.equalsIgnoreCase("sin")) {
                value = getValue(scanner, lastValue);
                if (trigType.trim().equalsIgnoreCase("radians")) {
                    return String.valueOf(sin(value));
                } else if (trigType.trim().equalsIgnoreCase("degrees")) {
                    return String.valueOf(sin(radians(value)));
                }
            }
            if (command.equalsIgnoreCase("arcsin")) {
                value = getValue(scanner, lastValue);
                return String.valueOf(arcsin(value));

            }
            if (command.equalsIgnoreCase("sinh")) {
                value = getValue(scanner, lastValue);
                return String.valueOf(hypersin(value));
            }
            if (command.equalsIgnoreCase("cos")) {
                value = getValue(scanner, lastValue);
                if (trigType.trim().equalsIgnoreCase("radians")) {
                    return String.valueOf(cos(value));
                } else if (trigType.trim().equalsIgnoreCase("degrees")) {
                    return String.valueOf(cos(radians(value)));
                }
            }
            if (command.equalsIgnoreCase("arccos")) {
                value = getValue(scanner, lastValue);
                return String.valueOf(arccos(value));
            }
            if (command.equalsIgnoreCase("cosh")) {
                value = getValue(scanner, lastValue);
                return String.valueOf(hypercos(value));
            }
            if (command.equalsIgnoreCase("tan")) {
                value = getValue(scanner, lastValue);
                if (trigType.trim().equalsIgnoreCase("radians")) {
                    return String.valueOf(tan(value));
                } else if (trigType.trim().equalsIgnoreCase("degrees")) {
                    return String.valueOf(tan(radians(value)));
                }
            }
            if (command.equalsIgnoreCase("arctan")) {
                value = getValue(scanner, lastValue);
                return String.valueOf(arctan(value));
            }
            if (command.equalsIgnoreCase("tanh")) {
                value = getValue(scanner, lastValue);
                return String.valueOf(hypertan(value));
            }
            if (command.equalsIgnoreCase("hypot")) {
                System.out.println("Enter the non-hypotenuse side A:");
                value = customParseDouble(scanner.nextLine(), lastValue);
                System.out.println("Enter the non-hypotenuse side B:");
                optionalValue = customParseDouble(scanner.nextLine(), lastValue);
                return String.valueOf(pythagoras(value, optionalValue));
            }
            if (command.equalsIgnoreCase("radians")) {
                value = getValue(scanner, lastValue);
                return String.valueOf(radians(value));
            }
            if (command.equalsIgnoreCase("degrees")) {
                value = getValue(scanner, lastValue);
                return String.valueOf(degrees(value));
            }
            if (command.equalsIgnoreCase("sqrt")) {
                value = getValue(scanner, lastValue);
                return String.valueOf(sqrt(value));
            }
            if (command.equalsIgnoreCase("cbrt")) {
                value = getValue(scanner, lastValue);
                return String.valueOf(cbrt(value));
            }
            if (command.equalsIgnoreCase("root")) {
                System.out.println("Enter the number to be rooted:");
                value = customParseDouble(scanner.nextLine(), lastValue);
                System.out.println("Enter the n root number:");
                optionalValue = customParseDouble(scanner.nextLine(), lastValue);
                return String.valueOf(customroot(value, optionalValue));
            }
        } catch (Exception e) {
            return "valueWasInvalid";
        }
        if (command.equalsIgnoreCase("switch")) {
            if (trigType.equals("radians")) {
                return "degrees";
            } else {
                return "radians";
            }
        }
        if (command.equalsIgnoreCase("type")) {
            return trigType;
        }
        if (command.equalsIgnoreCase("exit")) {
            return "exit";
        }
        if (command.equalsIgnoreCase("h") || command.equalsIgnoreCase("help")) {
            return "Info: \nTrig functions use radians by default.\nType last when entering a number to get the last number outputted,\nglr to use the golden ratio as the number,\npi to use pi as the number and\ne to use euler's number as the number.\nDefaults to zero.\nCommands:\nhelp - Get this page \nexit - Exit the program \nswitch - Makes trigonometry functions use degrees if they are using radians and vice versa \ntype - Shows if trigonometry functions use radians or degrees\npageOne - Get page one of maths commands \npageTwo - Get page two of maths commands";
        }
        if (command.equalsIgnoreCase("pageOne")) {
            return "Page one of maths commands:\nadd - Adds two numbers\nremove - Removes the second number from the first\ndivide - Returns the first number divided by the second\nmultiply - multiplies two numbers\nmodulus - Gives the remainder of the division of the two numbers\nlog10 - Returns the log base 10 of the number\nlogNatural - Gets the natural log of the number\nlog -  Gets a custom base log of the number\npower - Gets the a number to the power of another number\nsin - Returns the sin of a number\narcsin - Returns the arc sin of a number\nsinh - Returns the hyper sin of a number\ncos - Returns the cos of a number\narccos - Returns the arc cos of a number\ncosh - Returns the hyper cos of a number\ntan - Returns the tan of a number\narctan - Returns the arc tan of a number\ntanh - Returns the hyper tan of a number";

        }
        if (command.equalsIgnoreCase("pageTwo")) {
            return "Page two of maths commands:\nhypot - Gets the hypotenuse of a triangle with sides A and B\nradians - Converts degrees to radians\ndegrees - Converts radians to degrees\nsqrt - Gets the square root of a number\ncbrt - Gets the cube root of a number\nroot - Gets the nth root of a number";
        }
        return "Invalid command";
    }

    public static double[] getTwoValues(Scanner scanner, double lastValue) {
        System.out.println("Enter the first number:");
        double value = customParseDouble(scanner.nextLine(), lastValue);
        System.out.println("Enter the second number:");
        double optionalValue = customParseDouble(scanner.nextLine(), lastValue);
        return new double[]{value, optionalValue};
    }

    public static double getValue(Scanner scanner, double lastValue) {
        System.out.println("Enter the number:");
        return customParseDouble(scanner.nextLine(), lastValue);
    }

    public static double customParseDouble(String value, double lastValue) throws NullPointerException, NumberFormatException {
        if (value.trim().equalsIgnoreCase("last")) {
            return lastValue;
        }
        if(value.trim().equalsIgnoreCase("e")){
            return Math.E;
        }
        if(value.trim().equalsIgnoreCase("pi")){
            return Math.PI;
        }
        if(value.trim().equalsIgnoreCase("glr")){
            return (1+sqrt(5))/2;
        }
        return Double.parseDouble(value);
    }
}
