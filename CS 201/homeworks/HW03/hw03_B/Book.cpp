#include "Author.h"
#include "Book.h"

#include <string>
#include <iostream>

using namespace std;

Book::Book(){
    head = NULL;
    name = "";
}

Book::Book(const string _name){
    head = NULL;
    name = _name;
}

// TODO
Book::~Book(){
    AuthorNode* cur = head;
    while( cur != NULL){
        AuthorNode* tmp = cur;
        cur = cur->next;
        delete tmp;
    }
}

Book::Book(const Book& bookToCopy){
    name = bookToCopy.name;
    head = NULL;

    if( bookToCopy.head != NULL){
        head = new AuthorNode;
        head->a = bookToCopy.head->a;

        AuthorNode* tmp = head;
        AuthorNode* tmp_copy = bookToCopy.head->next;

        while( tmp_copy != NULL){
            tmp->next = new AuthorNode;
            tmp->next->a = tmp_copy->a;

            tmp_copy = tmp_copy -> next;
            tmp = tmp->next;
        } 

        tmp->next = NULL;
    }
}

void Book::operator=(const Book& right){
    name = right.name;
    
    // delete the items 
    AuthorNode* cur = head;

    while( cur != NULL){
        AuthorNode* tmp = cur;
        cur = cur->next;
        delete tmp;
    }

    // assign the data in the right Book
    if( right.head == NULL){
        head = NULL;
    } else{
        head = new AuthorNode;
        head->a = right.head->a;

        AuthorNode* tmp = head;
        AuthorNode* tmp_copy = right.head->next;

        while( tmp_copy != NULL){
            tmp->next = new AuthorNode;
            tmp->next->a = tmp_copy->a;

            tmp_copy = tmp_copy -> next;
            tmp = tmp->next;
        } 

        tmp->next = NULL;
    } 
}


string Book::getName() const{
    return name;
}

void Book::setName(const string bookName){
    name = bookName;
}

bool Book::addAuthor(const int id, const string name){
    if( findAuthor(id) != NULL){
        cout << "Author is already included" << endl;
        return false;
    } else{
        AuthorNode* tmp = head;
        head = new AuthorNode;
        head->a.setID( id);
        head->a.setName( name);
        head->next = tmp;

        return true;
    }
}

bool Book::removeAuthor (const int id){
    AuthorNode* found = findAuthor(id);
	
    if (found == NULL) {
		cout << "Author is not in the collection" << endl;
		return false;
	} else{
        if(found == head){
            head = head->next;
        } else{
            AuthorNode* tmp = head;

            while(tmp->next != found){
                tmp = tmp->next;
            }

            tmp->next = found->next;
        }

        delete found;
        return true;
    }
}

void Book::displayAuthors() const{
    if (head == NULL)
		cout << "   --EMPTY--" << endl;
	
    AuthorNode* tmp = head;
    while(tmp != NULL){
        cout << "   " << tmp->a.getID() << ", " << tmp->a.getName() << endl;
        tmp = tmp->next;
    }
}

Book::AuthorNode* Book::findAuthor(int id){
    AuthorNode* tmp = head;
    while( tmp != NULL){
        if(tmp->a.getID() == id){
            return tmp;
        }
        tmp = tmp->next;
    }

    return NULL;
}

bool Book::getAuthor(int id, string& name){

    AuthorNode* found = findAuthor(id);
    if( found == NULL){
        name = "";
        return false;
    } else{
        name = found->a.getName();
        return true;
    }
}