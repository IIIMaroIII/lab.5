package lt.esdc.stringOps;

import java.util.Arrays;

public class StringOps {
    public static void main(String[] args) {
        new StringOps().init();
    }

    public void init() {
        determineRepeatableWords();
    }

    public void determineRepeatableWords() {
        String input = "Sun shines bright sun sun SHINES rain falls Rain falls wind gentle WIND gentle ocean blue Ocean blue Earth".toLowerCase();

        String[] arr = input.split("\s+");

        Arrays.sort(arr);
        System.out.println("arr.length: " + arr.length);
        System.out.println("arr: " + Arrays.toString(arr));
        int counter = 1;
        for (int i = 0; i < arr.length; i++) {

            if (i < arr.length - 1 && arr[i].equalsIgnoreCase(arr[i + 1])) {
//                System.out.format("Occured %s vs %s\n", arr[i], arr[i + 1]);
//                System.out.println(arr[i]);
                counter++;
                if (counter % 2 != 0) {
                    System.out.println(arr[i]);
                }
            }

        }

    }
}