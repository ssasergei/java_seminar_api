/*
 * Сведения о книге состоят из названия, фамилии автора, цены, года издания и количества страниц. 
 * Найти названия книг, в которых простое количество страниц, фамилия автора содержит «А» и год издания после 2010 г, включительно.
 */
package seminar3.task3;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Book> books = getBooks();
        List<String> titles = new ArrayList<>();
        String substring = "A";
        int startYear = 2010;
        for(Book book: books) {
            if(book.author.contains(substring) && book.year >= startYear && IsPrime(book.numberOfPage)) {
                titles.add(book.title);
            }
        }
        System.out.println(titles);
    }

    /**
     * проверяет является ли число простым
     * @param number - проверяемое число
     * @return результат проверки
     */
    private static boolean IsPrime(int number) {
        for(int i = 2; i <= ((int)(Math.sqrt(number))); i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * формирует список книг
     * @return список книг
     */
    private static List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("title1", "Author1", 100.0, 2010, 203));
        books.add(new Book("title2", "authorA", 200.0, 2013, 211));
        books.add(new Book("title3", "author2", 300.0, 2019, 300));
        books.add(new Book("title4", "authAr3", 200.0, 2004, 137));
        books.add(new Book("title5", "author4", 300.0, 2020, 150));
        books.add(new Book("title6", "author5", 400.0, 2009, 193));
        books.add(new Book("title7", "autAor6", 300.0, 2011, 281));
        books.add(new Book("title8", "author7", 400.0, 2013, 282));
        books.add(new Book("title9", "auAhor8", 500.0, 2017, 283));
        books.add(new Book("title0", "aAthor0", 100.0, 2008, 177));
        
        return books;
    }
}
