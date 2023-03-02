-- 1. Quin és el  percentatge de participació, de vots blancs i de nuls de les eleccions municipals?

SELECT CONCAT(ROUND((SUM(vots_emesos) / SUM(cens) * 100),2), ' %') AS participacio,
       CONCAT(ROUND((SUM(vots_blanc) / SUM(vots_emesos) * 100), 2), ' %') AS percentatge_vots_blancs,
       CONCAT(ROUND((SUM(vots_nuls) / SUM(vots_emesos) * 100),2), ' %') AS percentatge_vots_nuls
    FROM eleccions_municipis;


-- 2. Quants candidats titulars (‘T') i quants candidats suplents (‘S’) té cada candidatura?

SELECT  candidatura_id,
        SUM(IF(tipus = 'T', 1, 0)) AS titulars,
        SUM(IF(tipus = 'S', 1, 0)) AS suplents
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


-- 5. Volem saber un dels noms més repetit entre totes les persones

SELECT nom
	FROM persones
GROUP BY nom
ORDER BY COUNT(nom) DESC
LIMIT 1;