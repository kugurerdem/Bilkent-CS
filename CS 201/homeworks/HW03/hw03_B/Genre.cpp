#include "Genre.h"

#include <iostream>

using namespace std;

Genre::Genre(const string gName){
	genreName = gName;
	head = NULL;
}

Genre::~Genre(){
    BookNode* cur = head;
    while( cur != NULL){
        BookNode* tmp = cur;
        cur = cur->next;
        delete tmp;
    }
}

Genre::Genre(const Genre& genre)
{
	genreName = genre.genreName;
}

void Genre::operator=(const Genre& right)
{
	genreName = right.genreName;
}

string Genre::getGenreName() const {
	return genreName;
}

void Genre::setGenreName(const string gName) {
	genreName = gName;
}

bool Genre::addBook(const string bookName){
	if( findBook(bookName) != NULL){
        cout << "Book is already in the list" << endl;
        return false;
    } else{
        BookNode* tmp = head;
        head = new BookNode;
        head->b.setName( bookName);
        head->next = tmp;

        return true;
    }
}

bool Genre::removeBook(const string bookName){
	BookNode* found = findBook( bookName);
	
    if (found == NULL) {
		cout << "Book is not in the genre" << endl;
		return false;
	} else{
        if(found == head){
            head = head->next;
        } else{
            BookNode* tmp = head;

            while(tmp->next != found){
                tmp = tmp->next;
            }

            tmp->next = found->next;
        }

        delete found;
        return true;
    }
}

bool Genre::addAuthor(const string bookName, int authorID, string authorName){
	BookNode* bookN = findBook( bookName);
	if( bookN != NULL)
		return bookN->b.addAuthor(authorID, authorName);
	
	return false;
}

bool Genre::removeAuthor(const string bookName, int authorID){
	BookNode* bookN = findBook( bookName);
	if( bookN != NULL)
		return bookN->b.removeAuthor( authorID);
	
	return false;
}

void Genre::displayBooks(){
	if (head == NULL)
		cout << "   --EMPTY--" << endl;
	
    BookNode* tmp = head;
    while(tmp != NULL){
        cout << tmp->b.getName() << endl;
		tmp->b.displayAuthors();
        tmp = tmp->next;
    }
}


Genre::BookNode* Genre::findBook(const string bookName){
	BookNode* tmp = head;
    while( tmp != NULL){
        if(tmp->b.getName() == bookName){
            return tmp;
        }
        tmp = tmp->next;
    }

    return NULL;
}

void Genre::displayAuthorBooks(const int ID){
    if (head == NULL)
        cout << "   --EMPTY--" << endl;
	
    BookNode* tmp = head;
    while(tmp != NULL){
        // check if the author is in the book, if so, print the book
        string authorName;
        if( tmp->b.getAuthor( ID, authorName))
             cout << "  " << tmp->b.getName() << "  " << authorName << endl;

        tmp = tmp->next;
    }
}

string Genre::getAuthorName(const int ID){
    string authorName;
    BookNode* cur = head;

    while( cur != NULL){
        if( cur->b.getAuthor(ID, authorName) )
            return authorName;
        cur = cur->next;
    }

    return "";
}