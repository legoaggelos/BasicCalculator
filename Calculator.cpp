#include "Calculator.h"
#include <cmath>
#include <string>
#include <utility>
#include <exception>
    double add(double firstValue, double secondValue){
        return firstValue+secondValue;
    }

    double remove(double firstValue, double secondValue){
        return add(firstValue, -secondValue);
    }

    double multiply(double firstValue, double secondValue){
        return firstValue*secondValue;
    }

    double divide(double firstValue, double secondValue){
        if(secondValue==0){
            throw "Tried to divide by 0";
        }
        return firstValue/secondValue;
    }

    double modulus(double firstValue, double secondValue){
        if(secondValue==0){
            throw "Tried to modulo by 0";
        }
        return std::fmod(firstValue,secondValue);
    }

    double power(double base, double exponent){
        return std::pow(base,exponent);
    }

    double Calculator::log10(double value){
        return std::log10(value);
    }

    double logNatural(double value){
        return std::log(value);
    }

    double log(double base, double value){
        return divide(std::log10(value), std::log10(base));
    }

    double Calculator::sin(double value){
        return std::sin(value);
    }

    double arcsin(double value){
        return std::asin(value);
    }

    double hypersin(double value){
        return std::sinh(value);
    }

    double pythagoras(double sideA, double sideB){
        return sqrt(power(sideA,2)+power(sideB,2));
    }

    double Calculator::cos(double value){
        return std::cos(value);
    }

    double arccos(double value){
        return std::acos(value);
    }

    double hypercos(double value){
        return std::cosh(value);
    }

    double Calculator::tan(double value){
        return std::tan(value);
    }

    double arctan(double value){
        return std::atan(value);
    }

    double hypertan(double value){
        return std::tanh(value);
    }

    double radians(double degrees){
        return degrees*(PI/180);
    }

    double degrees(double radians){
        return radians*(180/PI);
    }

    double Calculator::sqrt(double value){
        return std::sqrt(value);
    }

    double Calculator::cbrt(double value){
        return std::cbrt(value);
    }

    double customRoot(double value, double nthRoot){
        return power(value, divide(1,nthRoot));
    }
    std::string getValueFromCommand(std::string command, std::string trigType, double lastValue);

    std::pair<double, double> getTwoValues(double lastValue);

    double getValue(double lastValue);

    double customParseDouble(std::string value, double lastValue);

