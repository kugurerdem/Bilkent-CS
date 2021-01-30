#include "Author.h"

#include <string>
using namespace std;

Author::Author(){
    name = "";
    id = -1;
}

Author::Author(const int _id, const string _name){
    id = _id;
    name = _name;
}

int Author::getID() const{
    return id;
}

void Author::setID(const int _id){
    this->id = _id;
}

string Author::getName() const{
    return name;
}

void Author::setName(const string _name){
    this->name = _name;
}