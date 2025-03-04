package com.mycompany._herencia1;
public class Practicante extends Empleado {
    //atributo
    public int meses;
    //constructor
    public Practicante(String nombre, int edad, int meses){
        //voy a usar el constructor sin parametros de la super clase
        super();
        //llenar los atributos sin necesidad del constructor de la super clase
        this.nombre = nombre;
        this.edad = edad;
        this.cargo = "Practicante o Pasante";
        this.meses = meses;
        this.salario = 0;
    }
}
