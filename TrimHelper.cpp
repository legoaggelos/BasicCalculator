#include "TrimHelper.h"
#include <string>
namespace Trim{
    constexpr std::string_view ws = " \t\n\r\f\v";


inline std::string& rtrim(std::string& s)
{
    s.erase(s.find_last_not_of(ws) + 1);
    return s;
}


inline std::string& ltrim(std::string& s)
{
    s.erase(0, s.find_first_not_of(ws));
    return s;
}


inline std::string& trim(std::string& s)
{
    return ltrim(rtrim(s));
}
}