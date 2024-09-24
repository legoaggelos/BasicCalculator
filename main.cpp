#include <iostream>
#include "TrimHelper.h"
#include "Calculator.h"
#include <iomanip>
int main(){
        double lastValue = 0;
        std::cout<<("Welcome to the calculator!\nType a command or help for help.\n");
        std::cout << std::fixed << std::showpoint<<std::setprecision(15);
      
        std::string trigType = "radians";
        while (true) {
            std::cout<<("Enter a command: \n");
            std::string command;
            std::cin>>command;
            std::string valueFromCommand = Calculator::getValueFromCommand(command, trigType, lastValue);
            valueFromCommand=Trim::formatToEquals(valueFromCommand);
            if (command=="type") {
                std::cout<<("Trig functions are currently using " + valueFromCommand + ".\n");
                continue;
            }
            if (command=="switch") {
                trigType = valueFromCommand;
                std::cout<<("Trig functions now use " + valueFromCommand + ".\n");
                continue;
            }
            if (valueFromCommand=="invalid command") {
                std::cout<<("Invalid command. Type help to see list of commands.\n");
                continue;
            }
            if (valueFromCommand=="exit") {
                std::cout<<("Exiting...");
                return 0;
            }
            if (valueFromCommand=="valuewasinvalid") {
                std::cout<<("The last value was invalid.\n");
                continue;
            }
            try {
                lastValue = std::stod(valueFromCommand);
                std::cout<<valueFromCommand<<'\n';
            } catch (const std::exception& ignored) {
                std::cout<<(valueFromCommand)<<'\n';
            }
            
        }
    return 0;
}