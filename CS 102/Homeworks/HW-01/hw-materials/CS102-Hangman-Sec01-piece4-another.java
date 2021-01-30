class Hangman{
  public String chooseSecretWord(){
    String[] words = {"Computer","Turkey","Mouse","Africa","Monitor","Fruit", "Stuff", "Table"};
    int randomIndex = (int)(Math.random()*words.length);
    return words[randomIndex];
  }
}