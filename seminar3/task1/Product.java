package seminar3.task1;

public class Product {
    public String name;
    public double price;
    public int grade;

    public Product(String name, double price, int grade) {
        this.name = name;
        this.price = price;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format("%s (grade: %d): %.2f$", name, grade, price);
    }
}
