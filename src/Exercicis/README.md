# **-- MarkDown --**

L'importació de dades d'un fitxer DAT a la base de dades s'ha dut a terme amb funcions cridant a cadascuna de les taules.
Dintre de cada funció, primer s'ubica el fitxer DAT en una carpeta comuna per cada un dels membres de l'equip, aleshores es busca amb un substring la posició exacta de l'informació i es guarda en la seva variable corresponent.
Aquestes variables es guarden com parametres per la seguent funció d'Insertar, on es col·loquen per inserir-les en la base de dades.

Quan executem la classe principal Export

 **-- ELECCIONS --**

S'importa manualment, ja que nomès tenim un tipus d'eleccions i aquesta és la de 2016.

**-- COMUNITATS_AUTONOMES --**

Trobarem el codi_ine i el nom dels quals siguin 99 per treure el nivell total.

**-- PROVINCIES --**

Importarem les províncies excloent el total nacional i la comunitat. On la ID de la comunitat autonoma 
la saquem on el codi_ine de la taula de la comunitat autònoma.

**-- MUNICIPIS --**

A la de municipis extraurem el nom del municipi si el número del districte municipal es 99 o el nom de la província si aquest no es 99.També hem canviat la clau unica del codi_ine perque 
aquesta es refereixi al districte i a la provincia també.
On la ID de la provincia la treiem amb el codi_ine de la taula de la provincies.

**-- CANDIDATURES --**

Les taules com candidats necessiten aquesta taula.

**-- PERSONES I CANDIDATS--**

Tant a la taula de persones com candidats guardem les seves dades alhora, ja que s'extreuen del mateix fitxer.

Dintre de candidats hem de treure la candidatura_id de la taula candidatures on el seu codi sigui igual al valor
extret i que la seva elecció sigui 1.
La persona_id de la taula persones on el seu dni sigui igual al valor
extret.
La provincia_id de la taula provincies on el seu codi sigui igual al valor
extret.

**-- VOTS MUNICIPALS --**

Afegim els vots municipals on 

**-- VOTS PROVINCIONALS  --**

Afegim els vots provincionals on la ID de la provincia la saquem on el codi_ine de la taula de la provincies.
I on la ID de la candidatura la saquem de la taula candidatures.

**-- VOTS AUTONOMICS --**

Afegim els vots autonomics on hem de treure la candidatura_id de la taula candidatures on el seu codi sigui igual al valor
extret i que la seva elecció sigui 1 i on hem de treure la comunitat_autonoma_id de la taula comunitats_autonomes on el seu codi sigui igual al valor
extret.

filtrar 99

**-- PROBLEMES --**


Dintre d'eleccions municipis
vots_can_mun--> municipi_id
MUNICIPIS I CANDIDATURES
RELLENAR ELECCIONS
   foreign i primary

