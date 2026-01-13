# 02 - Immutability and Pricing Rules

IT - Concetto
Immutabilita significa che un oggetto non cambia stato dopo la creazione.
Questo riduce bug e rende il codice piu facile da ragionare, soprattutto
quando piu parti del programma condividono gli stessi dati.
In questo esercizio crei un motore di pricing che applica regole senza
modificare il Basket originale.

EN - Concept
Immutability means an object does not change state after creation. This
reduces bugs and makes reasoning easier, especially when multiple parts of the
program share the same data. In this exercise you build a pricing engine that
applies rules without mutating the original Basket.

Esempio concreto / Concrete example
Basket:
- SKU A, qty 3, unit 10.00
- SKU B, qty 1, unit 40.00
Rules:
- BulkDiscountRule("A", minQty=3, percent=0.10)
- ThresholdPercentRule(minTotal=50.00, percent=0.05)

Expected result:
- Original total = 70.00
- Discount total = 7.00 + 3.50 = 10.50
- Final total = 59.50

Obiettivi / Tasks
1) Rendi Basket realmente immutabile (defensive copy + validazione).
2) Implementa le due regole di sconto.
3) Implementa PricingEngine.apply per calcolare i totali e la lista sconti.

Suggerimenti / Hints
- Usa List.copyOf per evitare modifiche esterne.
- Le regole devono restituire Optional.empty() se non applicabili.
- Somma gli sconti e calcola il totale finale senza toccare gli oggetti originali.
