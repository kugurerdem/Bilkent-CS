#include "FC.h"

// DEFAULT CONSTRUCTOR
FC::FC(){
    films = NULL;
    size = 0;
    noOfFilms = 0;
}

// COPY CONSTRUCTOR
FC::FC(const FC &fcToCopy){
    noOfFilms = fcToCopy.noOfFilms;
    size = fcToCopy.size;

    if( size == 0){
        films = NULL;
    } else{
        films = new Film[size];
        for(int i = 0; i < size; i++){
            films[i] = fcToCopy.films[i];
        }
    }
}

// DESTRUCTOR
FC::~FC(){
    delete [] films;
}

// overloading = operator
void FC::operator=(const FC &right){
    if( &right != this){
        noOfFilms = right.noOfFilms;
        size = right.size;

        if( size == 0){
            films = NULL;
        } else{
            delete [] films;

            films = new Film[size];
            
            for(int i = 0; i < size; i++){
                films[i] = right.films[i];
            }
        }   
    }
}

// Function that adds a new film to the collection
bool FC::addFilm(const string fTitle, const string fDirector,
                 const unsigned int fYear, const unsigned int fDuration){
    // Checking if the film with same director & title is already in the collection
    for(int i = 0; i < size; i++){
        if( films[i].getFilmDirector() == fDirector && films[i].getFilmTitle() == fTitle){
            return false;
        } 
    }

    Film* temp = films;
    films = new Film[++size];
    noOfFilms++;

    for(int i = 0; i < size - 1; i++){
        films[i] = temp[i];
    }
    films[size - 1] = Film(fTitle, fDirector, fYear, fDuration);

    delete [] temp;

    return true;
}

// Function that removes a film from the list
bool FC::removeFilm(const string fTitle, const string fDirector){
    int index = -1;

    for(int i = 0; i < size; i++){
        if( films[i].getFilmDirector() == fDirector && films[i].getFilmTitle() == fTitle){
            index = i;
            break;
        }
    }

    // if the film is in the array
    if( index >= 0 && index < size){
        Film* temp = films;
        films = new Film[--size];
        noOfFilms--;
        
        // setting up the first part
        for(int i = 0; i < index; i++){
            films[i] = temp[i];
        }
        // setting up the second part
        for(int i = index; i < size; i++){
            films[i] = temp[i + 1];
        }

        delete [] temp;
        return true;
    }

    return false;
}

unsigned int FC::getFilms(Film *&allFilms) const{
    allFilms = new Film[size];
    for(int i = 0; i < size; i++){
        allFilms[i] = films[i];
    }

    return size;
}


bool FC::addActor(const string fTitle,const string fDirector,const string aName,
                    const string aBirthPlace,const unsigned int aBirthYear){
    for(int i = 0; i < this->size; i++){
        if(films[i].getFilmTitle() == fTitle && films[i].getFilmDirector() == fDirector){
            return films[i].addActor(aName, aBirthPlace, aBirthYear);
        }
    }
    
    return false;
}

bool FC::removeActors(const string fTitle,const string fDirector){
    for(int i = 0; i < this->size; i++){
        if(films[i].getFilmTitle() == fTitle && films[i].getFilmDirector() == fDirector ){
            films[i].removeActors();
            return true;
        }
    }

    return false;
}


unsigned int FC::calculateAverageDuration() const{
    if( this->size == 0){
        return 0;
    } else{
        unsigned int sum = 0;
        for(int i = 0; i < this->size; i++){
            sum = sum + films[i].getFilmDuration();
        }
        return sum / this->size;
    }
}
