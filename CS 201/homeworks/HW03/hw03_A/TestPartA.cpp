#include "SimpleBookCollection.h"
#include "SimpleGenre.h"

int main() {
	BookCollection bc;
	bc.addGenre("Fantasy");
	bc.addGenre("Action");
	bc.addGenre("Adult");
	bc.addGenre("Anime");
	bc.addGenre("Drama");
	bc.addGenre("Comedy");
	bc.addGenre("Kids");
	bc.displayGenres();
	bc.removeGenre("Sexual");
	bc.removeGenre("Comedy");
	//bc.addGenre("KIDS");
	bc.displayGenres();
}