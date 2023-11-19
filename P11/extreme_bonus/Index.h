#ifndef INDEX_H
#define INDEX_H

#include <map>
#include<string>
#include "Location.h"

class Index
{
    public:
        using Word = std::string;
        using Locations = std::multimap<Word, Location>;

        Index();

        void add_word(Word word, const std::string filename, int line);
        friend std::ostream& operator<<(std::ostream& ost, const Index& index);

    private:
        Locations _index;
};

#endif
