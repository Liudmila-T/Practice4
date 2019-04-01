package ua.nure.timoshenko.practice4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

    private static final String CHAR = "(?i)(^|(?<=\\s))[a-zа-я]($|(?=\\s))";
    private static final String WORD = "[A-zА-яїё]{2,}";
    private static final String INT = "(^|\\s)(\\d+)(\\s|$)";
    private static final String DOUBLE = "(^|\\s)([\\d+]*\\.\\d*)(\\s|$)";

    private static final String SOURCE_PATH = "part3.txt";
    private static final String ENCODING = "Cp1251";

    public static void main(String[] args) {
        String s;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in, ENCODING))) {
            while ((s = br.readLine()) != null) {
                System.out.println(select(s));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String select(String input) {
        StringBuilder sb=new StringBuilder();
        String text= Util.readFile(SOURCE_PATH,ENCODING);
        switch (input) {
            case "char":
                sb.append(findType(text, CHAR));
                break;
            case "String":
                sb.append(findType(text, WORD));
                break;
            case "int":
                sb.append(findType(text, INT));
                break;
            case "double":
                sb.append(findType(text, DOUBLE));
                break;
            case "stop":
                break;
            default:
                System.out.println("Available input: char, String, int, double or stop!");
        }
        return sb.toString();
    }

    public static String findType(String text, String regex) {
        StringBuilder result = new StringBuilder();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            result.append(matcher.group().trim()).append(" ");
        }
        return new String(result).trim();
    }
}

