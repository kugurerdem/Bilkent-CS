
package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author
 * 
 * Batuhan Gelgi 
 * Emin Adem Buran
 * Burak Öçalan
 * Ahmet Işık
 * Ziya Özgül
 * Rüzgar Ayan
 * Cankat Anday Kadim
 * 
 * @since 11.02.19
 */
public class Hangman {

    String secretWord;

    public void chooseSecretWord() {
        String[] words = {"awkward",
           "bagpipes",
            "banjo",
            "bungler",
            "croquet",
            "crypt",
            "dwarves",
            "fervid",
            "ivory",
            "jazzy",
            "jiffy",
            "jinx",
            "jukebox",
            "kayak",
            "kiosk",
            "klutz",
            "memento",
            "mystify",
            "gossip",
            "grogginess",
            "haiku",
            "haphazard",
            "hyphen",
            "iatrogenic",
            "icebox",
            "jogging",
            "joking",
            "jovial",
            "joyful",
            "juicy",
            "jukebox",
            "jumbo",
            "kayak",
            "kazoo",
            "keyhole",
            "khaki",
            "kilobyte",
            "kiosk",
            "kitsch",
            "kiwifruit",
            "klutz",
            "knapsack",
            "larynx",
            "lengths",
            "lucky",
            "luxury",
            "lymph",
            "marquis",
            "matrix",
            "megahertz",
            "microwave",
            "mnemonic",
            "mystify",
            "pizazz",
            "pneumonia",
            "polka",
            "pshaw",
            "psyche",
            "puppy",
            "puzzling",
            "quartz",
            "queue",
            "quips",
            "quixotic",
            "quiz",
            "quizzes",
            "quorum",
            "razzmatazz",
            "rhubarb",
            "woozy",
            "wristwatch",
            "wyvern",
            "xylophone",
            "yachtsman"};

        Random rand = new Random();
        secretWord = words[rand.nextInt(words.length)];
    }

    public void chooseSecretWord(String fileName) {
        ArrayList<String> words = new ArrayList<>();
        try {
            Scanner scan = new Scanner(new File(fileName));
            while (scan.hasNext()) {
                words.add(scan.next());
            }
            Random rand = new Random();
            secretWord = words.get(rand.nextInt(words.size()));
        } catch (FileNotFoundException ex) {
            ex.getStackTrace();
        }
    }

    public static void main(String[] args) {
        Hangman hm = new Hangman();
        hm.chooseSecretWord();
        System.out.println(hm.secretWord);
        hm.chooseSecretWord("C:\\Users\\ruzgar.ayan-ug\\Desktop\\test.txt");
        System.out.println(hm.secretWord);
    }
}
