package chapter10;

import java.io.*;

/**
 * 读入任何文本，转存为UTF8格式
 */
public class ConvertUTF8 {


    public static void main(String[] args) throws IOException {
        String inputFileName = "xxx.txt";
        String outputFileName = "./out.txt";

        InputStreamReader reader = new InputStreamReader(new FileInputStream(inputFileName), "Unicode");
        StringBuilder buffer = new StringBuilder();


        while (reader.ready()) {
            buffer.append((char)reader.read());
        }

        reader.close();
        String str = buffer.toString();
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(outputFileName), "UTF-8");
        writer.write(str.toCharArray());
        writer.flush();
        writer.close();
    }


}
