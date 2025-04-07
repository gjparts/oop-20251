--Comentario de una sola linea
/*Comentario
de varias
lineas*/
--Instrucciones Data Definition Language (DDL)
--Creacion de una nueva base de datos
CREATE DATABASE Gerardo
GO
/*Se recomienda colocar GO despues de cada
instruccion DDL ya que GO se asegura que se
termine de ejecutar la instruccion antes
de seguir con las demas instrucciones.*/

--Seleccionar la base de datos en la que va a trabajar
USE Gerardo
GO

--crear una tabla
CREATE TABLE Producto(
	ProductoID bigint NOT NULL IDENTITY(1,1), --autonumerar de 1 en 1 desde 1
	Codigo VARCHAR(25) NOT NULL,
	Nombre VARCHAR(150) NOT NULL,
	Costo DECIMAL(12,2) NOT NULL,
	PrecioVenta DECIMAL(12,2) NOT NULL,
	Existencias DECIMAL(12,2) NOT NULL,
	Comentarios TEXT NULL,
	PRIMARY KEY(ProductoID) --definir que columna va a ser su llave primaria
)
GO
/*NOT NULL = campo obligatorio de llenar
NULL = campo opcional de llenar*/

--borrar una tabla (peligroso)
DROP TABLE Producto
GO

--vaciar una tabla sin eliminarla (borrar solo los registros)
TRUNCATE TABLE Producto
GO
--tambien reinicia el campo IDENTITY

--Agregar una columna a una tabla que ya tiene datos
ALTER TABLE Producto
ADD Color VARCHAR(20) NULL
GO

--Borrar una columna de la tabla
ALTER TABLE Producto
DROP COLUMN Color
GO

--Cambiar el tamaño de una columna
ALTER TABLE Producto
ALTER COLUMN Nombre VARCHAR(200) NOT NULL
GO
--lo anterior cambiar el tamaño de Nombre a 200 en VARCHAR




