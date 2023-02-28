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

-- TODO: 3