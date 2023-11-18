#ifndef INDEX_H
#define INDEX_H

#include <map>
#include<set>
#include<string>
#include "Location.h"

class Index
{
    public:
        using Word = std::string;
        using Locations = std::set<Location>;

        Index();

        void add_word(Word word, const std::string filename, int line);
        friend std::ostream& operator<<(std::ostream& ost, const Index& index);

    private:
        std::map<Word, Locations> _index;

};

#endif
