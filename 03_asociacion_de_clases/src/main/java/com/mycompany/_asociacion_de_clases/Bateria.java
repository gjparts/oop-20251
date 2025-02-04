/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._asociacion_de_clases;

/**
 *
 * @author Gerardo
 */
public class Bateria {
    //atributos
    private Fabricante marca;
    public float miliamperios;
    //constructor
    public Bateria(Fabricante marca, float miliamperios) {
        /*observen que en el diagrama la relacion entre
        Bateria y Fabricante es de tipo composicion (rombo lleno)
        por lo tanto se obliga a que el Fabricante de Bateria
        siempre tenga que tener un objeto, o sea que no puede
        quedar nulo (null), por lo tanto nos aseguramos
        desde el constructor que el Fabricante de la Bateria
        no venga nulo.*/
        if( marca == null )
            throw new IllegalArgumentException("la marca en Bateria no puede ser null");
        else
            this.marca = marca; //se acepta
        
        this.miliamperios = miliamperios;
    }
    //metodos
    public Fabricante getMarca() {
        return this.marca;
    }
    
}
