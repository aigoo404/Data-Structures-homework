package week9.Task2;

public class Magazine extends Publication {
    private String magazineName;

    public Magazine(String title, int pages, int year, String author, double price, String magazineName) {
        super(title, pages, year, author, price);
        this.magazineName = magazineName;
    }

    public String getMagazineName() {
        return magazineName;
    }

    @Override
    public String getType() {
        return "Magazine";
    }
}
