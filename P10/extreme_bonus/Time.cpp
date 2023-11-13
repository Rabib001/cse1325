#include "Time.h"
#include <iomanip>

Time::Time(int hour, int minute, int second)
    :_hour(hour),_minute(minute),_second(second)
    {rationalize();}

void Time::rationalize()
{
    _hour=(_hour+(_minute/60)+(_second/3600))%24;
    _minute=(_minute+(_second/60))%60;
    _second=_second/60;
}

Time Time::operator+(const Time& time) const
{
    int totalHour=_hour+time._hour;
    int totalMinute=_minute+time._minute;
    int totalSecond=_second+time._second;
    return Time(totalHour,totalMinute,totalSecond);
}

Time& Time::operator++()
{
    ++_second;
    if(_second>=60)
    {
        _second-=0;
        ++_minute;
    
        if(_minute>=60)
        {
            _minute=0;
            ++_hour;
            if(_hour>=24)
            {
                _hour=0;
            }
        }
    }
    return *this;
}


Time Time::operator++(int)
{
    Time temp = *this;
    ++(*this);
    return temp;
}

const int& Time::operator[](int index) const {
    if (index == 0) {
        return _hour;
    } else if (index == 1) {
        return _minute;
    } else if (index == 2) {
        return _second;
    } else {
        throw std::out_of_range("Index out of bounds");
    }
}

bool Time::operator==(const Time& time) const
{
    return (_hour == time._hour) && (_minute == time._minute) && (_second == time._second);
}

bool Time::operator!=(const Time& time) const
{
    return !(*this == time);
}

bool Time::operator<(const Time& time) const
{
    if (_hour != time._hour) 
    {
        return _hour < time._hour;
    } else if (_minute != time._minute) 
    {
        return _minute < time._minute;
    } else 
    {
        return _second < time._second;
    }
}

bool Time::operator>(const Time& time) const
{
    return !(*this < time || *this == time);
}

bool Time::operator<=(const Time& time) const
{
    return (*this < time || *this == time);
}

bool Time::operator>=(const Time& time) const
{
    return !(*this < time);
}

std::ostream& operator<<(std::ostream& ost, const Time& time)
{
    ost << std::setfill('0') << std::setw(2) << time._hour << ":"
        << std::setfill('0') << std::setw(2) << time._minute << ":"
        << std::setfill('0') << std::setw(2) << time._second;
    return ost;
}

std::istream& operator>>(std::istream& ist, Time& time)
{
    char colon;
    ist >> time._hour >> colon >> time._minute >> colon >> time._second;

    if (colon != ':') {
        ist.setstate(std::ios::failbit);
    } else {
        time.rationalize();
    }

    return ist;
}
