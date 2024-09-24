#pragma once
#include <string>
namespace Trim{

    inline std::string& rtrim(std::string& s);

    inline std::string& ltrim(std::string& s);

     std::string& trim(std::string& s);
     std::string& toLower(std::string& s);
     std::string& formatToEquals(std::string& s);
     std::string precisionToString(const double a_value, const int n);
}