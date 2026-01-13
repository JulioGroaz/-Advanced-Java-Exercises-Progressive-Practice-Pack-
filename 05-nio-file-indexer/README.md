# 05 - NIO File Indexer

Concept / Concetto
EN: NIO provides modern APIs to traverse directories and read files efficiently.
IT: NIO offre API moderne per visitare directory e leggere file in modo efficiente.
EN: You will build an indexer that counts words in .java files under a folder.
IT: Creerai un indicizzatore che conta le parole nei file .java in una cartella.
EN: A max file size limit is enforced.
IT: E presente un limite massimo di dimensione file.
EN: When you run the program, choose IT or EN to see the objective.
IT: Quando avvii il programma, scegli IT o EN per vedere l obiettivo.

Example / Esempio
EN: If the folder contains:
IT: Se la cartella contiene:
EN: - A.java: "class A { int a; }"
IT: - A.java: "class A { int a; }"
EN: - B.java: "class B { int b; int b; }"
IT: - B.java: "class B { int b; int b; }"
EN: Output:
IT: Output:
EN: - A.java: class=1, int=1, a=1
IT: - A.java: class=1, int=1, a=1
EN: - B.java: class=1, int=2, b=2
IT: - B.java: class=1, int=2, b=2

Tasks / Obiettivi
EN: 1) Implement index using Files.walkFileTree and SimpleFileVisitor.
IT: 1) Implementa index usando Files.walkFileTree e SimpleFileVisitor.
EN: 2) Implement countWords to tokenize and count (lowercase).
IT: 2) Implementa countWords per tokenizzare e contare (lowercase).
EN: 3) Implement printTopWords to show the most frequent words per file.
IT: 3) Implementa printTopWords per stampare le parole piu frequenti per file.

Hints / Suggerimenti
EN: Filter only files with .java extension.
IT: Filtra solo file con estensione .java.
EN: Skip files larger than maxBytes.
IT: Salta i file piu grandi di maxBytes.
EN: Use Pattern or String.split with a non-letter regex.
IT: Usa Pattern o String.split con regex non alfabetica.
