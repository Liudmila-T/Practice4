package ua.nure.timoshenko.practice4;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilTest {
    String text ="a bcd 43.43 432 89 .98";


    @Test
    public void readFile() {
        String expected= text;
        String actual= Util.readFile("part3.txt", "Сp1251");
        assertEquals(expected,actual);

    }

    @Test
    public void writeFile() {
    }
}
