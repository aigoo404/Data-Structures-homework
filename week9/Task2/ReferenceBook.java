package week9.Task2;

import java.util.*;

public class ReferenceBook extends Publication {
    private String field;
    private List<Chapter> chapters;

    public ReferenceBook(String title, int pages, int year, String author, double price, String field,
            List<Chapter> chapters) {
        super(title, pages, year, author, price);
        this.field = field;
        this.chapters = chapters;
    }

    public String getField() {
        return field;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    @Override
    public String getType() {
        return "Reference Book";
    }

    public void addChapter(String title, int pages) {
        Chapter chapter = new Chapter(title, pages);
        this.chapters.add(chapter);
    }
}