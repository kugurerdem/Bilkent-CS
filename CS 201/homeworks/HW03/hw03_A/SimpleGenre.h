#ifndef __SIMPLE_GENRE_H
#define __SIMPLE_GENRE_H
#include <string>

using namespace std;

class Genre {
public:
    Genre(const string gname = "");
    ~Genre ();
    Genre (const Genre &genreToCopy);
    void operator=(const Genre &right);
    string getGenreName() const;
    void setGenreName(const string gName);
private:
    string genreName;
};
#endif

