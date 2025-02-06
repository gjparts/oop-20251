/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany._asociacion_de_clases;

/**
 *
 * @author Gerardo
 */
public class App {

    public static void main(String[] args) {
        //primero crear objetos de las clases no dependientes
        Fabricante apple = new Fabricante("Apple Inc.","USA","Tim Cook");
        Fabricante samsung = new Fabricante("SAMSUNG", "Korea", "No se");
        Fabricante lg = new Fabricante("LG Chem", "Korea", "No se");
        Fabricante huawei = new Fabricante("Huawei","China","No se");
        
        Operador tigo = new Operador("TIGO","Centroamerica");
        Operador claro = new Operador("Claro","Honduras");
        //luego vienen las clases dependientes:
        Chip sim1 = new Chip(tigo,99991234);
        Chip sim2 = new Chip(tigo,98981212);
        Chip sim3 = new Chip(claro,33332222);
        
        Bateria bat1 = new Bateria(lg,4500);
        Bateria bat2 = new Bateria(samsung,6500);
        Bateria bat3 = new Bateria(lg,6000);
        
        SmartPhone sm1 = new SmartPhone(apple, "iPhone 16", 256, 8, bat1, sim3, null);
        sm1.imprimir();
        
        SmartPhone sm2 = new SmartPhone(samsung, "Galaxy S100", 512, 16, bat2, sim1, sim2);
        sm2.imprimir();
        
        //tambien es posible crear objetos dentro de parametros de metodos
        Chip sim4 = new Chip( new Operador("AT&T","USA"), 305223322);
        System.out.println("Operador de sim4: "+sim4.getProveedor().nombre);
        
        //tambien puede crear un objeto volatil de un solo uso
        //sin tener que almacenarlo en ninguna parte, nace, se utiliza y muere
        new SmartPhone(huawei, "Honor Play", 128, 6, bat3, sim4, null).imprimir();
    }
}
