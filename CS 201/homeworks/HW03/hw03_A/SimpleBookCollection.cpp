#include "SimpleBookCollection.h"
#include <cstddef>
#include <iostream>

BookCollection::BookCollection(){
    name = "";
    genreCount = 0;
    head = NULL;
}

// TODO
BookCollection::~BookCollection(){
    GenreNode* cur = head;
    while( cur != NULL){
        GenreNode* tmp = cur;
        cur = cur->next;
        delete tmp;
    }
}

BookCollection::BookCollection(const BookCollection& toCopy) {
	name = toCopy.name;
    genreCount = toCopy.genreCount;

    if( genreCount == 0){
        head = NULL;
    } else{
        head = new GenreNode;
        head->g = toCopy.head->g;
        head->next = toCopy.head->next;

        GenreNode* newPtr = head;
        GenreNode* origPtr = toCopy.head->next;

        while(origPtr != NULL){
            newPtr->next = new GenreNode;
            newPtr = newPtr->next;
            newPtr->g = origPtr->g;

            origPtr = origPtr->next;
        }

        newPtr->next = NULL;
    }
}

void BookCollection::operator=(const BookCollection& right){
    if( this != &right){
        // delete the items of left hand side
		while (genreCount > 1) {
			GenreNode* temp = head;
            head = head -> next;

			temp -> next = NULL;
			delete temp;

            genreCount--;
		}

		delete head;
        head = NULL;
        genreCount = 0;

        // copy process
		name = right.name;
		genreCount = right.genreCount;

        if(genreCount != 0){
            // Copy the first item
			head = new GenreNode;
			head->g = right.head->g;

			// Copy the rest
			GenreNode* newPtr = head;
			for (GenreNode* origPtr = right.head->next; origPtr != NULL; origPtr = origPtr->next) {
				newPtr->next = new GenreNode;
				newPtr = newPtr->next;
				newPtr->g = origPtr->g;
			}
			newPtr->next = NULL;

        }
    }
}

void BookCollection::displayGenres() const{
    if (head == NULL)
		cout << "The collection is empty" << endl;
	
    GenreNode* tmp = head;
    while(tmp != NULL){
        cout << "Genre is " << tmp->g.getGenreName() << endl;
        tmp = tmp->next;
    }
}

BookCollection::GenreNode* BookCollection::findGenre(string genreName) {
	GenreNode* tmp = head;
    while( tmp != NULL){
        if(tmp->g.getGenreName() == genreName){
            return tmp;
        }
        tmp = tmp->next;
    }

    return NULL;
}

bool BookCollection::addGenre(const string genreName){
    if( findGenre(genreName) != NULL){
        cout << "Genre already exist in the collection" << endl;
        return false;
    } 

    GenreNode* tmp = head;
    head = new GenreNode;
    head->g.setGenreName( genreName);
    head->next = tmp;
    
    genreCount++;

    return true;
}

bool BookCollection::removeGenre(const string genreName) {
    
    GenreNode* found = findGenre(genreName);
	
    if (found == NULL) {
		cout << "Genre doesn't exist in the collection" << endl;
		return false;
	} else{
        if(found == head){
            head = head->next;
        } else{
            GenreNode* tmp = head;

            while(tmp->next != found){
                tmp = tmp->next;
            }

            tmp->next = found->next;
        }

        genreCount--;

        delete found;
        return true;
    }
}

string BookCollection::getName() const{
    return name;
}

void BookCollection::setName(const string bcName){
    name = bcName;
}