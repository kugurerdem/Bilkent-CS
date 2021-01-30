#include "Actor.h"

// DEFAULT CONSTRUCTOR
Actor::Actor(const string aName,const string aBirthPlace,
            const unsigned int aBirthYear){
    this->name = aName;
    this->birthPlace = aBirthPlace;
    this->birthYear = aBirthYear;
}


// COPY CONSTRUCTOR
Actor::Actor(const Actor &actorToCopy){
    this->name = actorToCopy.name;
    this->birthPlace = actorToCopy.birthPlace;
    this->birthYear = actorToCopy.birthYear;
}

// Destructor
Actor::~Actor(){ }

// Overloading = operator
void Actor::operator=(const Actor &right){
    if( &right != this){
        this->name = right.name;
        this->birthPlace = right.birthPlace;
        this->birthYear = right.birthYear;
    }
}

string Actor::getName() const{
    return name;
}

string Actor::getBirthPlace() const{
    return birthPlace;
}
unsigned int Actor::getBirthYear() const{
    return birthYear;
}

ostream& operator<<(ostream& out,const Actor& a){
    return out << a.name << ", " << a.birthPlace << ", " << a.birthYear << endl;
}
