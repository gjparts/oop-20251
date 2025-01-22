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
    //constructor sin parametros:
    public Persona(){
        //inicializar los atributos de la clase con valores default
        this.nombre = "No definido";
        this.edad = 0;
        this.genero = 'X';
    }
}
