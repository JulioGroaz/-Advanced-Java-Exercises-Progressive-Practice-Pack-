import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
  static abstract class Product {
    private final String name;
    private final double price;

    Product(String name, double price) {
      this.name = name;
      this.price = price;
    }

    String name() {
      return name;
    }

    double price() {
      return price;
    }

    @Override
    public String toString() {
      return name + " (" + price + ")";
    }
  }

  static class Book extends Product {
    Book(String name, double price) {
      super(name, price);
    }
  }

  static class Toy extends Product {
    Toy(String name, double price) {
      super(name, price);
    }
  }

  static <T> void transfer(List<? extends T> src, List<? super T> dst) {
    // TODO (EN): add all elements from src to dst. (IT): aggiungi tutti gli elementi da src a dst.
    throw new UnsupportedOperationException("TODO");
  }

  static <T> T maxBy(List<? extends T> items, Comparator<? super T> cmp) {
    // TODO (EN): return max element using comparator. (IT): restituisci l elemento massimo usando il comparator.
    throw new UnsupportedOperationException("TODO");
  }

  static void printNames(List<? extends Product> items) {
    // TODO (EN): print item names using only Product API. (IT): stampa i nomi usando solo la API di Product.
    throw new UnsupportedOperationException("TODO");
  }

  public static void main(String[] args) {
    List<Book> books = List.of(
        new Book("Clean Code", 35.0),
        new Book("Effective Java", 45.0)
    );

    List<Product> products = new ArrayList<>();
    transfer(books, products);

    Product max = maxBy(products, Comparator.comparingDouble(Product::price));
    System.out.println("Max price: " + max);

    printNames(products);
  }
}
