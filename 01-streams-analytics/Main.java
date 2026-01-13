import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;

public class Main {
  record Transaction(String customerId, String category, double amount, LocalDate date) {}

  public static void main(String[] args) {
    List<Transaction> tx = List.of(
        new Transaction("c1", "books", 120.0, LocalDate.of(2024, 1, 10)),
        new Transaction("c2", "games", 80.0, LocalDate.of(2024, 1, 11)),
        new Transaction("c1", "games", 50.0, LocalDate.of(2024, 2, 3)),
        new Transaction("c3", "books", 200.0, LocalDate.of(2024, 2, 10)),
        new Transaction("c2", "books", 30.0, LocalDate.of(2024, 2, 12))
    );

    Map<String, Double> totals = totalsByCustomer(tx);
    List<String> top = topCustomers(tx, 2);
    Map<YearMonth, Double> avg = averageByMonth(tx);

    System.out.println("Totals by customer: " + totals);
    System.out.println("Top customers: " + top);
    System.out.println("Average by month: " + avg);
  }

  static Map<String, Double> totalsByCustomer(List<Transaction> tx) {
    // TODO (EN): group by customerId and sum amounts. (IT): raggruppa per customerId e somma gli importi.
    throw new UnsupportedOperationException("TODO");
  }

  static List<String> topCustomers(List<Transaction> tx, int limit) {
    // TODO (EN): sort by total desc, then id asc, and return top ids. (IT): ordina per totale decrescente, poi id crescente, e restituisci i primi id.
    throw new UnsupportedOperationException("TODO");
  }

  static Map<YearMonth, Double> averageByMonth(List<Transaction> tx) {
    // TODO (EN): group by YearMonth and average amounts. (IT): raggruppa per YearMonth e calcola la media degli importi.
    throw new UnsupportedOperationException("TODO");
  }
}
