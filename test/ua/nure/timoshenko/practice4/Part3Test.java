package ua.nure.timoshenko.practice4;

import org.junit.Test;
import static org.junit.Assert.*;

public class Part3Test {

    @Test
    public void main() {
        String input= "double";
        String expected="43.43 15. .98";
        String actual= Part3.select(input);
        assertEquals(expected,actual);
    }

    @Test
    public void select(){
        String input= "int";
        String expected="432 89";
        String actual= Part3.select(input);
        assertEquals(expected,actual);
    }
    @Test
    public void findType (){
        String input= "яd ffa bcd ы 43.43 432 15. и л фвыа 89 .98";
        String expected="яd ffa bcd фвыа";
        String actual= Part3.findType(input, "[A-zА-яїё]{2,}");
        assertEquals(expected,actual);
    }

}
