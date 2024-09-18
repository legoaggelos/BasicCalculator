#pragma once
#include <string>
#include <utility>
#include <cmath>
constexpr double PI {3.141592653589793};
constexpr double E {2.718281828459045};
constexpr double glr {1.618033988749894};
class Calculator
{
    double add(double firstValue, double secondValue);

    double remove(double firstValue, double secondValue);

    double multiply(double firstValue, double secondValue);

    double divide(double firstValue, double secondValue);

    double modulus(double firstValue, double secondValue);

    double power(double base, double exponent);

    double log10(double value);

    double logNatural(double value);

    double log(double base, double value);

    double sin(double value);

    double arcsin(double value);

    double hypersin(double value);

    double pythagoras(double sideA, double sideB);

    double cos(double value);

    double arccos(double value);

    double hypercos(double value);

    double tan(double value);

    double arctan(double value);

    double hypertan(double value);

    double radians(double degrees);

    double degrees(double radians);

    double sqrt(double value);

    double cbrt(double value);

    double customRoot(double value, double nthRoot);
    std::string getValueFromCommand(std::string command, std::string trigType, double lastValue);

    std::pair<double, double> getTwoValues(double lastValue);

    double getValue(double lastValue);

    double customParseDouble(std::string value, double lastValue);
};
