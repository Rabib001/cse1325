#include "Time.h"
#include <iostream>

int main() {

    int seconds = 600;
    Time time{9, 30, 0};
    
    Time result1 = time + seconds;
    Time result2 = seconds + time;

    std::cout << result1 << " is also " << result2 << std::endl;

    return 0;
}
