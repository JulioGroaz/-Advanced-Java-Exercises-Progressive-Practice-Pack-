import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
  enum Status { SUCCESS, FAILED, TIMEOUT }

  static class TaskResult {
    private final String id;
    private final Status status;
    private final String message;
    private final long durationMs;

    TaskResult(String id, Status status, String message, long durationMs) {
      this.id = id;
      this.status = status;
      this.message = message;
      this.durationMs = durationMs;
    }

    String id() {
      return id;
    }

    Status status() {
      return status;
    }

    String message() {
      return message;
    }

    long durationMs() {
      return durationMs;
    }

    @Override
    public String toString() {
      return "TaskResult{id='" + id + "', status=" + status + ", message='" + message
          + "', durationMs=" + durationMs + "}";
    }
  }

  static Callable<TaskResult> buildTask(String id, long workMs, boolean fail) {
    return () -> {
      long start = System.nanoTime();
      try {
        Thread.sleep(workMs);
        if (fail) {
          throw new IllegalStateException("forced failure");
        }
        long durationMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
        return new TaskResult(id, Status.SUCCESS, "ok", durationMs);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        long durationMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
        return new TaskResult(id, Status.FAILED, "interrupted", durationMs);
      }
    };
  }

  static List<TaskResult> runAll(List<Callable<TaskResult>> tasks, Duration timeout, int poolSize) {
    // TODO (EN): execute tasks with timeout per task and collect TaskResult for each. (IT): esegui i task con timeout per task e raccogli un TaskResult per ciascuno.
    throw new UnsupportedOperationException("TODO");
  }

  static void printSummary(List<TaskResult> results) {
    long success = results.stream().filter(r -> r.status() == Status.SUCCESS).count();
    long failed = results.stream().filter(r -> r.status() == Status.FAILED).count();
    long timeout = results.stream().filter(r -> r.status() == Status.TIMEOUT).count();
    System.out.println("Summary -> success=" + success + ", failed=" + failed + ", timeout=" + timeout);
  }

  public static void main(String[] args) {
    LanguageSelector.Language lang = LanguageSelector.selectLanguage();
    printExerciseIntro(lang);

    List<Callable<TaskResult>> tasks = Arrays.asList(
        buildTask("A", 200, false),
        buildTask("B", 800, false),
        buildTask("C", 300, true)
    );

    List<TaskResult> results = runAll(tasks, Duration.ofMillis(500), 2);
    for (TaskResult r : results) {
      System.out.println(r);
    }
    printSummary(results);
  }

  static void printExerciseIntro(LanguageSelector.Language lang) {
    if (lang == LanguageSelector.Language.IT) {
      System.out.println("Obiettivo: eseguire task con ExecutorService e gestire timeout.");
      System.out.println("Compiti: esegui con timeout, cancella task in timeout, mantieni ordine.");
    } else {
      System.out.println("Objective: run tasks with ExecutorService and handle timeouts.");
      System.out.println("Tasks: execute with timeout, cancel timed-out tasks, keep order.");
    }
    System.out.println();
  }
}
