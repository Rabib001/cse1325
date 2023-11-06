#ifndef RECTANGLE_H
#define RECTANGLE_H
#include "Shape.h"

#include<string>

class Rectangle: public Shape
{
public:
    Rectangle(double  height, double width);
    std::string name() const override;
    double area() const override;
    std::string to_string() const override;

private:
    double _height;
    double _width;
};
#endif //RECTANGLE_H