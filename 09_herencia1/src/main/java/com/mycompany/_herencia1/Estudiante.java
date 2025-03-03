package com.mycompany._herencia1;
public class Estudiante extends Persona {
    //atributos
    public String cuenta;
    public String carrera;
    //constructor
    public Estudiante(String cuenta, String nombre, int edad, char genero, String carrera){
        //construir la super clase
        //si la super clase no tiene constructores entonces no se hace lo del
        //siguiente renglon
        super(nombre, edad, genero); //trasladar algunos datos a la clase Padre
        //inicializar los atributos de la clase hija (clase actual)
        this.cuenta = cuenta;
        this.carrera = carrera;
    }
    //metodos
    public void estudiar(){
        System.out.println("Estudio la carrera de "+this.carrera+" y mi edad es "+this.edad);
    }
}
