package week9.Task2;

public abstract class Publication {
    private String title;
    private int pages;
    private int year;
    private String author;
    private double price;

    public Publication(String title, int pages, int year, String author, double price) {
        this.title = title;
        this.pages = pages;
        this.year = year;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getType();

    public boolean isOldMagazine() {
        return this.getType().equals("Magazine") && this.getYear() == 2021 - 10;
    }

    public boolean hasSameTypeAndAuthor(Publication other) {
        return this.getType().equals(other.getType()) && this.getAuthor().equals(other.getAuthor());
    }

}
