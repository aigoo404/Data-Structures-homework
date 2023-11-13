package week8;

import java.util.*;
import java.io.*;

public class MyWordCountApp {
    public static final String fileName = "src/week8/data/fit.txt";
    private Map<String, Integer> map = new HashMap<String, Integer>();

    // Load data from fileName into the above map (containing <word, its
    // occurences>) using the guide given in TestReadFile.java
    public void loadData() {
        try {
            Scanner input = new Scanner(new File(fileName));
            while (input.hasNext()) {
                String word = input.next();
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Returns the number of unique tokens in the file fit.txt
    public int countUnique() {
        return map.size();
    }

    // Prints out the number of times each unique token appears in the file fit.txt
    // without consider the order of tokens.
    public void printWordCounts() throws FileNotFoundException {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    // Prints out the number of times each unique token appears in the file fit.txt
    // according to ascending order of tokens
    public void printWordCountsAlphabet() {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByKey());
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        MyWordCountApp mwca = new MyWordCountApp();
        mwca.loadData();
        System.out.println("Number of unique words: " + mwca.countUnique());
        System.out.println(" ");
        System.out.println("Total appearance of unique token: ");
        try {
            mwca.printWordCounts();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(" ");
        System.out.println("Word counts in alphabetical order: ");
        mwca.printWordCountsAlphabet();
    }
}
