Casi d'uso
==========

###Consulta listino:

    Un utente non autenticato consulta il catalogo dei prodotti tramite il pulsante *Visualizza lista prodotti*.

    Il sistema mostra l'elenco dei prodotti nel catalogo.

    L'utente sceglie un prodotto e ne richiede i dettagli.

    Il sistema mostra i dettagli del prodotto scelto.

    L'utente ripete i passi precedenti un numero indefinito di volte.

Casi d'uso cliente:
-------------------

###Registrazione:

    Un utente non registrato fa click sul pulsante *Registrati*.

    L'utente inserisce i proprio dati e conferma tramite il pulsante *submit*.

    Il sistema controlla i dati inseriti e li registra.

###Login:

    L'utente inserisce la propria email e la password.

    L'utente fa click su *Login Utente*.

    Il sistema controlla i dati inseriti e autentica l'utente.

###Logout:

    L'utente autenticato fa click sul pulsante *Logout*.

    Il sistema deautentica l'utente e lo reindirizza alla pagina principale.

###Creazione nuovo ordine:

    L'utente autenticato fa click su *Crea ordine*.

    Il sistema registra un nuovo ordine negli ordini dell'utente e aggiorna la data di creazione.

    Il sistema mostra all'utente i prodotti disponibili.

###Inserimento prodotto nell'ordine:

    L'utente autenticato seleziona la quantità del prodotto che vuole acquisare e preme il pulsante
    *Aggiungi al carrello* per confermare.

    Il sistema registra l'inserimento del prodotto nell'ordine.

    L'utente ripete i passi precedenti un numero indefinito di volte.

    L'utente seleziona *Completa l'ordine* per confermare.

    Il sistema mostra un riepilogo dell'ordine.

    // Bug noto: la quantità selezionata non è corretta, la quantità effettivamente inserita è quella relativa
            all'ultimo prodotto mostrato. Una possibile soluzione sarebbe stata fare selezionare al cliente
            un prodotto e mostrargli una nuova form con cui inserire il prodotto all'ordine.


###Visualizza ordini:

    L'utente autenticato seleziona *Visualizza ordini*.

    Il sistema mostra un riepilogo degli ordini effettuati dall'utente, mostrando data di apertura,
    data di chiusura e data di evasione dell'ordine.

Casi d'uso amministratore:
--------------------------

###Login:

###Logout:

###Inserimento nuovo amministratore:

###Inserimento nuovo prodotto:
