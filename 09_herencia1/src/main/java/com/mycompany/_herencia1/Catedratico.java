package com.mycompany._herencia1;
public class Catedratico extends Empleado {
    //atributo
    public String profesion;
    //constructor
    public Catedratico(String profesion, String nombre, int edad,
                        char genero, float salario) {
        super(nombre, edad, genero, salario, "Catedratico");
        this.profesion = profesion;
    }
    //metodos
    public void educar(){
        System.out.println("Doy clases de mi profesion: "+this.profesion);
    }
}
