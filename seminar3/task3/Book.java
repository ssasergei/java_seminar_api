package seminar3.task3;

public class Book {
    public String title;
    public String author;
    public Double price;
    public Integer year;
    public Integer numberOfPage;

    public Book(String title, String author, Double price, Integer year, Integer numberOfPage) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.year = year;
        this.numberOfPage = numberOfPage;
    }
}