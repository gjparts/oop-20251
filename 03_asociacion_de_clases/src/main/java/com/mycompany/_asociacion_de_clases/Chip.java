/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._asociacion_de_clases;

/**
 *
 * @author Gerardo
 */
public class Chip {
    //atributos
    private Operador proveedor;
    public int numeroTelefonico;
    //constructor
    public Chip(Operador proveedor, int numeroTelefonico) {
        this.setProveedor(proveedor); //usar set para aplicar la regla
        this.numeroTelefonico = numeroTelefonico;
    }
    //metodos
    public Operador getProveedor() {
        return this.proveedor;
    }
    public void setProveedor(Operador proveedor) {
        //tambien puede validar que el proveedor
        //no sea null por medio del metodo set
        //en lugar de usar el constructor. Esto con
        //la finalidad de permitir al programador
        //por cambiar el atributo en cualquier momento
        //y no solo a la hora de crearlo.
        if( proveedor == null )
            throw new IllegalArgumentException("El provreedor no debe ser null");
        else
            this.proveedor = proveedor; //se acepta
    }
    
}
