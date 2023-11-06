#include "Rectangle.h"

Rectangle::Rectangle(double  height, double width)
    :_height(height), _width(width){}

std::string Rectangle::name() const
{
    return "Rectangle height: " + std::to_string(_height) + " width: " + std::to_string(_width);
}

double Rectangle::area() const
{
    return _height*_width;
}

std::string Rectangle::to_string() const
{
    return Shape::to_string();  // Use the base class implementation
}