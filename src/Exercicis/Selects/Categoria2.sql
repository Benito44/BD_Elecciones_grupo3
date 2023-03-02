-- 1.  Mostra'm els parells de municipis que tinguin el mateix ratio de participació

WITH participacio (ratio) AS (SELECT nom, vots_emesos / cens AS ratio
								FROM eleccions_municipis e1
							  WHERE districte = 99)
SELECT p.nom, p1.nom
	FROM participacio p
    INNER JOIN participacio p1 USING (ratio)
WHERE p.nom != p1.nom;


-- 2. Diguem el nom dels municipis que pertanyen a la província de Girona.

SELECT m.nom
    FROM municipis m
    INNER JOIN provincies pr ON pr.provincia_id = m.provincia_id
WHERE pr.nom = "Girona"


--3. Diga'm el número total de candidats que tenim a Catalunya.

SELECT count(*) AS num_candidats
    FROM candidats c
    INNER JOIN provincies p ON c.provincia_id = p.provincia_id
    INNER JOIN comunitats_autonomes ca ON ca.comunitat_aut_id = p.comunitat_aut_id
WHERE ca.nom = "Catalunya"
GROUP BY ca.comunitat_aut_id;

-- 4. Quantes meses té cada municipi i ordenales per quantitat de meses de forma descendent.

SELECT e.num_meses, m.nom
	FROM eleccions_municipis e
	LEFT JOIN municipis m ON e.municipi_id = m.municipi_id
GROUP BY e.num_meses, m.nom
ORDER BY num_meses DESC;


-- 5. Quins candidats es presenten amb la candidatura del PP

SELECT p.nom, p.cog1, p.cog2
	FROM persones p
    INNER JOIN candidats c ON c.persona_id = p.persona_id
    INNER JOIN candidatures ca ON ca.candidatura_id = c.candidatura_id
WHERE ca.nom_curt = "PP"

-- 6. Diguem la mitjana de vots per municipis.

SELECT m.nom, ROUND(AVG(v.vots), 0) AS mitjana
    FROM municipis m
    INNER JOIN vots_candidatures_mun v ON v.municipi_id = m.municipi_id
GROUP BY m.nom
ORDER BY mitjana DESC;