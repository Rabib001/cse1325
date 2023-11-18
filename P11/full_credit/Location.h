#ifndef LOCATION_H
#define LOCATION_H

#include <iostream>
#include <string>

class Location
{
    public:
        Location(std::string filename, int line=0);
        bool operator==(const Location& location) const;
        bool operator!=(const Location& location) const;
        bool operator<(const Location& location) const;
        bool operator>(const Location& location) const;
        bool operator<=(const Location& location) const;
        bool operator>=(const Location& location) const;
        friend std::ostream& operator<<(std::ostream& ost, const Location& location);

    private:
        std::string _filename;
        int _line;
};

#endif