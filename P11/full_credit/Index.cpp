#include "Index.h"

Index::Index(){}

void Index::add_word(Word word, const std::string filename, int line)
{
    Location location(filename,line);

    auto it = _index.find(word);

    if(it==_index.end())
    {
        Locations new_set;
        new_set.insert(location);
        _index[word]=new_set;
    }
    else
    {
        it->second.insert(location);
    }
}

std::ostream& operator<<(std::ostream& ost, const Index& index)
{
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
