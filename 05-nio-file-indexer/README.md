# 05 - NIO File Indexer

IT - Concetto
NIO offre API moderne per visitare directory e leggere file in modo efficiente.
In questo esercizio crei un piccolo indicizzatore che conta le parole nei file
.java sotto una cartella, con un limite di dimensione.

EN - Concept
NIO provides modern APIs to traverse directories and read files efficiently.
In this exercise you build a small indexer that counts words in .java files
under a folder, with a size limit.

Esempio concreto / Concrete example
Se la cartella contiene:
- A.java: "class A { int a; }"
- B.java: "class B { int b; int b; }"
Output:
- A.java: class=1, int=1, a=1
- B.java: class=1, int=2, b=2

Obiettivi / Tasks
1) Implementa index usando Files.walkFileTree e SimpleFileVisitor.
2) Implementa countWords per tokenizzare e contare (lowercase).
3) Implementa printTopWords per stampare le parole piu frequenti per file.

Suggerimenti / Hints
- Filtra solo file con estensione .java.
- Salta file piu grandi di maxBytes.
- Usa Pattern o String.split con regex non alfabetica.
