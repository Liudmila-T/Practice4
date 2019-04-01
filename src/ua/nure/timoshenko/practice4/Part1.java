package ua.nure.timoshenko.practice4;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    public static void main(String[] args) {
    String text=Util.readFile("part1.txt","Cp1251");
        System.out.println(convert(text));
    }


    public static String convert (String input){
        StringBuffer result = new StringBuffer();

        Pattern pattern = Pattern.compile("([A-zА-яІіЇїЁё]{4,})");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            matcher.appendReplacement(result, matcher.group(1).toUpperCase(Locale.getDefault()));
        }
        matcher.appendTail(result);

        return result.toString();
    }
}
