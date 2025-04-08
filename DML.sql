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