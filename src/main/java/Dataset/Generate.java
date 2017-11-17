package Dataset;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Generate {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder1 = new StringBuilder();
        int k = 0;
        int s = 0;
        for (int i = 0; i < 100; i++) {
            stringBuilder.append(s);
            stringBuilder.append(",");
            s = s + 50;
        }
        for (int i = 0; i < 100; i++) {
            stringBuilder1.append(k);
            stringBuilder1.append(",");
            k = k + 50;
        }

        PrintWriter writer = null;
        try {
            writer = new PrintWriter("test100.txt", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        writer.println(stringBuilder);
        writer.println(" ");
        writer.println(stringBuilder1);
        writer.close();
    }


}
