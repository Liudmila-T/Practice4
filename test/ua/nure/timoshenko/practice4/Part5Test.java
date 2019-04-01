package ua.nure.timoshenko.practice4;

import org.junit.Test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ResourceBundle;

public class Part5Test {

    @Test
    public void main() throws IOException {
        Demo.main(new String[]{});
    }

    @Test
    public void main2() {
        String[] array = new String[]{"table en"};
        for (String arr : array) {
            String[] keyLocale = arr.split(" ");
            ResourceBundle rb = ResourceBundle.getBundle("resources_" + keyLocale[1]);
            String expected = "table";
            String actual = rb.getString(keyLocale[0]);
            assertEquals(expected, actual);
        }
    }
}
