-- Volem saber la quantitat de candidatures que hi ha per cada longitud de llista electoral
-- (entenem longitud de llista com a quantitat de candidats que té aquesta).
-- Ho volem ordenar per quantitat de candidats.

WITH RECURSIVE count_candidats_llista(n_ordre)
AS (
	SELECT MIN(num_ordre)
		FROM candidats
    UNION ALL
    SELECT n_ordre + 1
		FROM count_candidats_llista
    WHERE n_ordre < (SELECT MAX(num_ordre)--TODO:més petit, o més petit o igual?
						FROM candidats)
)
SELECT n.n_ordre AS candidats_per_llista, COUNT(c.candidatura_id) AS quantitat_candidatures
	FROM count_candidats_llista n
    INNER JOIN candidats c ON c.num_ordre = n.n_ordre
GROUP BY n.n_ordre
ORDER BY 1 DESC;