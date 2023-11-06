package week7;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class MyWordCount {
    public static final String fileName = "src/week7/data/fit.txt";
    private List<String> words = new ArrayList<>();

    public MyWordCount() {
        try {
            this.words.addAll(Utils.loadWords(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Prints out the number of times each unique token appears in the file
    // fit.txt. In this method, we do not consider the order of tokens.
    public List<WordCount> getWordCounts() {
        Map<String, Integer> WCMap = new HashMap<>();
        for (String word : words) {
            WCMap.put(word, WCMap.getOrDefault(word, 0) + 1);
        }
        List<WordCount> wordCounts = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : WCMap.entrySet()) {
            wordCounts.add(new WordCount(entry.getKey(), entry.getValue()));
        }
        return wordCounts;
    }

    // Returns the words that their appearance are 1, not consider duplidated words
    public Set<String> getUniqueWords() {
        Map<String, Integer> WCMap = new HashMap<>();
        for (String word : words) {
            WCMap.put(word, WCMap.getOrDefault(word, 0) + 1);
        }
        Set<String> uniqueWords = new HashSet<>();
        for (Map.Entry<String, Integer> entry : WCMap.entrySet()) {
            if (entry.getValue() == 1) {
                uniqueWords.add(entry.getKey());
            }
        }
        return uniqueWords;
    }

    // Returns duplicated words that appear once in the result file
    public Set<String> getDistincWords() {
        return new HashSet<>(words);
    }

    // Prints out the number of times each unique token appears in the file fit.txt
    // according ascending order of tokens
    public Set<WordCount> printwWordCounts() {
        List<WordCount> wordCounts = getWordCounts();
        wordCounts.sort(Comparator.comparing(WordCount::getWord));
        return new LinkedHashSet<>(wordCounts);
    }

    // Prints out the number of times each unique token appears in the file fit.txt
    // according descending order of occurences
    public Set<WordCount> exportWordCountsByOccurence() {
        List<WordCount> wordCounts = getWordCounts();
        wordCounts.sort(Comparator.comparing(WordCount::getCount).reversed());
        return new LinkedHashSet<>(wordCounts);
    }

    // delete words begining with the given pattern (i.e., delete words begin with
    // 'A' letter)
    public Set<String> filterWords(String pattern) {
        return words.stream().filter(w -> !w.startsWith(pattern)).collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        MyWordCount mwc = new MyWordCount();
        List<WordCount> wordCounts = mwc.getWordCounts();
        System.out.println("Word count: " + wordCounts);
        Set<String> distrincWords = mwc.getDistincWords();
        System.out.println("Distinct words: " + distrincWords);
        Set<WordCount> printeWordCounts = mwc.printwWordCounts();
        System.out.println("Printed word counts: " + printeWordCounts);
        Set<WordCount> exportedWordCounts = mwc.exportWordCountsByOccurence();
        System.out.println("Exported word counts: " + exportedWordCounts);
        Set<String> filteredWords = mwc.filterWords("N");
        System.out.println("Filtered words with 'N': " + filteredWords);
    }
}
