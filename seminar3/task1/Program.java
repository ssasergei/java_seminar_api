/* 
 * Дан массив записей: наименование товара, цена, сорт. 
 * Найти наибольшую цену товаров 1го или 2го сорта среди товаров, 
 * название которых содержит «высший». 
 */

 package seminar3.task1;

 import java.util.ArrayList;
 import java.util.List;
 
 public class Program {
     public static void main(String[] args) {
         List<Product> products = getProducts();
         Product desired = findProduct(products, "Высший", 2);
         System.out.println(desired);
     }
 
     /**
      * Ищет товар в коллекции по имени, с лимитом по сорту, 
      * @param products
      * @param filterName
      * @param limitGrade
      * @return
      */
     private static Product findProduct(List<Product> products, String filterName, int limitGrade) {
         double highPrice = 0;
         Product desired = products.get(0);
         for (Product product : products) {
             if (product.name.contains(filterName) && product.grade <= limitGrade && highPrice < product.price) {
                 highPrice = product.price;
                 desired = product;
             }
         }
         return desired;
     }
 
     /**
      * @return list of products
      */
     private static List<Product> getProducts() {
         List<Product> products = new ArrayList<>();
         products.add(new Product("Средний товар", 40, 1));
         products.add(new Product("Низкий товар", 60, 2));
         products.add(new Product("Средний товар", 100, 3));
         products.add(new Product("Высший товар", 200, 2));
         products.add(new Product("Высший товар", 210, 3));
         products.add(new Product("товар higher", 220, 4));
         products.add(new Product("Низкий товар", 50, 1));
         products.add(new Product("Средний товар", 310, 2));
         products.add(new Product("Высший товар", 230, 1));
         products.add(new Product("Высший товар", 340, 2));
         products.add(new Product("Средний товар", 120, 1));
         products.add(new Product("Высший товар", 250, 2));
         products.add(new Product("Низкий товар", 70, 1));
         return products;
     }
 }
 