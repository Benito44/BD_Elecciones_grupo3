-- 1. Digues el percentatge de vots vàlids, blancs i nuls de les eleccions municipals.

SELECT SUM(vots_emesos) / SUM(cens)* 100 AS percentatge_vots_valids,
       SUM(vots_blanc) / SUM(cens) * 100 AS percentatge_vots_blancs,
       SUM(vots_nuls) / SUM(cens) * 100 AS percentatge_vots_nuls
    FROM eleccions_municipis;

-- 2. Digues quants candidats titulars (‘T') I quants candidats suplents (‘S’) existeixen per a cada candidatura.
--    Agrupa la resposta per candidatura.

SELECT candidatura_id, SUM(IF(tipus = 'T', 1, 0)) AS titulars,  SUM(IF(tipus = 'S', 1, 0)) AS suplents
    FROM candidats
GROUP BY candidatura_id;


-- 3. Volem saber el nom i cognom de totes les persones el nom de les quals comenci per ‘J’. Mostra-ho per ordre alfabètic.

SELECT nom, cog1
    FROM persones
WHERE nom LIKE 'J%'
ORDER BY nom ASC;


-- 4. Quina és la mitjana de vots per província a cada comunitat autònoma?

SELECT comunitat_id, AVG(vots)
	FROM provincies
GROUP BY comunitat_id;


-- 5. Quin o quins són el nom més repetit entre totes les persones?

SELECT nom, COUNT(*) as vegades_repetit
	FROM persones
GROUP BY nom
ORDER BY vegades_repetit DESC
LIMIT 1;