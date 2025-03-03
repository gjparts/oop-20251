package com.mycompany._herencia1;
public class Empleado extends Persona {
    //atributos
    public float salario;
    public String cargo;
    //constructores
    //constructor sin parametros
    public Empleado(){
        //construir la super clase
        //este es un constructor sin parametros, por lo tanto
        //enviamos a la super clase datos predeterminados
        super("No tiene",0,'X');
        this.cargo = "No definido";
        this.salario = 0.00f;
    }
    //constructor con parametros
    public Empleado(String nombre, int edad, char genero, float salario, String cargo){
        //construir la super clase
        super(nombre, edad, genero);
        this.cargo = cargo;
        this.salario = salario;
    }
    //metodos
    public void trabajar(){
        System.out.println("Laboro en el cargo de "+this.cargo);
    }
}
