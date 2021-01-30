#include "Film.h"
#include "FC.h"

void displayAllFilms(FC &fc){
    Film *allFilms;
    unsigned int noOfFilms = fc.getFilms(allFilms);
    cout << "No of films: " << noOfFilms << endl;
    for (unsigned int i = 0; i < noOfFilms; i++) cout << allFilms[i];
    if (allFilms != NULL) delete [] allFilms;
}
void displayStatistics(FC &fc){
    Film *allFilms;
    unsigned int noOfFilms = fc.getFilms(allFilms);
    if (allFilms != NULL) {
            unsigned int count[11] = {0}, mins, age, totalAge,
            noOfFilmsWithActors = noOfFilms;
            for (unsigned int i = 0; i < noOfFilms; i++) {
                mins = allFilms[i].getFilmDuration();
                if (mins < 100) count[mins/10]++;
                else count[10]++;
            }
        for (int i = 0; i < 10; i++)
        if (count[i] > 0)
            cout << "Number of films with duration in [ "
                << i*10 << "," << (i+1)*10 << ") minutes: "
                << count[i] << endl;
        if (count[10] > 0)
            cout << "Number of films with duration >= 100 minutes: "
                << count[10] << endl;
            cout << "Average film duration: "
                << fc.calculateAverageDuration() << " min, " << endl;
        totalAge = 0;
        for (unsigned int i = 0; i < noOfFilms; i++) {
            age = allFilms[i].calculateAverageActorAge();
            if (age == 0) noOfFilmsWithActors--;
            else totalAge += age;
        }
        if (noOfFilmsWithActors > 0) {
            age = totalAge/noOfFilmsWithActors;
            cout << "Average actor age: " << age << endl;
        }
    delete [] allFilms;
    }
}

int main(){
    FC fc;
    cout << "hi" << endl;
    fc.addFilm("Midnight Cowboy", "John Schlesinger", 1969, 113);
    fc.addActor("Midnight Cowboy", "John Schlesinger",
    "Jon Voight", "Yonkers, NY, USA", 1938);
    fc.addActor("Midnight Cowboy", "John Schlesinger",
    "Dustin Hoffman", "Los Angeles, CA, USA", 1937);
    fc.addFilm("Annie Hall", "Woody Allen", 1977, 96);
    fc.addActor("Annie Hall", "Woody Allen",
    "Woody Allen", "Brooklyn, NY, USA", 1935);
    fc.addActor("Annie Hall", "Woody Allen",
    "Diane Keaton", "Los Angeles, CA, USA", 1946);
    fc.addFilm("Full Metal Jacket", "Stanley Kubrick", 1987, 116);
    fc.addActor("Full Metal Jacket", "Stanley Kubrick",
    "Matthew Modine", "Loma Linda, CA, USA", 1959);
    fc.addFilm("Good Will Hunting", "Gus Van Sant", 1997, 126);
    fc.addActor("Good Will Hunting", "Gus Van Sant",
    "Matt Damon", "Cambridge, MA, USA", 1970);
    fc.addFilm("Requiem for a Dream", "Darren Aronofsky", 2000, 101);
    fc.addActor("Requiem for a Dream", "Darren Aronofsky",
    "Ellen Burstyn", "Detroit, MI, USA", 1932);
    fc.addActor("Requiem for a Dream", "Darren Aronofsky",
    "Jared Leto", "Bossier City, LA, USA", 1971);
    fc.addFilm("The Diving Bell and the Butterfly", "Julian Schnabel",
    2007, 112);
    fc.addActor("The Diving Bell and the Butterfly",
    "Julian Schnabel", "Mathieu Amalric",
    "Neuilly-sur-Seine, France", 1965);
    fc.removeFilm("Full Metal Jacket", "Stanley Kubrick");
    displayAllFilms(fc);
    displayStatistics(fc);
    return 0;
}