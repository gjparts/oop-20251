/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany._primero;

/**
 *
 * @author Gerardo
 */
public class App {

    public static void main(String[] args) {
        //instanciar un nuevo objeto de clase Persona
        Persona per1 = new Persona();
        //imprimir la direccion de memoria de per1
        System.out.println("Direccion de memoria de per1: "+per1);
        //imprimir lo que hay en los atributos de per1
        System.out.println("nombre:"+per1.nombre);
        System.out.println("edad:"+per1.edad);
        System.out.println("genero:"+per1.genero);
        
        //llenar los atributos de per1:
        per1.nombre = "Gerardo Portillo";
        per1.edad = 42;
        per1.genero = 'M';
        
        //volver a imprimir lo que hay en los atributos de per1
        System.out.println("nombre:"+per1.nombre);
        System.out.println("edad:"+per1.edad);
        System.out.println("genero:"+per1.genero);
    }
}
