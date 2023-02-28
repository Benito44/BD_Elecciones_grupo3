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
WHERE pr.nom LIKE '%Girona%'

--TODO: 1

-- 4. Quantes num_meses té cada municipi i ordenar-la per quantes quantitats té.

SELECT e.num_meses, m.nom
	FROM eleccions_municipis e
	LEFT JOIN municipis m ON e.municipi_id = m.municipi_id
GROUP BY e.num_meses, m.nom
ORDER BY num_meses DESC;


-- 5. Quins candidats es presenten a Madrid?

SELECT p.nom, p.cog1, p.cog2
    FROM persones p
    INNER JOIN candidats c ON c.persona_id = p.persona_id
    INNER JOIN provincies pr ON pr.provincia_id = c.provincia_id
WHERE pr.nom LIKE '%Madrid%';