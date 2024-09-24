#include "TrimHelper.h"
#include <string>
#include <cctype>
#include<bits/stdc++.h> 

constexpr std::string_view ws = " \t\n\r\f\v";


inline std::string& Trim::rtrim(std::string& s)
{
    s.erase(s.find_last_not_of(ws) + 1);
    return s;
}


inline std::string& Trim::ltrim(std::string& s)
{
    s.erase(0, s.find_first_not_of(ws));
    return s;
}


 std::string& Trim::trim(std::string& s)
{
    return ltrim(rtrim(s));
}
std::string& Trim::toLower(std::string& s){
    for(unsigned int i{0};i<s.size();i++){
        s[i]=(static_cast<char>(std::tolower(static_cast<char>(s[i]))));
    }
    return s;
}
std::string& Trim::formatToEquals(std::string& s){
    s=Trim::toLower(Trim::trim(s));
    return s;
}

     std::string Trim::precisionToString(const double a_value, const int n)
{
    std::ostringstream out;
    out.precision(n);
    out << std::fixed << a_value;
    return std::move(out).str();
}
