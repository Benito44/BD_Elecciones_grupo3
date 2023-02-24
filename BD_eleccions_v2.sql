
/**** INSERT MANUAL A LA TAULA ELECCIONS ***/


INSERT INTO eleccions (eleccio_id, nom, data)
	VALUES (1, 'Eleccions 2016', '2016-06-02');
    
    
 /**** MODIFICACIONS A LA TAULA PERSONES PER BORRAR COLUMNES EN BLANC I MODIFICAR EL DNI ***/   
 
 
    ALTER TABLE persones
DROP INDEX uk_persones_dni,
MODIFY COLUMN dni CHAR(16) NOT NULL,
DROP COLUMN sexe,
DROP COLUMN data_naixement,
ADD CONSTRAINT uk_persones_dni UNIQUE(dni);


/**** BORREM LA UK QUE VE PER DEFECTE I LA TORNEM A CREAR ***/


	ALTER TABLE municipis
DROP INDEX uk_municipis_codi_ine,
ADD CONSTRAINT uk_municipis_codi_ine_provincia_districte UNIQUE (codi_ine, provincia_id, districte);  



    
