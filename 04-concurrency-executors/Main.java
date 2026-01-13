import java.time.Duration;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
  enum Status { SUCCESS, FAILED, TIMEOUT }

  record TaskResult(String id, Status status, String message, long durationMs) {}

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
    List<Callable<TaskResult>> tasks = List.of(
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
}
