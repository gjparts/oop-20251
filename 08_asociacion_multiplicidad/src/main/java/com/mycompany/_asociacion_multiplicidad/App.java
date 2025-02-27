package com.mycompany._asociacion_multiplicidad;
import java.util.LinkedList;
public class App {
    public static void main(String[] args) {
        Barrio b1 = new Barrio("Brisas del Valle","Este","21101");
        Direccion dir1 = new Direccion(b1);
        dir1.calle = "Principal";
        dir1.avenida = "6";
        dir1.casa = "1033";
        
        Barrio b2 = new Barrio("El Centro","Centro","21100");
        Direccion dir2 = new Direccion(b2);
        dir2.avenida = "1 (La linea)";
        dir2.calle = "14";
        
        Empresa em1 = new Empresa("Extralum", dir2, 55555555);
        
        Mascota m1 = new Mascota("Yue","Gato");
        Mascota m2 = new Mascota("Shira","Gato");
        Mascota arr1[] = {m1,m2, new Mascota("Vader","Gato") };
        
        Persona per2 = new Persona("1234123412345","Irene Erazo",12341234);
        per2.direccion = dir1;
        per2.mascotas = arr1;
        
        Diploma dip1 = new Diploma("INFOP", "Torno y fresa");
        Diploma dip2 = new Diploma("INFOP", "Reparacion de maquina de coser");
        LinkedList diplomas1 = new LinkedList();
        diplomas1.push(dip1);
        diplomas1.push(dip2);
        
        Persona per3 = new Persona("","Odiseo",0);
        Persona per4 = new Persona("","Persefone",0);
        LinkedList hijos1 = new LinkedList();
        hijos1.push(per3);
        hijos1.push(per4);
        
        Persona per1 = new Persona("1401198201055","Gerardo Portillo",99999999);
        per1.direccion = dir1;
        per1.empresaLabora = em1;
        per1.mascotas = arr1;
        per1.conyuge = per2;
        per1.diplomas = diplomas1;
        per1.hijos = hijos1;
        per1.imprimir();
        
        //imprimir perfil de la per2
        per2.hijos = per1.hijos; //tienen hijos en comun
        per2.conyuge = per1;
        per2.imprimir();
    }
}
