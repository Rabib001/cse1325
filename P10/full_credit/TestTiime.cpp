#include "Time.h"
#include <iostream>

int main() {
    Time t1;
    Time t2(8, 30, 45);
    Time t3(10, 59, 59);

    Time t4 = t2 + t3;
    std::cout << "Addition result: " << t4 << std::endl;

    ++t2;
    std::cout << "Pre-increment t2: " << t2 << std::endl;

    Time t5 = t3++;
    std::cout << "Post-increment t3: " << t3 << std::endl;
    std::cout << "Post-increment result: " << t5 << std::endl;

    std::cout << "t1 == t2: " << (t1 == t2) << std::endl;
    std::cout << "t2 != t3: " << (t2 != t3) << std::endl;
    std::cout << "t2 < t3: " << (t2 < t3) << std::endl;
    std::cout << "t2 > t3: " << (t2 > t3) << std::endl;
    std::cout << "t2 <= t3: " << (t2 <= t3) << std::endl;
    std::cout << "t2 >= t3: " << (t2 >= t3) << std::endl;

    Time t6;
    std::cout << "Enter a time (HH:MM:SS): ";
    std::cin >> t6;
    std::cout << "Input time: " << t6 << std::endl;

    return 0;
}
