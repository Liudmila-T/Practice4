package ua.nure.timoshenko.practice4;

import org.junit.Test;
import static org.junit.Assert.*;

public class Part1Test {

    private static String part1 = "practice ok part ok    new Task";

    @Test
    public void testConvert (){
        String expected = "PRACTICE ok PART ok    new TASK";
        String actual = Part1.convert(part1);
        assertEquals(expected, actual);
    }

    @Test
    public void testMain() {
        Part1.main(new String[] {});
    }

}