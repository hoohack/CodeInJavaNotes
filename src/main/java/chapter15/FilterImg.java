package chapter15;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.System.out;

/**
 * 过滤得到img
 */
public class FilterImg {

    public static void main(String[] args) throws IOException {

        String fileName = ".../coffee.html";
        InputStreamReader reader = new InputStreamReader(new FileInputStream(fileName), "UTF-8");
        StringBuilder buffer = new StringBuilder();

        while (reader.ready()) {
            buffer.append((char)reader.read());
        }
        reader.close();

        String htmlStr = buffer.toString();
        String regex = "<a[^>].*?>(<img[^>].*?>)<\\/a>";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(htmlStr);
        while (matcher.find()) {
            out.printf(" \"%s\"\n", matcher.group(1));
        }
    }
}
