import java.util.List;
import java.util.Optional;

public class Main {
  record LineItem(String sku, int qty, double unitPrice) {
    double lineTotal() {
      return qty * unitPrice;
    }
  }

  record Basket(List<LineItem> items) {
    Basket {
      // TODO: validate qty >= 1, unitPrice >= 0, and defensive copy.
      throw new UnsupportedOperationException("TODO");
    }

    double total() {
      return items.stream().mapToDouble(LineItem::lineTotal).sum();
    }
  }

  record AppliedDiscount(String ruleName, double amount) {}

  record PricingSummary(double originalTotal, double discountTotal, double finalTotal,
                        List<AppliedDiscount> discounts) {}

  interface PricingRule {
    Optional<AppliedDiscount> apply(Basket basket);
  }

  static class BulkDiscountRule implements PricingRule {
    private final String sku;
    private final int minQty;
    private final double percent;

    BulkDiscountRule(String sku, int minQty, double percent) {
      this.sku = sku;
      this.minQty = minQty;
      this.percent = percent;
    }

    @Override
    public Optional<AppliedDiscount> apply(Basket basket) {
      // TODO: if matching item qty >= minQty, return discount = qty * unitPrice * percent.
      throw new UnsupportedOperationException("TODO");
    }
  }

  static class ThresholdPercentRule implements PricingRule {
    private final double minTotal;
    private final double percent;

    ThresholdPercentRule(double minTotal, double percent) {
      this.minTotal = minTotal;
      this.percent = percent;
    }

    @Override
    public Optional<AppliedDiscount> apply(Basket basket) {
      // TODO: if basket.total() >= minTotal, discount = total * percent.
      throw new UnsupportedOperationException("TODO");
    }
  }

  static class PricingEngine {
    static PricingSummary apply(Basket basket, List<PricingRule> rules) {
      // TODO: evaluate rules, collect AppliedDiscounts, compute totals.
      throw new UnsupportedOperationException("TODO");
    }
  }

  public static void main(String[] args) {
    Basket basket = new Basket(List.of(
        new LineItem("A", 3, 10.0),
        new LineItem("B", 1, 40.0)
    ));

    List<PricingRule> rules = List.of(
        new BulkDiscountRule("A", 3, 0.10),
        new ThresholdPercentRule(50.0, 0.05)
    );

    PricingSummary summary = PricingEngine.apply(basket, rules);
    System.out.println("Original total: " + summary.originalTotal());
    System.out.println("Discount total: " + summary.discountTotal());
    System.out.println("Final total: " + summary.finalTotal());
    System.out.println("Discounts: " + summary.discounts());
  }
}
