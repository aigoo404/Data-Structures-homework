package week7;

import java.io.*;
import java.util.*;

public class Utils {
    public static List<String> loadWords(String fileName) throws FileNotFoundException {
        List<String> re = new ArrayList<String>();
        Scanner input = new Scanner(new File(fileName));
        while (input.hasNext()) {
            String word = input.next();
            re.add(word);
        }
        return re;
    }
}
