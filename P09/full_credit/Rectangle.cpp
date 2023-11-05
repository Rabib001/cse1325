#include "Rectangle.h"

Rectangle::Rectangle(double  height, double width)
    :_height(height), _width(width){}

std::string Rectangle::name()
{
    return "Rectangle height: " + std::to_string(_height) + " width: " + std::to_string(_width);
}

double Rectangle::area()
{
    return _height*_width;
}