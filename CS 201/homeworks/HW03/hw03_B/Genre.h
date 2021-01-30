#ifndef __GENRE_H
#define __GENRE_H

#include "Book.h"
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

    bool addBook(const string bookName);
    bool removeBook(const string bookName);

    bool addAuthor(const string bookName, int authorID, string authorName);
    bool removeAuthor(const string bookName, int authorID);
    string getAuthorName(const int ID);

    void displayBooks();
    void displayAuthorBooks(const int id);
private:
    struct BookNode{
        Book b;
        BookNode* next;
    };
    BookNode* head;
    string genreName;

    BookNode* findBook(const string bookName);
};

#endif