#include "Circle.h"
#include <cmath>

Circle::Circle(double radius)
    : _radius(radius) {}

std::string Circle::name() const
{
    return "Circle radius: " + std::to_string(_radius);
}

double Circle::area() const
{
    return M_PI * _radius * _radius;
}

std::string Circle::to_string() const
{
    return Shape::to_string(); 
}
