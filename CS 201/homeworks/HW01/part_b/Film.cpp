#include "Film.h"

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
    this->actors = NULL;
    this->noOfActors = 0;
    this->size = 0;

    // cout << "Constructed Film Object" << endl;
}

// Copy constructor
Film::Film(const Film &toCopy)
{
    this->title = toCopy.title;
    this->director = toCopy.director;
    this->year = toCopy.year;
    this->duration = toCopy.duration;
    this->noOfActors = toCopy.noOfActors;
    this->size = toCopy.size;

    if(this->size == 0){
        actors = NULL;
    } else{
        actors = new Actor[this->size];
        for(int i = 0; i < this->size; i++){
            actors[i] = toCopy.actors[i];
        }
    }
}

// Destructor
Film::~Film(){ 
    if (actors != NULL)
        delete [] actors;
}

// Overloading = operator
void Film::operator=(const Film &right){
    if( &right != this){
        this->title = right.title;
        this->director = right.director;
        this->year = right.year;
        this->duration = right.duration;
        this->noOfActors = right.noOfActors;
        this->size = right.size;

        if(this->size == 0){
            this->actors = NULL;
        } else{
            if(this->actors != NULL){
                delete [] actors;
            }

            actors = new Actor[this->size];
            for(int i = 0; i < this->size; i++){
                actors[i] = right.actors[i];
            }
        }
    }
}

// GETTER FUNCTIONS
string Film::getFilmTitle() const{
    return title;
}

string Film::getFilmDirector() const{
    return director;
}

unsigned int Film::getFilmYear() const{
    return year;
}

unsigned int Film::getFilmDuration() const{
    return duration;
}

unsigned int Film::calculateAverageActorAge() const{

    unsigned int sum = 0;
    for(int i = 0; i < this->noOfActors; i++){
        sum = sum + (this->year - actors[i].getBirthYear());
    }

    return sum / this->noOfActors;
}

bool Film::addActor(const string aName, const string aBirthPlace,
                    const unsigned int aBirthYear){
    
    // Is Actor in the collection?
    for(int i = 0; i < size; i++){
        if( actors[i].getName() == aName)
            return false;
    }
    
    if(actors == NULL){
        actors = new Actor[1];
        actors[0] = Actor(aName, aBirthPlace, aBirthYear);
        this->size++;
    } else{
        Actor* tmp = actors;
        actors = new Actor[++this->size];
        for(int i = 0; i < size - 1; i++){
            actors[i] = tmp[i];
        }

        actors[size - 1] = Actor(aName, aBirthPlace, aBirthYear);
        
        delete [] tmp;
    }
    this->noOfActors++;

    return true;
}

bool Film::removeActors(){
    if( actors != NULL)
        delete [] actors;
    this->size = 0;
    this->noOfActors = 0;

    actors = NULL;
}

// overloading << operator
ostream& operator<<(ostream& out,const Film& f){
    out << f.title << ", " << f.director << ", " << f.year << ", " 
        << f.duration << " min" << endl;
    for(int i = 0; i < f.noOfActors; i++){
        out << "   " << f.actors[i];
    }
    return out;
}