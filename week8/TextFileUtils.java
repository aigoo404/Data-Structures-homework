package week8;

import java.io.*;
import java.util.*;

public class TextFileUtils {
    public static void readText(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = null;
        while (true) {
            line = reader.readLine();
            if (line == null)
                break;
            StringTokenizer tokens = new StringTokenizer(line, " ");
            while (tokens.hasMoreTokens()) {
                System.out.println(tokens.nextToken());
            }
        }
        reader.close();
    }

    public static void main(String[] args) {
        try {
            readText("src/week8/data/fit.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
