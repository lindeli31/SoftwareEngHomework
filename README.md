# Adapter per CLDC 1.1 con Vector e Java 2 Collections Framework 1.4.2

## Descrizione del Progetto
Questo progetto si propone di sviluppare un **adapter** per l'interfaccia `List` utilizzando la classe `Vector` di **CLDC 1.1**, in un ambiente conforme al **Java 2 Collections Framework (J2SE 1.4.2)**.

L'obiettivo principale è garantire che il codice sia pienamente compatibile con CLDC 1.1, rispettando le limitazioni di questa versione e implementando correttamente tutti i metodi richiesti dalle interfacce `List`, `Iterator` e `ListIterator`.

## Struttura del Progetto
Il progetto è organizzato come segue:

- **Package `myAdapter`**:
  - Contiene le implementazioni delle interfacce:
    - `HList`
    - `HCollection`
    - `HIterator`
    - `HListIterator`
  - Include la classe principale `ListAdapter` che funge da adapter per l'interfaccia `List`.

- **Package `myTest`**:
  - Contiene le classi di test basate su **JUnit** per verificare il corretto funzionamento dell'`adapter`.

- **Test Runner**:
  - Una classe dedicata per eseguire tutti i test e fornire un report dettagliato con:
    - Numero totale di test eseguiti
    - Numero di test falliti
    - Tempo di esecuzione complessivo

## Requisiti
- **Java Versione Corrente**:
  - L'implementazione deve utilizzare solo funzionalità di **CLDC 1.1**.
  
- **Test-Driven Development (TDD)**:
  - Tutte le funzionalità devono essere sviluppate utilizzando test automatici basati su JUnit.

- **Compliant con J2SE 1.4.2**:
  - I metodi e i comportamenti dell'adapter devono essere conformi alla documentazione ufficiale di **Java 2 Collections Framework 1.4.2**.

## Installazione
1. Clona il repository:
   ```bash
   git clone https://github.com/tuo-username/adapter-cldc1.1.git
