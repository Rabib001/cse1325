
#include <string>
using namespace std;
#include <fstream> 
#include <iostream> 
#include "Shape.h"

// Virtual destructor (no implementation needed)
//Shape::~Shape() {}

std::string Shape::name() const {
    return "Shape";
}

double Shape::area() const {
    return 0.0;
}

std::string Shape::to_string() const {
    return name() + " with area " + std::to_string(area());
}


// Implement the saveToPPM method (a simplified example, should be adapted for specific shapes)
void Shape::saveToPPM(const std::string& filename, int width, int height) const {
    std::ofstream file(filename);
    
    if (!file.is_open()) {
        std::cerr << "Error: Could not create PPM file " << filename << std::endl;
        return;
    }

    file << "P3" << std::endl;
    file << width << " " << height << std::endl;
    file << "255" << std::endl;

    // Implement image generation based on shape properties
    // This is a placeholder and should be adapted for specific shapes.
    
    for (int row = 0; row < height; row++) {
        for (int col = 0; col < width; col++) {
            // Example: Set pixel color based on shape properties
            int red = 0;
            int green = 0;
            int blue = 255;
            file << red << " " << green << " " << blue << " ";
        }
        file << std::endl;
    }

    file.close();
    std::cout << "PPM image saved to " << filename << std::endl;
}
