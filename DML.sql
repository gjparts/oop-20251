/*DML = Data Manipulation Language*/
--importante: siempre seleccione primero la base de datos
USE Gerardo
GO

--Las instrucciones DML no requieren del uso de GO; pero lo pueden
--seguir usando. En otros lenguages de base de datos se obliga
--a poner punto y coma al final de cada instruccion (MySQL)

/*Instruccion INSERT: agrega nuevos registros a la tabla.
a) INSERT debe incluir todos los campos obligatorios de la tabla
b) Los campos opcionales son aquellos que admiten NULL esos
   no son obligatorios
c) Si hay una columna IDENTITY (autonumerica) entonces esta
   no se incluye en el INSERT aunque dicho campo sea obligatorio*/

--este INSERT llena todos los campos de la tabla Producto
--observe que VALUES coloca el valor de cada campo mencionado en INSERT
--en lenguage SQL los VARCHAR llevan comilla simple
INSERT Producto(Codigo,Nombre,Costo,PrecioVenta,Existencias,Comentarios)
VALUES('PR01','Coca Cola 3L',60,65,200,'Mala para la salud')

--en INSERT no es necesario nombrar las columnas en el orden que estan en la tabla
INSERT Producto(Nombre,Costo,Codigo,Comentarios,PrecioVenta,Existencias)
VALUES('Sprite 2L',58,'PR02','Tambien malo para la salud',62,90)

--puede excluir aquellas columnas que sea opcionales (admiten NULL)
INSERT Producto(Codigo,Nombre,Costo,PrecioVenta,Existencias)
VALUES('PR60','Ricasula',5,8,75)

--si excluye un campo obligatorio en INSERT, dara error y no se ejecutara ese INSERT
INSERT Producto(Nombre,Costo,PrecioVenta,Existencias)
VALUES('Mentos',14,22,30)

--se puede hacer varios INSERT en una sola definicion de campos
INSERT Producto(Codigo,Nombre,Costo,PrecioVenta,Existencias,Comentarios)
VALUES
('PR52','Ruffles',30,35,20,'Papitas sencillas'),
('PR33','Tomate por Libra',7,12,60,'Bueno para la salud'),
('PR22','Lechuga por Unidad',15,19.5,100,NULL),
('PR22','Pera',4,7.99,46,NULL)

/*Instruccion SELECT: permite consultar los registros de una tabla
Tiene varios modificadores para determinar que informacion mostrar*/

--Consultar todos los registros de todas las columnas de la tabla Producto
SELECT * FROM Producto
/*CONSEJO: no utilice el signo ASTERISCO * en un SELECT cuando ya vaya
a publicar algo a produccion, ya que usarlo hace una segunda consulta a los
metadatos del modelo de la tabla y eso es consumo de recursos innecesarios.
En su lugar nombre las columnas que desea mostrar en el SELECT:*/
SELECT ProductoID,Codigo,Nombre,Costo,PrecioVenta,Existencias,Comentarios FROM Producto

--mostrar unicamente las primeras 3 filas y todas las columnas de la tabla producto
SELECT TOP(3) * FROM Producto
SELECT TOP(3) ProductoID,Codigo,Nombre,Costo,PrecioVenta,Existencias,Comentarios FROM Producto

--mostrar algunas columnas
SELECT Codigo, Nombre, PrecioVenta FROM Producto
SELECT Nombre, Codigo, Comentarios, Costo FROM Producto

--tambien puede colocar apodos o alias a las columnas
SELECT ProductoID as Identidad, Codigo, Nombre as [Nombre del Producto],
		PrecioVenta as [Precio de Venta], Comentarios as Observaciones
FROM Producto
--si va a usar alias de varias palabras use brackets []
--si solo es una palabra su uso es opcional

--Campos calculados en tiempo real
SELECT Codigo, Nombre, Costo, PrecioVenta, PrecioVenta-Costo as Utilidad,
	   PrecioVenta*0.15 as [I.S.V.], POWER(PrecioVenta,2) as [Precio de Venta al Cuadrado],
	   SQRT(Costo) as [Raiz Cuadrada del Costo],
	   (PrecioVenta-Costo)/Costo*100 as [Desviacion Estandar de la Utilidad vs Costo]
FROM Producto

--todos los productos ordenados por precio de venta de menor a mayor
SELECT Codigo, Nombre, PrecioVenta
FROM Producto
ORDER BY PrecioVenta ASC

--todos los productos ordenados por precio de venta de mayor a menor
SELECT Codigo, Nombre, PrecioVenta
FROM Producto
ORDER BY PrecioVenta DESC

--mostrar los productos ordenados alfabeticamente por nombre de menor a mayor
SELECT Codigo, Nombre, PrecioVenta
FROM Producto
ORDER BY Nombre ASC

--ordenar usando como criterio mas de un campo.
--mostrar los productos ordenados por precio de venta de mayor a menor y luego
--por nombre de menor a mayor
SELECT Codigo, Nombre, PrecioVenta
FROM Producto
ORDER BY PrecioVenta DESC, Nombre ASC

--se puede hacer ordenamiento a traves del resultado de campos calculados:
--ordenar los productos desde el que da mas ganancias hasta el que da menos ganancias
--y luego un segundo ordenamiento por nombre de forma ascendente
SELECT Codigo, Nombre, PrecioVenta-Costo as Utilidad
FROM Producto
ORDER BY PrecioVenta-Costo DESC, Nombre ASC
--observe que para el campo calculado no se incluye el alias en el ORDER BY

--Funciones de agregado
--cantidad de registros en la tabla producto
SELECT COUNT(ProductoID) FROM Producto
--mostrar la suma de todos los precios de venta de la tabla producto
SELECT SUM(PrecioVenta) FROM Producto
--se recomienda ponerle alias a las columnas resultantes:
SELECT COUNT(ProductoID) as Registros FROM Producto
SELECT SUM(PrecioVenta) as [Suma de precio de venta] FROM Producto
--mostrar la ganancia total de los productos
SELECT SUM(PrecioVenta-Costo) as [Ganancia Total] FROM Producto
--o sea que puede usar campos calculados en funciones de agregado
--mostrar el costo promedio de todos los producto:
SELECT AVG(Costo) as Promedio FROM Producto
--mostrar el producto cuyo costo sea el mayor
SELECT MAX(Costo) FROM Producto
--mostrar el producto cuyo costo sea el menor
SELECT MIN(Costo) FROM Producto

--mostrar todas las columnas del producto mas caro de vender
SELECT TOP(1) ProductoID,Codigo,Nombre,Costo,PrecioVenta,Existencias,Comentarios
FROM Producto
ORDER BY PrecioVenta DESC

--mostrar todas las columnas del producto mas barato de vender
SELECT TOP(1) ProductoID,Codigo,Nombre,Costo,PrecioVenta,Existencias,Comentarios
FROM Producto
ORDER BY PrecioVenta ASC

--reemplazar valores NULL a la hora de mostrar
SELECT Codigo, Nombre, ISNULL(Comentarios,'No tiene comentarios') as Comentarios
FROM Producto

--Uso del WHERE: sirve para filtrar los registros en una consulta
--mostrar aquellos productos con costo mayor o igual que 30
SELECT ProductoID,Codigo,Nombre,Costo,PrecioVenta,Existencias,Comentarios
FROM Producto
WHERE Costo >= 30
--mostrar aquellos productos con costo mayor o igual que 30 ordenados
--alfabeticamente por nombre
SELECT ProductoID,Codigo,Nombre,Costo,PrecioVenta,Existencias,Comentarios
FROM Producto
WHERE Costo >= 30
ORDER BY Nombre ASC
--mostrar productos cuyas existencias sean menores a 10
SELECT ProductoID,Codigo,Nombre,Costo,PrecioVenta,Existencias,Comentarios
FROM Producto
WHERE Existencias < 25
--tambien puede utilizar operadores logicos como AND y OR
--mostrar productos cuyo costo este entre 30 y 70
SELECT ProductoID,Codigo,Nombre,Costo,PrecioVenta,Existencias,Comentarios
FROM Producto
WHERE Costo >= 30 AND Costo <= 70
--mostrar productos cuyo costo este entre 20 y 30 � cuyo costo
--este entre 60 y 100
SELECT ProductoID,Codigo,Nombre,Costo,PrecioVenta,Existencias,Comentarios
FROM Producto
WHERE ( Costo >= 20 AND Costo <= 30 ) OR ( Costo >= 60 AND Costo <= 100 )
--existe un operador llamado BETWEEN que permite obtener
--registros entre determinados randos numericos o de fecha
--mostrar productos cuyo costo este entre 30 y 70
SELECT ProductoID,Codigo,Nombre,Costo,PrecioVenta,Existencias,Comentarios
FROM Producto
WHERE Costo BETWEEN 30 AND 70

--tambien puede usar where en campos calculados
--mostrar los productos con ganancia >= 5
SELECT Codigo, Nombre, PrecioVenta-Costo as Ganancia
FROM Producto
WHERE PrecioVenta-Costo >= 5
--se omite el alias en el where

--uso de WHERE con valores NULL
--productos que tengan su comentario NULL
SELECT Codigo, Nombre, Comentarios
FROM Producto
WHERE Comentarios IS NULL
--productos que tengan su comentario distinto de NULL
SELECT Codigo, Nombre, Comentarios
FROM Producto
WHERE NOT Comentarios IS NULL

--operador OR
--productos cuyo precio de venta sea menor a 20 � mayor igual a 40
SELECT ProductoID,Codigo,Nombre,Costo,PrecioVenta,Existencias,Comentarios
FROM Producto
WHERE PrecioVenta < 20 OR PrecioVenta >= 40

--Uso del operador NO ES IGUAL o DIFERENTE DE
--productos cuyo precio de venta no sea igual a 35
--forma 1:
SELECT ProductoID,Codigo,Nombre,Costo,PrecioVenta,Existencias,Comentarios
FROM Producto
WHERE PrecioVenta != 35
--forma 2:
SELECT ProductoID,Codigo,Nombre,Costo,PrecioVenta,Existencias,Comentarios
FROM Producto
WHERE PrecioVenta <> 35
--forma 3 (invertir la expresion usando NOT)
SELECT ProductoID,Codigo,Nombre,Costo,PrecioVenta,Existencias,Comentarios
FROM Producto
WHERE NOT PrecioVenta = 35

--Uso de WHERE en campos de texto
--productos cuyo codigo sea PR22
SELECT ProductoID,Codigo,Nombre,Costo,PrecioVenta,Existencias,Comentarios
FROM Producto
WHERE Codigo = 'PR22'
--productos cuyo codigo sea PR22, PR01, PR02
SELECT ProductoID,Codigo,Nombre,Costo,PrecioVenta,Existencias,Comentarios
FROM Producto
WHERE Codigo IN ('PR22','PR01','PR02')
--IN tambien se puede usar en campos numericos y en subconsultas.

--productos cuyo codigo NO sea PR22, PR01, PR02
SELECT ProductoID,Codigo,Nombre,Costo,PrecioVenta,Existencias,Comentarios
FROM Producto
WHERE NOT Codigo IN ('PR22','PR01','PR02')

--uso del operador LIKE en campos de texto
--productos que lleven la palanbra salud en cualquier parte del comentario
SELECT ProductoID,Codigo,Nombre,Costo,PrecioVenta,Existencias,Comentarios
FROM Producto
WHERE Comentarios LIKE '%salud%'
--productos que lleven la letra s en cualquier parte del nombre
SELECT ProductoID,Codigo,Nombre,Costo,PrecioVenta,Existencias,Comentarios
FROM Producto
WHERE Nombre LIKE '%s%'

--productos que lleven la palabra salud en cualquier parte del comentario
--y que lleven la letra i en cualquier parte de su nombre
SELECT ProductoID,Codigo,Nombre,Costo,PrecioVenta,Existencias,Comentarios
FROM Producto
WHERE Comentarios LIKE '%salud%' AND Nombre LIKE '%i%'

--productos cuyo nombre comience con la letra r
SELECT ProductoID,Codigo,Nombre,Costo,PrecioVenta,Existencias,Comentarios
FROM Producto
WHERE Nombre LIKE 'r%'

--productos cuyo nombre termine con la letra a
SELECT ProductoID,Codigo,Nombre,Costo,PrecioVenta,Existencias,Comentarios
FROM Producto
WHERE Nombre LIKE '%a'

--productos cuyo codigo comience con PR0
SELECT ProductoID,Codigo,Nombre,Costo,PrecioVenta,Existencias,Comentarios
FROM Producto
WHERE Codigo LIKE 'PR0%'

/*Instruccion DELETE
Elimina uno o varios registros de una tabla dependiendo de lo
devuelto por el modificar WHERE.
-> Esta instruccion no modifica al campo IDENTITY.
-> Para la instruccion DELETE es recomendado que antes haga un SELECT
para tener una vista previa de lo que va a borrar.*/
--borrar todos los registros de una tabla
DELETE FROM Producto
--Eliminar todos los productos cuyo costo sea menor a 10
--vista previa
SELECT *
FROM Producto
WHERE Costo < 10
--eliminar los registros
DELETE FROM Producto
WHERE Costo < 10
--eliminar un producto de acuerdo a su ProductoID
SELECT * FROM Producto WHERE ProductoID = 11
DELETE FROM Producto WHERE ProductoID = 11
--eliminar productos cuyo comentario diga que es malo para la salud
SELECT *
FROM Producto
WHERE Comentarios LIKE '%mal%' AND Comentarios LIKE '%salud%'

DELETE
FROM Producto
WHERE Comentarios LIKE '%mal%' AND Comentarios LIKE '%salud%'

/*Instruccion TRUNCATE: borra todos los registros de la tabla y en el caso
de SQL Server de Microsoft tambien reinicia el campo IDENTITY.*/
TRUNCATE TABLE Producto

/*Instruccion UPDATE: Modifica uno o varios registros de acuerdo a lo devuelto
segun el modificador WHERE.
-> Al igual que DELETE se recomienda hacer una vista previa de los registros a afectar*/
--colocar en CERO todas las existencias de todos los productos
SELECT* FROM Producto
UPDATE Producto SET Existencias = 0

--colocar en 100 las existencias del producto con codigo PR33
SELECT * FROM Producto WHERE Codigo = 'PR33'
UPDATE Producto SET Existencias = 100 WHERE Codigo = 'PR33'

--colocar en 50 las existencias de coca cola y sprite
SELECT * FROM Producto WHERE Codigo IN ('PR01','PR02')
UPDATE Producto SET Existencias = 50 WHERE Codigo IN ('PR01','PR02')

--se puede afectar a mas de un campo
--colocar en 200 las existencias para los productos PR52 y PR60, ademas de ponerles
--como comentario la frase: REVISADO.
SELECT * FROM Producto WHERE Codigo IN ('PR52','PR60')

UPDATE Producto
SET Existencias = 200, Comentarios = 'REVISADO'
WHERE Codigo IN ('PR52','PR60')

--UPDATE permite realizar calculos en base a informacion existente
--aumentar los precios de venta de todos los productos en un 10%
SELECT * FROM Producto 
UPDATE Producto SET PrecioVenta = PrecioVenta*1.10

--se puede hacer vista previa de como quedaria un calculo antes de aplicarlo?
--aumentar los costos de todos los productos en un 5%
SELECT Costo*1.05 as [Nuevo Costo], * FROM Producto
UPDATE Producto SET Costo = Costo*1.05

--se puede concatenar texto en campos que ta lo tienen
--agregar al comentario de los productos PR01 y PR33 la palabra VERIFICADO
--sin borrar el comentario que ya estaba
SELECT CONCAT(Comentarios,' VERIFICADO') ,* FROM Producto WHERE Codigo IN ('PR01','PR33')

UPDATE Producto
SET Comentarios = CONCAT(Comentarios,' VERIFICADO')
WHERE Codigo IN ('PR01','PR33')

SELECT * FROM Producto