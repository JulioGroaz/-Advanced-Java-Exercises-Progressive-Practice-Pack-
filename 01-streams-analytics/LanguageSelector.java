import java.util.Locale;
import java.util.Scanner;

public final class LanguageSelector {
  public enum Language { EN, IT }

  private LanguageSelector() {}

  public static Language selectLanguage() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.print("Choose language (IT/EN, max 2 chars) / Scegli lingua (IT/EN, max 2 caratteri): ");
      String input = scanner.nextLine();
      Language lang = parseLanguage(input);
      if (lang != null) {
        return lang;
      }
      if (input != null && input.trim().length() > 2) {
        System.out.println("Too many characters. Use max 2. / Troppi caratteri. Usa max 2.");
      } else {
        System.out.println("Invalid choice. Type IT or EN. / Scelta non valida. Digita IT o EN.");
      }
    }
  }

  static Language parseLanguage(String input) {
    if (input == null) {
      return null;
    }
    String trimmed = input.trim();
    if (trimmed.isEmpty()) {
      return null;
    }
    if (trimmed.length() > 2) {
      return null;
    }
    String upper = trimmed.toUpperCase(Locale.ROOT);
    for (int i = 0; i < upper.length(); i++) {
      char c = upper.charAt(i);
      if (c == 'I' || c == 'T') {
        return Language.IT;
      }
      if (c == 'E' || c == 'N') {
        return Language.EN;
      }
    }
    return null;
  }
}
