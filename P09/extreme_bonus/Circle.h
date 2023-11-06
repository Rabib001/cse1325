#ifndef CIRCLE_H
#define CIRCLE_H
#include "Shape.h"

#include<string>

class Circle: public Shape
{
public:
    Circle(double radius);
    std::string name() const override;
    double area() const override;
    std::string to_string() const;


private:
    double _radius;
};
#endif //CIRCLE_H
