#include "BookCollection.h"
#include "Genre.h"
#include <cstddef>
#include <iostream>

BookCollection::BookCollection(){
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

void BookCollection::displayAllGenres() const{
    if (head == NULL)
		cout << "The collection is empty" << endl;
	
    GenreNode* tmp = head;
    while(tmp != NULL){
        cout << tmp->g.getGenreName() << endl;
        tmp->g.displayBooks();
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

void BookCollection::addGenre(const string genreName){
    if( findGenre(genreName) != NULL){
        cout << "Genre already exist in the collection" << endl;
    } 

    GenreNode* tmp = head;
    head = new GenreNode;
    head->g.setGenreName( genreName);
    head->next = tmp;
    
    genreCount++;
}

void BookCollection::removeGenre(const string genreName) {
    
    GenreNode* found = findGenre(genreName);
	
    if (found == NULL) {
		cout << "Genre doesn't exist in the collection" << endl;
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
    }
}

void BookCollection::addBook(string genreName, string bookName){
    GenreNode* found = findGenre(genreName);
    if( found != NULL)
        found->g.addBook( bookName);
}

void BookCollection::removeBook(string genreName, string bookName){
    GenreNode* found = findGenre(genreName);
    if( found != NULL)
        found->g.removeBook( bookName);
}

void BookCollection::addAuthor(string genreName, string bookName, int authorID, string
    authorName){
        GenreNode* found = findGenre( genreName);
        if( found != NULL)
            found->g.addAuthor(bookName, authorID, authorName);
}

void BookCollection::removeAuthor(string genreName, string bookName, int authorID){
        GenreNode* found = findGenre( genreName);
        if( found != NULL)
            found->g.removeAuthor(bookName, authorID);
}

void BookCollection::displayGenre(string genreName){
    GenreNode* found = findGenre( genreName);
    if( found != NULL)
        cout << genreName << endl;
        found->g.displayBooks();
}

void BookCollection::displayAuthor(int authorID){
    // find the author name basing on authorID
    string authorName = getAuthorName(authorID);
    if (authorName == "")
        cout << authorID << endl << "   --EMPTY--" << endl;
    else
        cout << authorID << " " << authorName << endl;

    // write all of the associated books for the author
    if (head == NULL){
        cout << "--EMPTY--" << endl;
    } else{

        GenreNode* tmp = head;
        while(tmp != NULL){
            if( tmp->g.getAuthorName(authorID) != ""){
                cout << tmp->g.getGenreName() << endl;
                tmp->g.displayAuthorBooks( authorID);
            }
            tmp = tmp->next;
        }
    } 
}

string BookCollection::getAuthorName(int authorID){
    GenreNode* cur = head;
    while( cur != NULL){
        string aName = cur->g.getAuthorName( authorID);
        if( aName != "")
            return aName;

        cur = cur->next;
    }

    return "";
}