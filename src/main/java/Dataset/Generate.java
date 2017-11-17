package Dataset;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Generate {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder1 = new StringBuilder();
        int k=0;

        for (int i = 0; i < 10000; i++) {
            stringBuilder.append(i);
            stringBuilder.append(",");
        }
        for (int i = 9000; k < 10000; i++) {
            stringBuilder1.append(i+50);
            stringBuilder1.append(",");
            k++;
        }

        PrintWriter writer = null;
        try {
            writer = new PrintWriter("test10000.txt", "UTF-8");
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
