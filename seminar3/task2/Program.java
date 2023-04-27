/*
 * Сведения о товаре состоят из наименования, страны-производителя, веса, цены, сорта. 
 * Получить наименования товаров заданного сорта с наименьшей ценой.
 */
package seminar3.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("DВведите сорт товара от 1 до 4: ");
        int grade = scanner.nextInt();
        scanner.close();

        List<Product> products = getProducts();
        double minPrice = getMinPrice(products, grade);
        List<String> names = getNamesByFilter(products, minPrice, grade);

        System.out.println("names: " + names);
        System.out.println("price: " + minPrice + "$");
    }

    /**
     * формирует список имен товаров выбранного сорта по цене
     * 
     * @param products список товаров
     * @param minPrice минимальная цена
     * @param grade    сорт товара
     * @return
     */
    private static List<String> getNamesByFilter(List<Product> products, double minPrice, int grade) {
        List<String> names = new ArrayList<>();
        for (Product product : products) {
            if (product.price == minPrice && product.grade == grade) {
                names.add(product.name);
            }
        }
        return names;
    }

    /**
     * получает минимальную цену товаров выбранного сорта
     * 
     * @param products список всех товаров
     * @param grade    сорт товара
     * @return минимальная цена
     */
    private static double getMinPrice(List<Product> products, int grade) {
        double min = Double.MAX_VALUE;
        for (Product product : products) {
            if (min > product.price && product.grade == grade) {
                min = product.price;
            }
        }
        return min;
    }

    /**
     * Формирует список товаров
     * 
     * @return
     */
    private static List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("name01", "country32", 100, 100, 1));
        products.add(new Product("name02", "country45", 300, 300, 1));
        products.add(new Product("name03", "country33", 400, 100, 1));
        products.add(new Product("name04", "country02", 100, 400, 1));
        products.add(new Product("name05", "country03", 100, 100, 1));
        products.add(new Product("name06", "country43", 100, 500, 2));
        products.add(new Product("name07", "country05", 300, 100, 2));
        products.add(new Product("name08", "country04", 500, 600, 2));
        products.add(new Product("name09", "country77", 100, 100, 2));
        products.add(new Product("name10", "country56", 500, 700, 2));
        products.add(new Product("name11", "country23", 100, 200, 3));
        products.add(new Product("name12", "country52", 200, 200, 3));
        products.add(new Product("name13", "country22", 400, 200, 3));
        products.add(new Product("name14", "country44", 100, 300, 3));
        products.add(new Product("name15", "country33", 100, 500, 3));
        products.add(new Product("name16", "country67", 500, 100, 1));
        products.add(new Product("name17", "country12", 100, 100, 1));
        products.add(new Product("name18", "country90", 100, 300, 2));
        products.add(new Product("name19", "country66", 600, 500, 1));
        products.add(new Product("name20", "country89", 700, 500, 2));
        products.add(new Product("name21", "country23", 200, 200, 1));
        products.add(new Product("name22", "country55", 100, 800, 1));
        products.add(new Product("name23", "country54", 700, 900, 4));
        products.add(new Product("name25", "country45", 600, 100, 4));
        products.add(new Product("name26", "country09", 100, 300, 1));
        products.add(new Product("name27", "country34", 900, 200, 3));
        products.add(new Product("name28", "country12", 400, 100, 1));
        products.add(new Product("name29", "country87", 300, 300, 2));
        products.add(new Product("name30", "country32", 100, 100, 1));
        return products;
    }
}