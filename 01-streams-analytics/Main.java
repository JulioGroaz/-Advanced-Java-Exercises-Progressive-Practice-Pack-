import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
  static class Transaction {
    private final String customerId;
    private final String category;
    private final double amount;
    private final LocalDate date;

    Transaction(String customerId, String category, double amount, LocalDate date) {
      this.customerId = customerId;
      this.category = category;
      this.amount = amount;
      this.date = date;
    }

    String customerId() {
      return customerId;
    }

    String category() {
      return category;
    }

    double amount() {
      return amount;
    }

    LocalDate date() {
      return date;
    }
  }

  public static void main(String[] args) {
    LanguageSelector.Language lang = LanguageSelector.selectLanguage();
    printExerciseIntro(lang);

    List<Transaction> tx = Arrays.asList(
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

  static void printExerciseIntro(LanguageSelector.Language lang) {
    if (lang == LanguageSelector.Language.IT) {
      System.out.println("Obiettivo: usare Stream API e collectors per aggregare transazioni.");
      System.out.println("Compiti: totali per cliente, top clienti, media per mese.");
    } else {
      System.out.println("Objective: use Stream API and collectors to aggregate transactions.");
      System.out.println("Tasks: totals by customer, top customers, average by month.");
    }
    System.out.println();
  }

  static Map<String, Double> totalsByCustomer(List<Transaction> tx) {
    // TODO (EN): group by customerId and sum amounts. (IT): raggruppa per customerId e somma gli importi.
    return tx.stream().collect(Collectors.groupingBy(Transaction::customerId,
        Collectors.summingDouble(Transaction::amount)));
  }

  static List<String> topCustomers(List<Transaction> tx, int limit) {
    // TODO (EN): sort by total desc, then id asc, and return top ids. (IT): ordina per totale decrescente, poi id crescente, e restituisci i primi id.
    Map<String, Double> totals = totalsByCustomer(tx);
    return totals.entrySet().stream()
        .sorted(Comparator.<Map.Entry<String, Double>>comparingDouble(Map.Entry::getValue)
            .reversed()
            .thenComparing(Map.Entry::getKey))
        .limit(limit)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
  }

  static Map<YearMonth, Double> averageByMonth(List<Transaction> tx) {
    // TODO (EN): group by YearMonth and average amounts. (IT): raggruppa per YearMonth e calcola la media degli importi.
    return tx.stream().collect(Collectors.groupingBy(t -> YearMonth.from(t.date()),
        Collectors.averagingDouble(Transaction::amount)));
  }
}
