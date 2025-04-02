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

--Crear una base de datos y borrarla
CREATE DATABASE prueba
GO
DROP DATABASE prueba
GO
