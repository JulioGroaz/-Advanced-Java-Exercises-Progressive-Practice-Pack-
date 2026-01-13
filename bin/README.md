# 01 - Streams Analytics

Concept / Concetto
EN: Goal: use Stream API and collectors to aggregate transactions without explicit loops.
IT: Obiettivo: usare Stream API e collectors per aggregare transazioni senza cicli espliciti.
EN: You will practice groupingBy, summingDouble, averagingDouble, and sorting.
IT: Qui pratichi groupingBy, summingDouble, averagingDouble e sorting.
EN: When you run the program, choose IT or EN to see the objective.
IT: Quando avvii il programma, scegli IT o EN per vedere l obiettivo.

Example / Esempio
EN: Input (3 transactions):
IT: Input (3 transazioni):
EN: - c1 books 120.00 2024-01-10
IT: - c1 books 120.00 2024-01-10
EN: - c2 games 80.00 2024-01-11
IT: - c2 games 80.00 2024-01-11
EN: - c1 games 50.00 2024-02-03
IT: - c1 games 50.00 2024-02-03
EN: Expected output:
IT: Output atteso:
EN: - Totals by customer: c1=170.00, c2=80.00
IT: - Totali per cliente: c1=170.00, c2=80.00
EN: - Top customers (limit=1): [c1]
IT: - Top customers (limit=1): [c1]
EN: - Average by month: 2024-01=100.00, 2024-02=50.00
IT: - Media per mese: 2024-01=100.00, 2024-02=50.00

Tasks / Obiettivi
EN: 1) Implement totalsByCustomer: map customer -> total spent.
IT: 1) Implementa totalsByCustomer: mappa cliente -> totale speso.
EN: 2) Implement topCustomers: list sorted by total desc, then id.
IT: 2) Implementa topCustomers: lista ordinata per totale decrescente, poi id.
EN: 3) Implement averageByMonth: average amounts by month (YearMonth).
IT: 3) Implementa averageByMonth: media importi per mese (YearMonth).

Hints / Suggerimenti
EN: Use Collectors.groupingBy and summingDouble/averagingDouble.
IT: Usa Collectors.groupingBy e summingDouble/averagingDouble.
EN: For topCustomers, compute totals then sort the entry stream.
IT: Per topCustomers, calcola i totali poi ordina lo stream delle entry.
EN: YearMonth.from(date) gives naturally ordered keys.
IT: YearMonth.from(date) produce chiavi ordinate naturalmente.
