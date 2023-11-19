#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include "Index.h"

std::string clean_word(const std::string& dirty_word) {
    std::string word = dirty_word;

    while (!word.empty() && !isalpha(word.front())) {
        word.erase(0, 1);
    }

    while (!word.empty() && !isalpha(word.back())) {
        word.pop_back();
    }

    for (char& c : word) {
        c = tolower(c);
    }

    return word;
}

int main(int argc, char* argv[]) {
    if (argc < 2) {
        std::cerr << "Usage: " << argv[0] << " file1 file2 ..." << std::endl;
        return 1;
    }

    Index index;

    for (int i = 1; i < argc; ++i) {
        std::ifstream file(argv[i]);

        if (!file.is_open()) {
            std::cerr << "Error: Unable to open file " << argv[i] << std::endl;
            continue;  
        }

        std::string line;
        int line_number = 1;

        while (std::getline(file, line)) {
            std::istringstream iss(line);
            std::string word;

            while (iss >> word) {
                std::string cleaned_word = clean_word(word);

                if (!cleaned_word.empty()) {
                    index.add_word(cleaned_word, argv[i], line_number);
                }
            }

            ++line_number;
        }

        file.close();
    }

    std::cout << "========" << std::endl;
    std::cout << " INDEX"<< std::endl;
    std::cout << "========" << std::endl;
    std::cout << index;

    return 0;
}
