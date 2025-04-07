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