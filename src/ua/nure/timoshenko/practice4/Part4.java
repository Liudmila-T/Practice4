package ua.nure.timoshenko.practice4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 implements Iterable<Object> {

    private Matcher matcher;

    private static final String REGEX = "[A-ZА-Я]{1}[а-яА-Яa-zA-Z,;\\s\\n\\r]+([.!?]{1}|[.]{3})+";

    private static final String PATH = "part4.txt";

    private static final String ENCODING = "cp1251";

    public Part4(Matcher matcher) {
        this.matcher = matcher;
    }

    public static void main(String[] args) {
        String text = Util.readFile(PATH, ENCODING);
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(text);
        Part4 part4 = new Part4(matcher);
        Iterator<Object> iterator = part4.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Override
    public Iterator<Object> iterator() {
        return new MatcherIterator();
    }

    private class MatcherIterator implements Iterator<Object> {
      private   boolean check;

        @Override
        public boolean hasNext() {
            check=true;
            return matcher.find();

        }

        @Override
        public Object next() {
            if (!check) {
                throw new NoSuchElementException();
            }

            String[] substring = matcher.group().split(System.lineSeparator());
            StringBuilder result = new StringBuilder();
            for (String str : substring) {
                result.append(str.trim()).append(" ");
            }
            check=false;
            return new String(result).trim();
        }
    }
}
