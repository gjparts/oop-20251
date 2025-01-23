/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._primero;

/**
 *
 * @author Gerardo
 */
public class Persona {
    //atributos
    public String nombre;
    public int edad;
    public char genero;
    //constructores
    //se recomienda definir un constructor sin parametros
    //en caso de haber ningun constructor en la clase
    //entonces JAVA les termina definiendo
    //un constructor sin parametros automaticamente
    /*Al final un constructor es un metodo que permite
    colocar en memoria un objeto y este nos devuelve dicha
    direccion de memoria para apuntarla al mismo.
    Sus caracteristicas son:
    1) casi siempre son publicos
    2) siempre se llaman igual que la clase
    3) no se les define un tipo de dato porque retornan una direccion de memoria
    4) regularmente se usan para la inicializacion de los atributos de una clase
    5) en la mayoria de lenguajes de programacion puede haber mas
       de un constructor por clase.*/
    
    //constructor sin parametros:
    public Persona(){
        //inicializar los atributos de la clase con valores default
        this.nombre = "No definido";
        this.edad = 0;
        this.genero = 'X';
    }
    //constructor con tres parametros
    public Persona(String nombre, int edad, char genero){
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
    }
    //constructor con dos parametros
    public Persona(String nombre, char genero){
        this.nombre = nombre;
        this.genero = genero;
        this.edad = 0;
    }
    //metodos
    public void imprimir(){
        System.out.println("********** Perfil de Persona **********");
        System.out.println("Nombre: "+this.nombre);
        System.out.println("Edad: "+this.edad);
        System.out.println("Genero: "+this.getGeneroDescripcion());
    }
    //metodo que devuelve el genero de Persona como descripcion
    public String getGeneroDescripcion(){
        if( this.genero == 'M' ) return "Masculino";
        if( this.genero == 'F' ) return "Femenino";
        if( this.genero == 'X' ) return "Otros";
        return "No configurado en el programa";
    }
}
