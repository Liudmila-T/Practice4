package ua.nure.timoshenko.practice4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;


public final class Util {
    private static final String EOL = System.lineSeparator();

    private Util() {
        super();
    }

    public static String readFile(String path, String charSet) {
        StringBuilder result = new StringBuilder();
        String s;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), charSet))) {
            while ((s = br.readLine()) != null) {
                result.append(s).append(EOL);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void writeFile(String text, String name, String charSet) {
        try (BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name, false),charSet))) {
            bw.write(text);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
