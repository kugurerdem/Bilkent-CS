#include "SimpleFilm.h"
#include <iostream>

#include <string> 

using namespace std;

// Default constructor
Film::Film(const string fTitle, const string fDirector,
           const unsigned int fYear, const unsigned int fDuration)
{
    this->title = fTitle;
    this->director = fDirector;
    this->year = fYear;
    this->duration = fDuration;

    // cout << "Constructed Film Object" << endl;
}

// Copy constructor
Film::Film(const Film &toCopy)
{
    this->title = toCopy.title;
    this->director = toCopy.director;
    this->year = toCopy.year;
    this->duration = toCopy.duration;
}

// Destructor
Film::~Film(){ }

// Overloading = operator
void Film::operator=(const Film &right){
    if( &right != this){
        this->title = right.title;
        this->director = right.director;
        this->year = right.year;
        this->duration = right.duration;
    }
}

// GETTER FUNCTIONS
string Film::getTitle() const{
    return title;
}

string Film::getDirector() const{
    return director;
}

unsigned int Film::getYear() const{
    return year;
}

unsigned int Film::getDuration() const{
    return duration;
}

// overloading << operator
ostream& operator<<(ostream& out,const Film& f){
    out << f.title << ", " << f.year << ", " << f.director << ", " 
        << f.duration << " min" << endl;
    return out;
}