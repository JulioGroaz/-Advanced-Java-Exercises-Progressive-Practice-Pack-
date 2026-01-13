# 02 - Immutability and Pricing Rules

Concept / Concetto
EN: Immutability means an object does not change state after creation.
IT: Immutabilita significa che un oggetto non cambia stato dopo la creazione.
EN: This reduces bugs and makes reasoning easier when data is shared.
IT: Questo riduce bug e rende piu facile ragionare quando i dati sono condivisi.
EN: You will build a pricing engine that applies rules without mutating the Basket.
IT: Creerai un motore di pricing che applica regole senza modificare il Basket.
EN: Java 8 has no records, so use immutable classes with final fields.
IT: Java 8 non ha record, quindi usa classi immutabili con campi final.
EN: When you run the program, choose IT or EN to see the objective.
IT: Quando avvii il programma, scegli IT o EN per vedere l obiettivo.

Example / Esempio
EN: Basket:
IT: Basket:
EN: - SKU A, qty 3, unit 10.00
IT: - SKU A, qty 3, unit 10.00
EN: - SKU B, qty 1, unit 40.00
IT: - SKU B, qty 1, unit 40.00
EN: Rules:
IT: Regole:
EN: - BulkDiscountRule("A", minQty=3, percent=0.10)
IT: - BulkDiscountRule("A", minQty=3, percent=0.10)
EN: - ThresholdPercentRule(minTotal=50.00, percent=0.05)
IT: - ThresholdPercentRule(minTotal=50.00, percent=0.05)
EN: Expected result:
IT: Risultato atteso:
EN: - Original total = 70.00
IT: - Totale originale = 70.00
EN: - Discount total = 7.00 + 3.50 = 10.50
IT: - Totale sconti = 7.00 + 3.50 = 10.50
EN: - Final total = 59.50
IT: - Totale finale = 59.50

Tasks / Obiettivi
EN: 1) Make Basket truly immutable (defensive copy + validation).
IT: 1) Rendi Basket realmente immutabile (copia difensiva + validazione).
EN: 2) Implement the two discount rules.
IT: 2) Implementa le due regole di sconto.
EN: 3) Implement PricingEngine.apply to compute totals and discounts.
IT: 3) Implementa PricingEngine.apply per calcolare totali e sconti.

Hints / Suggerimenti
EN: Use a defensive copy and return an unmodifiable list (e.g., new ArrayList + Collections.unmodifiableList).
IT: Usa una copia difensiva e restituisci una lista non modificabile (es. new ArrayList + Collections.unmodifiableList).
EN: Rules should return Optional.empty() when not applicable.
IT: Le regole devono restituire Optional.empty() se non applicabili.
EN: Sum discounts and compute final total without touching original data.
IT: Somma gli sconti e calcola il totale finale senza toccare i dati originali.
