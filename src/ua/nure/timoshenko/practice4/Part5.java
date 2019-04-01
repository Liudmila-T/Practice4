package ua.nure.timoshenko.practice4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class Part5 {
    private static final String ENCODING = "Cp1251";

    public static void main(String[] args) {
        String s;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in, ENCODING))) {
            while ((((s = br.readLine()) != null) && (!"stop".equals(s)))) {
                String[] keyLocale = s.split(" ");
                ResourceBundle rb = ResourceBundle.getBundle("resources_" + keyLocale[1]);
                System.out.println(rb.getString(keyLocale[0]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}