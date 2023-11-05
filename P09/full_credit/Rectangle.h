#ifndef RECTANGLE_H
#define RECTANGLE_H
#include "Shape.h"

#include<string>

class Rectangle: public Shape
{
public:
    Rectangle(double  height, double width);
    std::string name() override;
    double area() override;

private:
    double _height;
    double _width;
};
#endif //RECTANGLE_H
