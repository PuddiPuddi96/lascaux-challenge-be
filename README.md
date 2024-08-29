# Lascaux Challenge: Backend Web Developer

### Obiettivo
Creare un’applicazione web per la gestione dei film di un multisala. L’applicazione dovrà permettere la visualizzazione della lista dei film messi in programmazione in un cinema multisala, al fine di organizzare uno storico consultabile dai gestori.

## Descrizione scenario
### Il committente
Il cinema multisala “CineMille” sito in via Roma a Firenze (FI).

### Lo scenario
Il cinema “CineMille” è un esercizio storico dell’area fiorentina, nonché uno dei più grandi presenti in Toscana. Dispone di 12 sale di proiezione, di cui 2 in tecnologia IMAX. Le sale hanno una capienza differente, con le più grandi che dispongono di 250 posti ciascuna fino alle più piccole da circa 50 posti a sedere.

Attualmente la programmazione delle proiezioni nelle sale viene aggiornata con cadenza settimanale: tali informazioni sono gestite mediante scambio di dati contenuti in file Excel. Ciascun film può rimanere in sala per un massimo di tre settimane e per un minimo di una, a partire dalla data di uscita dello stesso.

La società che gestisce il cinema vuole dotarsi di uno strumento per la programmazione e la gestione dei film di un multisala al fine di ottimizzare a pianificare la loro permanenza in sala. L’applicazione dovrà permettere la visualizzazione della lista dei film messi in programmazione nel multisala, al fine di organizzare anche uno storico consultabile dai gestori. Tale applicativo sarà utilizzato anche come fonte dati per visualizzare i film attualmente in sala sul sito web del cinema a beneficio del pubblico.

### Obiettivo
Realizzare un’applicazione web per la gestione della programmazione dei film nel cinema multisala, rispettando i vincoli tecnici e funzionali descritti nel paragrafo.

## Vincoli tecnici e funzionali
| ID | Nome | Descrizione
| --- | --- | --- |
| RF1 | Elenco film | L’applicativo deve consentire di visualizzare una lista dei film in programmazione, con possibilità di filtrare per data di inizio/data fine. In questo modo è possibile recuperare quali sono i film in programmazione per ciascuna settimana. |
| RF2 | Storico | Deve essere possibile per i gestori della piattaforma accedere allo storico completo della programmazione dei film passati. |
| RT1 | Schema logico | Ipotizzare uno schema logico dell’applicativo, preferibile in notazione UML. |
| RT2 | Backoffice e REST API | Realizzare un prototipo applicativo in Spring Boot (JAVA) per l’esposizione di un web service REST in GET per la visualizzazione della lista dei film. Puoi immaginare uno scheda ed una struttura dati da visualizzare nell’applicativo. |
| RT3 | Frontend | [Opzionale] Realizzare un prototipo applicativo in Angular per l’interfaccia. Nell’interfaccia deve essere possibile visualizzare l’elenco dei film recuperati dal servizio REST. |

## Deliverables
I materiali che ci aspettiamo potrai creare:
- Repository per il codice sorgente (puoi caricare il lavoro su GitHub o simili e inviarci il link; non sono accettati ZIP o TAR)
- Una breve presentazione del lavoro svolto (PowerPoint, Keynote, PDF, Web)
- Altri documenti a tua discrezione (diagrammi UML, documentazione, etc…)

## Configurazione
Clonare il progetto in una qualsiasi cartella con il comando

```bash
  git clone https://github.com/PuddiPuddi96/lascaux-challenge-be.git
```

### Docker
1. Scaricare [docker desktop](https://www.docker.com/products/docker-desktop/)
2. Avviare l'applicazione
3. Aprire il prompt dei comandi e spostarsi nella cartella Docker del progetto
4. Per effettuare la build del docker eseguire il comando
```bash
  docker-compose build
```
5. Succesivamente per avviare il docker eseguire il comando
```bash
  docker-compose up -d
```

### Swagger
Al link di [swagger](http://localhost:19000/cine-mille/swagger-ui/index.html) sarà possibile visualizzare i servizi esposti dall'applicativo.
Inizialmente non sono prenseti film, per poterli inserire bisogna invocare il servizio [upload-films](http://localhost:19000/cine-mille/swagger-ui/index.html#/cine-mille-controller/uploadFilmsFromExcel) dove sarà possibile caricare i film presenti in un file excel.
All'interno del progetto è già presente un file excel da caricare e si trova nella cartella [Deliverables](https://github.com/PuddiPuddi96/lascaux-challenge-be/tree/main/Deliverables).

Una volta effettuato il caricamento dei film sarà possibile visualizzare lo storico dei film ([storico](http://localhost:19000/cine-mille/swagger-ui/index.html#/cine-mille-controller/getFilmsHistory)) o effettuare una ricerca dei film in programmazione filtrando per data inizio e/o data fine programmazione ([ricerca](http://localhost:19000/cine-mille/swagger-ui/index.html#/cine-mille-controller/getFilmsByFilter)) 

### Database
Per visualizzare il database bisogna andare a questo [link](http://localhost:19002) ed effettuare l'accesso con le seguenti credenziali:
- **username**: cinemille@temp.it
- **password**: cinemille

Una volta effettuato l'accesso per visualizzare le tabelle dell'applicativo bisogna andare in servers -> CINE_MILLE -> Databases -> cinemille -> schemas -> public -> tables. Nel caso in cui viene richiesta una password inserire **cinemille**
