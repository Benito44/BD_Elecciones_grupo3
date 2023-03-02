-- 1. Quin o quins són els municipis amb el major número de votants?

SELECT m.municipi_id, m.nom
	FROM municipis m
    INNER JOIN vots_candidatures_mun v ON v.municipi_id = m.municipi_id
WHERE vots = (SELECT MAX(vots)
					FROM vots_candidatures_mun)
GROUP BY m.municipi_id;


-- 2.  Una select que mostri de la taula municipis si és un municipi o un districte
--     i en cas de ser un districte: quants districtes hi ha del municipi al qual pertany el districte;
--     i si és un municipi: quants municipis hi ha a la província on pertany el municipi.

SELECT 	IF(districte = 99, 'Municipi', 'Districte') AS 'Muncipi o districte',
		nom,
        IF(districte = 99, (SELECT COUNT(*)
								FROM municipis WHERE m1.provincia_id = m.provincia_id AND districte = 99),
						   (SELECT COUNT(*)
								FROM municipis m2
							WHERE m2.codi_ine = m.codi_ine AND districte != 99)) AS Quantitat
	FROM municipis m;


-- 3. Quin partit es el guanyador de les eleccions de 2016?

SELECT nom_curt
FROM candidatures
WHERE candidatura_id = (SELECT candidatura_id
                            FROM vots_candidatures_mun vcm
                            INNER JOIN eleccions e ON e.eleccio_id = vcm.eleccio_id
                        WHERE e.nom = "Eleccions 2016"
                        ORDER BY vots DESC
                        LIMIT 1);

-- 4. Diguem en quina comunitat autònoma te més vots el partit de 'VOX'

SELECT ca.nom
FROM comunitats_autonomes ca
WHERE ca.comunitat_autonoma_id = (SELECT m.comunitat_autonoma_id
                                        FROM municipis m
                                        INNER JOIN vots_candidatures_mun vcm ON vcm.municipi_id = m.municipi_id
                                        INNER JOIN candidatures c ON c.candidatura_id = vcm.candidatura_id
                                  WHERE c.nom_curt = "VOX"
                                  GROUP BY m.comunitat_autonoma_id
                                  ORDER BY SUM(vcm.vots) DESC
                                  LIMIT 1);


-- 5. Quina es la candidatura amb el nom més llarg?

SELECT nom
FROM candidatures
WHERE LENGTH(nom_llarg) = (SELECT MAX(LENGTH(nom_llarg))
                                FROM candidatures);

-- 6. Quin o quins són el nom més repetit entre totes les persones?

SELECT DISTINCT nom
	FROM persones
WHERE nom = (SELECT nom
				FROM persones
			 GROUP BY nom
			 ORDER BY COUNT(nom) DESC
			 LIMIT 1);