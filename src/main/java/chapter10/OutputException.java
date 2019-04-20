package chapter10;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 追加错误堆栈到exception.log
 */
public class OutputException {

    public static void dump(InputStream src, OutputStream dest) throws IOException {
        try {
            InputStream input = src;
            OutputStream output = dest;

            byte[] data = new byte[1024];
            int length = -1;
            while((length = input.read(data)) != -1) {
                output.write(data, 0, length);
            }

            throw new IOException("test");

        } catch (IOException ex) {

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            String msg = sw.toString();

            OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream("exception.log"), StandardCharsets.UTF_8);
            output.write(msg, 0, msg.length());
            output.flush();
            output.close();
        }
    }

    public static void main(String[] args) throws IOException {
        OutputException.dump(new FileInputStream("./src/com/java/hoohack/notes/chapter10/data.txt"), System.out);
    }

}
