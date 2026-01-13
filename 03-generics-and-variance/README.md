# 03 - Generics and Variance (PECS)

IT - Concetto
La varianza spiega come i tipi generici si relazionano tra loro. In Java,
List<Book> non e una List<Product>. Per lavorare in modo flessibile servono
wildcard come ? extends (producer) e ? super (consumer). Questo esercizio
usa la regola PECS per copiare e confrontare elementi.

EN - Concept
Variance explains how generic types relate to each other. In Java,
List<Book> is not a List<Product>. To write flexible APIs you use wildcards
like ? extends (producer) and ? super (consumer). This exercise applies PECS
to copy and compare elements.

Esempio concreto / Concrete example
- Source: List<Book> with 2 elements
- Target: List<Product> empty
After transfer, the target contains both books.

Obiettivi / Tasks
1) Implementa transfer con ? extends / ? super.
2) Implementa maxBy usando Comparator<? super T>.
3) Implementa printNames per accettare qualsiasi sottotipo di Product.

Suggerimenti / Hints
- PECS: Producer Extends, Consumer Super.
- Per maxBy evita cast e tipi raw.
