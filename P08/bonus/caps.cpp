#include <iostream>
#include <vector>
#include <cctype>

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
