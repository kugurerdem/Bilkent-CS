#include "SimpleGenre.h"

Genre::Genre(const string gName){
	genreName = gName;
}

Genre::~Genre(){}

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
