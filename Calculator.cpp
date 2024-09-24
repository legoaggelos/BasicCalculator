#include "Calculator.h"
#include "TrimHelper.h"
#include <cmath>
#include <string>
#include <utility>
#include <exception>
#include <iostream>

    double Calculator::add(double firstValue, double secondValue){
        return firstValue+secondValue;
    }

    double Calculator::remove(double firstValue, double secondValue){
        return add(firstValue, -secondValue);
    }

    double Calculator::multiply(double firstValue, double secondValue){
        return firstValue*secondValue;
    }

    double Calculator::divide(double firstValue, double secondValue){
        if(secondValue==0){
            throw std::invalid_argument("");
        }
        return firstValue/secondValue;
    }

    double Calculator::modulus(double firstValue, double secondValue){
        if(secondValue==0){
            throw "Tried to modulo by 0";
        }
        return std::fmod(firstValue,secondValue);
    }

    double Calculator::power(double base, double exponent){
        return std::pow(base,exponent);
    }

    double Calculator::log10(double value){
        return std::log10(value);
    }

    double Calculator::logNatural(double value){
        return std::log(value);
    }

    double Calculator::log(double base, double value){
        return Calculator::divide(std::log10(value), std::log10(base));
    }

    double Calculator::sin(double value){
        return std::sin(value);
    }

    double Calculator::arcsin(double value){
        return std::asin(value);
    }

    double Calculator::hypersin(double value){
        return std::sinh(value);
    }

    double Calculator::pythagoras(double sideA, double sideB){
        return sqrt(power(sideA,2)+power(sideB,2));
    }

    double Calculator::cosine(double value){
        return std::cos(value);
    }

    double Calculator::arccos(double value){
        return std::acos(value);
    }

    double Calculator::hypercos(double value){
        return std::cosh(value);
    }

    double Calculator::tan(double value){
        return std::tan(value);
    }

    double Calculator::arctan(double value){
        return std::atan(value);
    }

    double Calculator::hypertan(double value){
        return std::tanh(value);
    }

    double Calculator::radians(double degrees){
        return degrees*(PI/180);
    }

    double Calculator::degrees(double radians){
        return radians*(180/PI);
    }

    double Calculator::sqrt(double value){
        return std::sqrt(value);
    }

    double Calculator::cbrt(double value){
        return std::cbrt(value);
    }

    double Calculator::customRoot(double value, double nthRoot){
        return Calculator::power(value, Calculator::divide(1,nthRoot));
    }
    

    
    double Calculator::customParseDouble(std::string value, double lastValue){
        std::string trimmedValue{Trim::toLower(Trim::trim(value))};
        if(trimmedValue=="last"){
            return lastValue;
        }
        if(trimmedValue=="e"){
            return E;
        }
        if(trimmedValue=="pi"){
            return PI;
        }
        if(trimmedValue=="glr"){
            return glr;
        }
        return std::stod(value);
    }
    double Calculator::getValue(double lastValue, std::string_view prompt="Enter the number: \n"){
        std::cout<<prompt;
        std::string num{};
        std::cin>>num;
        return customParseDouble(num,lastValue);
    }
std::pair<double, double> Calculator::getTwoValues(double lastValue,std::pair<std::string_view,std::string_view> prompts={"Enter the first number: \n","Enter the second number: \n"}){
    return {getValue(lastValue,prompts.first),getValue(lastValue,prompts.second)};
}
    std::string Calculator::getValueFromCommand(std::string inputCommand, std::string trigTypeInput, double lastValue){
        double value;
        double optionalValue;
        std::string command {Trim::toLower(Trim::trim(inputCommand))};
        std::string trigType {Trim::toLower(Trim::trim(trigTypeInput))};
        try {
            if (command=="add") {
                auto values = getTwoValues(lastValue);
                value = values.first;
                optionalValue = values.second;
                return Trim::precisionToString(add(value, optionalValue),15);
            }
            if (command=="remove") {
                auto values = getTwoValues(lastValue);
                value = values.first;
                optionalValue = values.second;
                return Trim::precisionToString(remove(value, optionalValue),15);
            }
            if (command=="divide") {
                auto values = getTwoValues(lastValue);
                value = values.first;
                optionalValue = values.second;
                return Trim::precisionToString(divide(value, optionalValue),15);
            }
            if (command=="multiply") {
                auto values = getTwoValues(lastValue);
                value = values.first;
                optionalValue = values.second;
                return Trim::precisionToString(multiply(value, optionalValue),15);
            }
            if (command=="modulus") {
                auto values = getTwoValues(lastValue);
                value = values.first;
                optionalValue = values.second;
                return Trim::precisionToString(modulus(value, optionalValue),15);
            }
            if (command=="power") {
                auto values{getTwoValues(lastValue,{"Enter the base: \n", "Enter the exponent: \n"})};
                value = values.first;
                optionalValue = values.second;
                return Trim::precisionToString(power(value, optionalValue),15);
            }
            if (command=="log10") {
                value = getValue(lastValue);
                return Trim::precisionToString(log10(value),15);
            }
            if (command=="lognatural") {
                value = getValue(lastValue);
                return Trim::precisionToString(logNatural(value),15);
            }
            if (command=="log") {
                auto values{getTwoValues(lastValue,{"Enter the base of the log:\n", "Enter the number:\n"})};
                value = values.first;
                optionalValue = values.second;
                return Trim::precisionToString(log(value, optionalValue),15);
            }
            if (command=="sin") {
                value = getValue(lastValue);
                if (trigType=="radians") {
                    return Trim::precisionToString(sin(value),15);
                } else if (trigType=="degrees") {
                    return Trim::precisionToString(sin(radians(value)),15);
                }
            }
            if (command=="arcsin") {
                value = getValue(lastValue);
                if (trigType=="radians") {
                    return Trim::precisionToString(arcsin(value),15);
                } else if (trigType=="degrees") {
                    return Trim::precisionToString(arcsin(radians(value)),15);
                }
            }
            if (command=="sinh") {
                value = getValue(lastValue);
                if (trigType=="radians") {
                    return Trim::precisionToString(hypersin(value),15);
                } else if (trigType=="degrees") {
                    return Trim::precisionToString(hypersin(radians(value)),15);
                }
            }
            if (command=="cos") {
                value = getValue(lastValue);
                if (trigType=="radians") {
                    return Trim::precisionToString(cos(value),15);
                } else if (trigType=="degrees") {
                    return Trim::precisionToString(cos(radians(value)),15);
                }
            }
            if (command=="arccos") {
               value = getValue(lastValue);
                if (trigType=="radians") {
                    return Trim::precisionToString(arccos(value),15);
                } else if (trigType=="degrees") {
                    return Trim::precisionToString(arccos(radians(value)),15);
                }
            }
            if (command=="cosh") {
                value = getValue(lastValue);
                if (trigType=="radians") {
                    return Trim::precisionToString(hypercos(value),15);
                } else if (trigType=="degrees") {
                    return Trim::precisionToString(hypercos(radians(value)),15);
                }
            }
            if (command=="tan") {
                value = getValue(lastValue);
                if (trigType=="radians") {
                    return Trim::precisionToString(tan(value),15);
                } else if (trigType=="degrees") {
                    return Trim::precisionToString(tan(radians(value)),15);
                }
            }
            if (command=="arctan") {
                value = getValue(lastValue);
                if (trigType=="radians") {
                    return Trim::precisionToString(arctan(value),15);
                } else if (trigType=="degrees") {
                    return Trim::precisionToString(arctan(radians(value)),15);
                }
            }
            if (command=="tanh") {
                value = getValue(lastValue);
                if (trigType=="radians") {
                    return Trim::precisionToString(hypertan(value),15);
                } else if (trigType=="degrees") {
                    return Trim::precisionToString(hypertan(radians(value)),15);
                }
            }
            if (command=="hypot") {
                auto values{getTwoValues(lastValue,{"Enter the non-hypotenuse side A: \n", "Enter the non-hypotenuse side B: \n"})};
                value = values.first;
                optionalValue = values.second;
                return Trim::precisionToString(pythagoras(value, optionalValue),15);
            }
            if (command=="radians") {
                value = getValue(lastValue);
                return Trim::precisionToString(radians(value),15);
            }
            if (command=="degrees") {
                value = getValue(lastValue);
                return Trim::precisionToString(degrees(value),15);
            }
            if (command=="sqrt") {
                value = getValue(lastValue);
                return Trim::precisionToString(sqrt(value),15);
            }
            if (command=="cbrt") {
                value = getValue(lastValue);
                return Trim::precisionToString(cbrt(value),15);
            }
            if (command=="root") {
                auto values{getTwoValues(lastValue,{"Enter the number to be rooted: \n", "Enter the n root number: \n"})};
                value = values.first;
                optionalValue = values.second;
                return Trim::precisionToString(customRoot(value, optionalValue),15);
            }
        } catch (const std::exception&) {
            return "valueWasInvalid";
        }
        if (command=="switch") {
            if (trigType=="radians") {
                return "degrees";
            } else {
                return "radians";
            }
        }
        if (command=="type") {
            return trigType;
        }
        if (command=="exit") {
            return "exit";
        }
        if (command=="h" || command=="help") {
            return "Info: \nTrig functions use radians by default.\nType last when entering a number to get the last number outputted, defaults to zero.\nglr to use the golden ratio as the number,\npi to use pi as the number and\ne to use euler's number as the number.\nCommands:\nhelp - Get this page \nexit - Exit the program \nswitch - Makes trigonometry functions use degrees if they are using radians and vice versa \ntype - Shows if trigonometry functions use radians or degrees\npageOne - Get page one of maths commands \npageTwo - Get page two of maths commands\n";
        }
        if (command=="pageone") {
            return "Page one of maths commands:\nadd - Adds two numbers\nremove - Removes the second number from the first\ndivide - Returns the first number divided by the second\nmultiply - multiplies two numbers\nmodulus - Gives the remainder of the division of the two numbers\nlog10 - Returns the log base 10 of the number\nlogNatural - Gets the natural log of the number\nlog -  Gets a custom base log of the number\npower - Gets the a number to the power of another number\nsin - Returns the sin of a number\narcsin - Returns the arc sin of a number\nsinh - Returns the hyper sin of a number\ncos - Returns the cos of a number\narccos - Returns the arc cos of a number\ncosh - Returns the hyper cos of a number\ntan - Returns the tan of a number\narctan - Returns the arc tan of a number\ntanh - Returns the hyper tan of a number\n";

        }
        if (command=="pagetwo") {
            return "Page two of maths commands:\nhypot - Gets the hypotenuse of a triangle with sides A and B\nradians - Converts degrees to radians\ndegrees - Converts radians to degrees\nsqrt - Gets the square root of a number\ncbrt - Gets the cube root of a number\nroot - Gets the nth root of a number\n";
        }
        return "Invalid command";
    }

