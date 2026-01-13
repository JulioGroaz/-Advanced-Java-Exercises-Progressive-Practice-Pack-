# 04 - Concurrency with Executors

IT - Concetto
Usare ExecutorService permette di eseguire molte operazioni in parallelo,
gestire timeout e raccogliere risultati senza bloccare il thread principale.
Questo esercizio simula task con durata e fallimenti controllati.

EN - Concept
Using ExecutorService lets you run many operations in parallel, manage timeouts,
and collect results without blocking the main thread. This exercise simulates
tasks with controlled duration and failures.

Esempio concreto / Concrete example
- Task A: 200 ms, success
- Task B: 800 ms, success
- Timeout: 500 ms
Risultato: A = SUCCESS, B = TIMEOUT

Obiettivi / Tasks
1) Implementa runAll: submit dei task, timeout per task, gestione errori.
2) Cancella i task in timeout e spegni correttamente l executor.
3) Restituisci i risultati mantenendo l ordine originale.

Suggerimenti / Hints
- Usa ExecutorService e Future.get(timeout).
- In caso di TimeoutException, chiama future.cancel(true).
- In finally, chiama shutdown e awaitTermination.
