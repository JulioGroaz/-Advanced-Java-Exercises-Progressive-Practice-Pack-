# 04 - Concurrency with Executors

Concept / Concetto
EN: ExecutorService lets you run many operations in parallel.
IT: ExecutorService permette di eseguire molte operazioni in parallelo.
EN: You can manage timeouts and collect results without blocking.
IT: Puoi gestire timeout e raccogliere risultati senza bloccare.
EN: This exercise simulates tasks with duration and failures.
IT: Questo esercizio simula task con durata e fallimenti.

Example / Esempio
EN: Task A: 200 ms, success
IT: Task A: 200 ms, successo
EN: Task B: 800 ms, success
IT: Task B: 800 ms, successo
EN: Timeout: 500 ms
IT: Timeout: 500 ms
EN: Result: A = SUCCESS, B = TIMEOUT
IT: Risultato: A = SUCCESS, B = TIMEOUT

Tasks / Obiettivi
EN: 1) Implement runAll: submit tasks, per-task timeout, error handling.
IT: 1) Implementa runAll: submit dei task, timeout per task, gestione errori.
EN: 2) Cancel timed-out tasks and shutdown the executor correctly.
IT: 2) Cancella i task in timeout e spegni correttamente l executor.
EN: 3) Return results preserving the original order.
IT: 3) Restituisci i risultati mantenendo l ordine originale.

Hints / Suggerimenti
EN: Use ExecutorService and Future.get(timeout).
IT: Usa ExecutorService e Future.get(timeout).
EN: On TimeoutException, call future.cancel(true).
IT: In caso di TimeoutException, chiama future.cancel(true).
EN: In finally, call shutdown and awaitTermination.
IT: In finally, chiama shutdown e awaitTermination.
