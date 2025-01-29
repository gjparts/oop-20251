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
        per1.imprimir();
        
        //llenar los atributos de per1:
        per1.nombre = "Gerardo Portillo";
        per1.edad = 42;
        per1.genero = 'M';
        
        //volver a imprimir lo que hay en los atributos de per1
        per1.imprimir();
        
        //crear otro objeto de clase Persona
        Persona per2 = new Persona("Irene", 42, 'F');
        //imprimir lo que hay en los atributos de per2
        per2.imprimir();
                
        //crear objeto de clase Persona
        Persona per3 = new Persona("Josue", 'M');
        //imprimir lo que hay en los atributos de per3
        per3.imprimir();
        System.out.println("El genero de per3 es "+per3.getGeneroDescripcion());
        
        System.out.println("per2 es mayor de edad? "+per2.esMayorDeEdad());
        System.out.println("per3 es mayor de edad? "+per3.esMayorDeEdad());
        
        Carro car1 = new Carro("Toyota","Camry","Blanco",1988);
        car1.imprimir();
        
        Carro car2 = new Carro("Honda", "Civic", "Negro", 2004);
        car2.imprimir();
        
        Empleado em1 = new Empleado("Filomeno Colinas",42,'M',23000.00f,'P');
        em1.imprimir();
        
        Empleado em2 = new Empleado("Estevancito Maravilla", 70, 'M');
        em2.setGenero('M');
        em2.setSalario(35000);
        em2.setContrato('T');
        
        em2.imprimir();
        
    }
}
