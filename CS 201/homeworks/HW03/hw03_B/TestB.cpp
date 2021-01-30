#include "BookCollection.h"
#include "Genre.h"
#include "Book.h"
#include "Author.h"

#include <iostream>
using namespace std;

int main() {
	BookCollection bc;
	bc.addGenre("Fantasy");
	bc.addGenre("Action");
	bc.addGenre("Comedy");
	bc.addGenre("Drama");
	bc.addGenre("Kids");
	bc.addBook("Fantasy", "Star Wars");
	bc.addBook("Fantasy", "Star Wars II");
	bc.addBook("Fantasy", "Star Wars VI");
	bc.addBook("Fantasy", "LOTR");
	bc.addBook("Fantasy", "Dark Night");
	bc.addBook("Action", "Usual Suspects");
	bc.addBook("Action", "Die Hard");
	bc.addBook("Action", "Matrix");
	bc.addBook("Comedy", "AROG");
	bc.addBook("Comedy", "GORA");
	bc.addBook("Comedy", "Penguin");
	bc.addBook("Drama", "Hamlet");
	bc.addBook("Kids", "Naruto");
	bc.addBook("Kids", "Dragon Ball");
	bc.addBook("Kids", "Dragon Ball Super");
	bc.addAuthor("Fantasy", "Star Wars", 0, "J. J. Abrams");
	bc.addAuthor("Fantasy", "LOTR", 1, "Tolkien");
	bc.addAuthor("Fantasy", "Dark Night", 2, "Christopher Nolan");
	bc.addAuthor("Action", "Die Hard", 0, "J. J. Abrams");
	bc.addAuthor("Action", "Usual Suspects", 3, "Bryan Singer");
	bc.addAuthor("Action", "Matrix", 5, "Lana Wachowski");
	bc.addAuthor("Action", "Matrix", 6, "Lilly Wachowski");
	bc.addAuthor("Kids", "Dragon Ball", 4, "Akira Toriyama");
	bc.addAuthor("Kids", "Dragon Ball Super", 4, "Akira Toriyama");
	bc.displayAllGenres();
    cout << "XXXXXX CHECKPOINT 1" << endl;
	cout << endl;
	bc.displayGenre("Kids");
	cout << endl;
	bc.displayGenre("Action");
	cout << endl;
	bc.displayGenre("Comedy");
	cout << endl;
	bc.displayGenre("Fantasy");
	cout << endl;
	bc.displayGenre("Drama");
    cout << "XXXXXX CHECKPOINT 2" << endl;
	cout << endl;
	bc.removeAuthor("Action", "Matrix", 5);
	bc.displayGenre("Action");
    cout << "XXXXXX CHECKPOINT 3" << endl;
	cout << endl;
	bc.displayAuthor(4);
	cout << endl;
	bc.displayAuthor(0);
	cout << endl;
	bc.displayAuthor(9);
}