# **-- MarkDown --**

La importació de dades d'un fitxer DAT a la base de dades s'ha dut a terme amb funcions cridant a cadascuna de les taules.
Dintre de cada funció, primer s'ubica el fitxer DAT en una carpeta comuna per cada un dels membres de l'equip, aleshores es busca amb un substring la posició exacta de la informació i es guarda en la seva variable corresponent.
Aquestes variables es guarden com paràmetres per la següent funció d'inserir, on es col·loquen per inserir-les en la base de dades.

Per facilitar la importació de les dades hem externalitzat la connexió a través de la classe _DBMySQLManager_, on tenim totes les nostres respectives _IP_, i la _IP_ que es connecta directament a la màquina principal del grup per agilitzar el procés. També disposem de totes les dades que 
es requereixen per connectar-se a la màquina (usuari, contrasenya...), i tres funcions. La primera es connecta a la base de dades, i les altres dues estableixen la connexió (cridant a la primera funció) o la tanquen.



 **-- ELECCIONS --**

S'importa manualment, ja que només tenim un tipus d'eleccions i aquesta és la de 2016.

**-- COMUNITATS_AUTONOMES --**

Trobarem el codi_ine i el nom dels quals siguin 99 per treure el nivell total.

**-- PROVÍNCIES --**

Importarem les províncies excloent el total nacional i la comunitat. On la ID de la comunitat autònoma 
l'extraiem on el codi_ine de la taula de la comunitat autònoma.

**-- MUNICIPIS --**

A la de municipis extraurem el nom del municipi si el número del districte municipal és 99 o el nom de la província si aquest no és 99. També hem canviat la clau única del codi_ine perquè 
aquesta faci referència al districte i a la província també.
On la ID de la província l'extraiem amb el codi_ine de la taula de províncies.

**-- CANDIDATURES --**

Les taules com candidats necessiten aquesta taula.

**-- PERSONES I CANDIDATS--**

Tant a la taula de persones com candidats guardem les seves dades alhora, ja que s'extreuen del mateix fitxer.

Dintre de candidats hem de treure la candidatura_id de la taula candidatures on el seu codi sigui igual al valor
extret i que la seva elecció sigui 1.
La persona_id de la taula persones on el seu dni sigui igual al valor
extret.
La provincia_id de la taula províncies on el seu codi sigui igual al valor
extret.

**-- VOTS MUNICIPALS --**
# FALTA:
Afegim els vots municipals on 

**-- VOTS PROVINCIALS  --**

Afegim els vots provincials on la ID de la província l'extraiem on el codi_ine de la taula de províncies.
I on la ID de la candidatura la saquem de la taula candidatures.

**-- VOTS AUTONOMICS --**

Afegim els vots autonomics on hem de treure la candidatura_id de la taula candidatures on el seu codi sigui igual al valor
extret i que la seva elecció sigui 1 i on hem de treure la comunitat_autonoma_id de la taula comunitats_autonomes on el seu codi sigui igual al valor
extret.

Com els vots provincials i els autonòmics s'extreuen del mateix document, hem de posar un filtre perquè només agafi les dades de les autonomies. El filtre es un _substring_ que iguali a 99 el codi de la comunitat autònoma. Si no és així, seria una província.


**-- PROBLEMES --**

- Per la taula vots_candidats_municipis necessitàvem importar el seu municipi_id des de la taula eleccions_municipis 
i dintre de la informació de la base de dades no teníem cap indici d'aquesta taula.
Al final vam arribar amb dues opcions diferents:
1. Fer que la foreign key apunti a la taula de municipis amb el municipi_id i a la taula de candidatures amb l'eleccio_id.
2. Omplir la taula eleccions_municipis amb el mateix fitxer de la taula municipis 

- A l'hora de fer els "_commit and push_" ens vam adonar que les llibreries desapareixien pel fet que no tots els companys les havíem importat correctament. Vam decidir penjar aquestes al repositori perquè així fossin comuns.
Vam escollir la segona opció i vam inserir les dades seguidament amb les de municipi


- Hem hagut d'inventar-nos un DNI generat a partir de **número de volta** + **codi INE de província** + **districte electoral** + **codi de la candidatura** + **número d'ordre de candidat** (hem filtrat uns quants números que es repetien per fer-lo més net).


- 

# FALTA:
3. count de vots_municipis