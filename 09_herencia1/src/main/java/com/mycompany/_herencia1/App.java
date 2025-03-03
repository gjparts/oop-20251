package com.mycompany._herencia1;
public class App {

    public static void main(String[] args) {
        Estudiante es1 = new Estudiante("20012002049", "Gerardo", 42, 'M', "Ing. Industrial");
        es1.saludar();
        es1.estudiar();
        
        Persona p1 = new Persona("Filomeno Colinas",70,'M');
        p1.saludar();
        
        Empleado e1 = new Empleado();
        e1.nombre = "Pedro Picapiedra";
        e1.cargo = "Operador de Brontosaurio";
        e1.saludar();
        e1.trabajar();
        
        Empleado e2 = new Empleado("Pablo Marmol", 40, 'M', 20000, "Inspector de calidad");
        e2.saludar();
        e2.trabajar();
    }
}
