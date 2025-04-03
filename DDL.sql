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