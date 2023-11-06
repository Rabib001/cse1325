#ifndef CIRCLE_H
#define CIRCLE_H
#include "Shape.h"

#include<string>

class Circle: public Shape
{
public:
    Circle(double radius);
    std::string name() override;
    double area() override;

private:
    double _radius;
};
#endif //CIRCLE_H
