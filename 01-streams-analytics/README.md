# 01 - Streams Analytics

IT - Concetto
Obiettivo: usare Stream API e collectors per aggregare dati reali (transazioni),
senza cicli espliciti e con logica dichiarativa. Qui pratichi groupingBy,
summingDouble, averagingDouble e sorting.

EN - Concept
Goal: use the Stream API and collectors to aggregate real data (transactions)
without explicit loops and with declarative logic. You will practice groupingBy,
summingDouble, averagingDouble, and sorting.

Esempio concreto / Concrete example
Input (3 transazioni):
- c1 books 120.00 2024-01-10
- c2 games 80.00 2024-01-11
- c1 games 50.00 2024-02-03

Output atteso:
- Totals by customer: c1=170.00, c2=80.00
- Top customers (limit=1): [c1]
- Average by month: 2024-01=100.00, 2024-02=50.00

Obiettivi / Tasks
1) Implementa totalsByCustomer: mappa cliente -> totale speso.
2) Implementa topCustomers: lista ordinata per totale decrescente, poi id.
3) Implementa averageByMonth: media importi per mese (YearMonth).

Suggerimenti / Hints
- Usa Collectors.groupingBy e summingDouble/averagingDouble.
- Per topCustomers, usa una mappa dei totali e poi ordina lo stream delle entry.
- YearMonth.from(date) produce chiavi ordinate naturalmente.
