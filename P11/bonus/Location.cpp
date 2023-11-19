#include "Location.h"
#include <iostream>

std::string Location::last_filename="";

Location::Location(std::string filename, int line)
    :_filename(filename), _line(line){}

bool Location::operator==(const Location& location) const
{
    return (_filename == location._filename && _line == location._line);
}

bool Location::operator!=(const Location& location) const
{
    return !(*this == location);
}

bool Location::operator<(const Location& location) const
{
    if(_filename==location._filename)
    {
        return _line<location._line;
    }
    return _filename<location._filename;
}

bool Location::operator>(const Location& location) const
{
    return !(*this<location || *this==location);
}

bool Location::operator<=(const Location& location) const
{
    return (*this<location || *this==location);
}
bool Location::operator>=(const Location& location) const
{
    return (*this>location || *this==location);
}

std::ostream& operator<<(std::ostream& ost, const Location& location)
{
    if(location._filename!=Location::last_filename)
    {
        ost << location._filename<< "line ";
        Location::last_filename=location._filename;
    } 
    ost << location._line;
    return ost;
}

void Location::next_word()
{
    last_filename="";
}
