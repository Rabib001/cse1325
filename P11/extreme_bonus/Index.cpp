#include "Index.h"

Index::Index() {}

void Index::add_word(Word word, const std::string filename, int line)
{
    _index.insert(std::make_pair(word, Location(filename, line)));
}

std::ostream& operator<<(std::ostream& ost, const Index& index)
{
    Location::next_word();
    auto it = index._index.begin();
    while (it != index._index.end())
    {
        ost << it->first << ": ";

        auto range = index._index.equal_range(it->first);
        for (auto loc_it = range.first; loc_it != range.second; ++loc_it)
        {
            ost << loc_it->second << ", ";
        }

        ost << "\n";

        it = range.second;
    }
    return ost;
}
