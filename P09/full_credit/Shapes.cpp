#include <iostream>
#include <vector>
#include "Shape.h"
#include "Rectangle.h"
#include "Circle.h"

int main()
{
    Rectangle rectangle (5.0,6.0);
    Circle circle(2.0);

    std::vector<Shape*> shapes;

    shapes.push_back(&rectangle);
    shapes.push_back(&circle);

    for(const auto shape : shapes)
    {
        std::cout << shape->to_string() <<std::endl;
    }
    return 0;
}