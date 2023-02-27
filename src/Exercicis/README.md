Entrar en isard, con la cuenta: daw-m2-g3 y la contraseña sapa98765
Activar maquina y poner root patata dentro de la maquina virtual
cerrar la cuenta y entrar en cuenta personal


MarkDOWN

L'importació de dades d'un fitxer DAT a la base de dades s'ha dut a terme amb funcions cridant a cadascuna de les taules.
Dintre de cada funció, primer s'ubica el fitxer DAT en una carpeta comuna per cada un dels membres de l'equip, aleshores es busca amb un substring la posició exacta de l'informació i es guarda en la seva variable corresponent.
Aquestes variables es guarden com parametres per la seguent funcio d'Insertar, on es col·loquen per inserir-les en la base de dades.

Quan executem la classe principal Export, 
la primera taula que s'importa és la d'eleccions i 
s'importa manualment, ja que nomès tenim un tipus d'eleccions i 
aquesta és la de 2016.
La seguent taula a importar és la de comunitats_autonomes on trobarem el codi_ine i el nom dels quals siguin 99 per treure el nivell total.
A la taula de provincies importarem les províncies exlcoent //el nivell total.
A la de municipis extraurem el nom del municipi si el número del districte municipal es 99 o el nom de la província si aquest no es 99.També hem canviat la clau unica del codi_ine perque aquesta es refereixi al districte i a la provincia també.
A continuació afeguim la taula de candidatures (FK)
Tant a la taula de persones com candidats guardem les seves dades alhora, ja que s'extreuen del mateix fitxer
I per últim afeguim les tres taules de vots municipals, provincials, i autonomics amb (una sequencia sql) perquè les tres necessiten d'un () per guardar les seves dades().

