package ua.nure.timoshenko.practice4;


import java.security.SecureRandom;
import java.util.Random;

import static ua.nure.timoshenko.practice4.Util.readFile;
import static ua.nure.timoshenko.practice4.Util.writeFile;


public class Part2 {
    private static final int START_RANDOM = 0;
    private static final int END_RANDOM = 50;
    private static final String SOURCE_PATH = "part2.txt";
    private static final String OUTPUT_PATH = "part2_sorted.txt";
    private static final String CHAR_SET = "Cp1251";
    private static final int QUANTITY_NUMBERS = 10;
    private static final String EOL = System.lineSeparator();

    public static void main(String[] args) {
        writeFile(randomNumber(), SOURCE_PATH,CHAR_SET);
        String s = readFile(SOURCE_PATH, CHAR_SET);
        System.out.println("input  ==> " + s);
        int[] array = toArray(s);
        sortedNumbers(array);
        String result=arrayToString(array);
        writeFile(result, OUTPUT_PATH,CHAR_SET);
        System.out.println("output ==> " + readFile(OUTPUT_PATH, CHAR_SET));

    }

    public static String randomNumber() {
        StringBuilder result = new StringBuilder();
        Random random = new SecureRandom();
        for (int i = 0; i < QUANTITY_NUMBERS; i++) {
            int randomInt = random.nextInt(END_RANDOM - START_RANDOM);
            result.append(String.valueOf(randomInt)).append(" ");
        }
        return result.toString();

    }

    public static int[] sortedNumbers(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        return array;

    }

    private static int[] toArray(@NotNull String input) {
        int[] arrayInt;
        String[] arrWord = input.split(" ");
        arrayInt = new int[arrWord.length - 1];
        for (int i = 0; i < arrWord.length - 1; i++) {
            arrayInt[i] = Integer.parseInt(arrWord[i]);
        }
        return arrayInt;
    }

    private static String arrayToString(@NotNull int[] array) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]).append(" ");
        }
        result.append(EOL);
        return result.toString();
    }
}
