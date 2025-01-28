/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._primero;

/**
 * Clase que representa a un <font color=red>carro</font>
 * @author Gerardo <u>Portillo</u>
 * @since  2025-01-27
 */
public class Carro {
    //atributos
    public String marca;
    public String modelo;
    public String color;
    public int anio;
    //constructores
    /**
     * Construye un nuevo objeto de clase Carro
     * @param marca la <u>marca</u> del vehiculo
     * @param modelo el <b>modelo</b> del vehiculo
     * @param color el <i>color</i> del vehiculo
     * @param anio el año del vehiculo
     * <br/>
     * <img src="https://sistemas2g.com/site/images/2G.png" height=40 width=50/>
     */
    public Carro(String marca, String modelo, String color, int anio){
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.anio = anio;
    }
    //metodos
    /**
     * Imprime el perfil del Carro
     */
    public void imprimir(){
        System.out.println("********** Carro ********** ");
        System.out.println("Marca: "+this.marca);
        System.out.println("Modelo: "+this.modelo);
        System.out.println("Color: "+this.color);
        System.out.println("Anio: "+this.anio);
    }
}
