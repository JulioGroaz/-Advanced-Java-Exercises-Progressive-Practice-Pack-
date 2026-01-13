import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Main {
  private static final Pattern SPLIT = Pattern.compile("[^A-Za-z]+");

  public static void main(String[] args) throws IOException {
    Path root = Paths.get("sample-data");
    Map<Path, Map<String, Integer>> index = index(root, 10_000);
    printTopWords(index, 3);
  }

  static Map<Path, Map<String, Integer>> index(Path root, long maxBytes) throws IOException {
    Map<Path, Map<String, Integer>> index = new LinkedHashMap<>();

    Files.walkFileTree(root, new SimpleFileVisitor<Path>() {
      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        // TODO (EN): filter extension and size, then read and count words. (IT): filtra estensione e dimensione, poi leggi e conta le parole.
        return FileVisitResult.CONTINUE;
      }
    });

    return index;
  }

  static Map<String, Integer> countWords(String content) {
    // TODO (EN): split content, lowercase tokens, and count. (IT): splitta il contenuto, porta in minuscolo i token e conta.
    throw new UnsupportedOperationException("TODO");
  }

  static void printTopWords(Map<Path, Map<String, Integer>> index, int topN) {
    // TODO (EN): for each file, print topN words by frequency. (IT): per ogni file, stampa le topN parole per frequenza.
    throw new UnsupportedOperationException("TODO");
  }
}
