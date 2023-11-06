package week7;

import java.io.*;
import java.util.*;

public class TestReadFile {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("src/week7/data/fit.txt"));
        while (input.hasNext()) {
            String word = input.next();
            System.out.println(word);
        }
    }
}
