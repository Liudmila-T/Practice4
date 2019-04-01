package ua.nure.timoshenko.practice4;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

import static org.junit.Assert.*;


public class Part2Test {
    int[] array = {30, 23, 16, 16, 9, 23, 3, 18, 21, 29};

    @Test
    public void main() throws IOException {
        Part2.main(new String[] {});
    }

    @Test
    public void randomNumber() {
        Part2.randomNumber();
    }

    @Test
    public void sortedNumbers() {
       String expected = "[3, 9, 16, 16, 18, 21, 23, 23, 29, 30]";
        String actuality = Arrays.toString(Part2.sortedNumbers(array));
        assertEquals(expected, actuality);
    }
}
