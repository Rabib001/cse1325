#include "Index.h"
#include "Location.h"

Index::Index(){}

void Index::add_word(Word word, const std::string filename, int line)
{
    Locations& locations = _index[word];
    locations.insert(Location(filename, line));
}

std::ostream& operator<<(std::ostream& ost, const Index& index)
{
    Location::next_word();
    for(auto it=index._index.begin(); it!=index._index.end();++it)
    {
        ost<<it->first<<": ";

        for(auto loc_it=it->second.begin(); loc_it!=it->second.end();++loc_it)
        {
            ost<<*loc_it<<", ";
        }

        ost << "\n";
    }
    return ost;
}
