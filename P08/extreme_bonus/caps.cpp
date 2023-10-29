#include <iostream>
#include <vector>
#include <cctype>
#include <algorithm>

bool sortByLength(const std::string& lhs, const std::string& rhs){
    int key = lhs.length() - rhs.length();
    if(key==0){
        key=lhs.compare(rhs);
    }
    
    return key < 0;
}
int main(int argc, char* argv[]) {
    std::vector<std::string> caps;
    std::vector<std::string>* no_caps = new std::vector<std::string>;

    for (int i = 1; i < argc; ++i) {
        std::string arg = argv[i];

        if (!arg.empty() && std::isupper(arg[0])) {
            caps.push_back(arg);
        } else {
            no_caps->push_back(arg);
        }
    }
    
    std::sort(caps.begin(),caps.end());
    std::sort(no_caps->begin(),no_caps->end(), sortByLength);

    std::cout << "Capitalized:" << std::endl;
    for (const std::string& word : caps) {
        std::cout << word << std::endl;
    }

    std::cout << "\nLower Case:" << std::endl;

    for (const std::string& word : *no_caps) {
        std::cout << word << std::endl;
    }

    delete no_caps;

    return 0;
}
