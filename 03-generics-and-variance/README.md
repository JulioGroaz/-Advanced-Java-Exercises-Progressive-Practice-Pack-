# 03 - Generics and Variance (PECS)

Concept / Concetto
EN: Variance explains how generic types relate to each other.
IT: La varianza spiega come i tipi generici si relazionano tra loro.
EN: In Java, List<Book> is not a List<Product>.
IT: In Java, List<Book> non e una List<Product>.
EN: Use wildcards like ? extends (producer) and ? super (consumer).
IT: Usa wildcard come ? extends (producer) e ? super (consumer).
EN: This exercise applies PECS to copy and compare elements.
IT: Questo esercizio applica PECS per copiare e confrontare elementi.

Example / Esempio
EN: Source: List<Book> with 2 elements
IT: Source: List<Book> con 2 elementi
EN: Target: List<Product> empty
IT: Target: List<Product> vuota
EN: After transfer, the target contains both books.
IT: Dopo il transfer, la target contiene entrambi i libri.

Tasks / Obiettivi
EN: 1) Implement transfer with ? extends / ? super.
IT: 1) Implementa transfer con ? extends / ? super.
EN: 2) Implement maxBy using Comparator<? super T>.
IT: 2) Implementa maxBy usando Comparator<? super T>.
EN: 3) Implement printNames to accept any Product subtype.
IT: 3) Implementa printNames per accettare qualsiasi sottotipo di Product.

Hints / Suggerimenti
EN: PECS means Producer Extends, Consumer Super.
IT: PECS significa Producer Extends, Consumer Super.
EN: Avoid raw types and casts in maxBy.
IT: Evita tipi raw e cast in maxBy.
