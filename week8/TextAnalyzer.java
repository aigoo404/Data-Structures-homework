package week8;

import java.io.*;
import java.util.*;

public class TextAnalyzer {
    private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

    // Load words in the text file given by fileName and store into map by using add
    // method in Task 2.1. and BufferedReader reffered in file TextFileUtils.java
    public void load(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            int position = 0;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    add(word, position++);
                }
                position = -position;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // If the word is not in the map, then adding that word to the map containing
    // the position of the word in the file. If the word is already in the map, then
    // its word position is added to the list of word positions for this word.
    private void add(String word, int position) {
        if (!map.containsKey(word)) {
            map.put(word, new ArrayList<Integer>());
        }
        map.get(word).add(position);
    }

    // Display the words of the text file along with the positions of each word, one
    // word per line, in alphabetical order
    public void displayWords() {
        List<String> words = new ArrayList<>(map.keySet());
        Collections.sort(words);
        for (String word : words) {
            System.out.println(word + " :" + map.get(word));
        }
    }

    // Display the content of the text file stored in the map
    public void displayText() {
        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Return the word that occurs most frequently in the text file
    public String mostFrequentWord() {
        String mostFreq = null;
        int maxFreq = 0;
        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            int freq = entry.getValue().size();
            if (freq > maxFreq) {
                maxFreq = freq;
                mostFreq = entry.getKey();
            }
        }
        return mostFreq;
    }

    public static void main(String[] args) {
        TextAnalyzer analyzer = new TextAnalyzer();
        String fileName = "src/week8/data/fit.txt";
        analyzer.load(fileName);
        System.out.println("Words with their positions: ");
        analyzer.displayWords();
        System.out.println(" ");
        System.out.println("Content of the text stored in the map: ");
        analyzer.displayText();
        String mostFrequent = analyzer.mostFrequentWord();
        System.out.println("The word with the most appearance: " + mostFrequent);
    }
}
