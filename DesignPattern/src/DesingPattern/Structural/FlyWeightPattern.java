package DesingPattern.Structural;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * Reduce Total Number of Object.
 * Object sharing
 *
 *
 * Factory needs to manage the shared instances
 *
 *
 */

class Letter {
    char ch;

    public Letter(char ch) {
        System.out.println("Adding Letter >> " + ch);
        this.ch = ch;
    }

    public char getValue() {
        return ch;
    }
}

class FlyWeightFactory {
    Map<Character, Letter> holder = new HashMap<>();

    public Letter getLetter(char ch) {

        if (holder.get(ch) == null) {
            holder.put(ch , new Letter(ch));
        }
        return holder.get(ch);
    }
}

class StringProcessor {
    List<Letter> holder = new ArrayList<>();

    public void addLetter(Letter letter) {
        holder.add(letter);
    }

    public void print() {

        for (Letter letter : holder) {
            System.out.print(letter.getValue());
        }
    }
}

public class FlyWeightPattern {
    public static void main(String args[]) {
        FlyWeightFactory factory = new FlyWeightFactory();
        StringProcessor processor = new StringProcessor();
        String line = "This is a reallly lonnng Teesxxttt Meeesssaaaaggggeee";

        for (char ch : line.toCharArray()) {
            processor.addLetter(factory.getLetter(ch));
        }
        processor.print();
    }

}
