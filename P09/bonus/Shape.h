#ifndef SHAPE_H
#define SHAPE_H

#include<string>

class Shape
{
public:
    virtual ~Shape() = default; 
    virtual std::string name() = 0;
    virtual double area() = 0;
    std::string to_string();
};

#endif //SHAPE_H
