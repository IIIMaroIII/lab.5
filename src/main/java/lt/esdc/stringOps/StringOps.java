package lt.esdc.stringOps;

import net.datafaker.Faker;

import java.util.List;

public class StringOps {
    public static void main(String[] args) {
    new StringOps().init();
    }

     public void init() {
         determineRepeatableWords();
    }

public void determineRepeatableWords() {
        String input = "Sun shines bright sun SHINES rain falls Rain falls wind gentle WIND gentle ocean blue Ocean blue Earth";
        String[] arr = input.split("\s+");
    System.out.println(arr.toString());
}
}