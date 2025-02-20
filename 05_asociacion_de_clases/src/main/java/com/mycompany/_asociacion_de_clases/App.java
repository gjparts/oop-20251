package com.mycompany._asociacion_de_clases;
public class App {
    public static void main(String[] args) {
        Barrio bar1 = new Barrio("Paraiso","Honduras","Cortes","San Pedro Sula");
        Barrio bar2 = new Barrio("Guamilito","Honduras","Cortes","San Pedro Sula");
        
        Direccion dir1 = new Direccion(bar2, "7", "8", "No tiene");
        Direccion dir2 = new Direccion(bar1, "", "", "10");
        
        Empresa cofisa = new Empresa("Compania Financiera S.A.","Credito",dir1,"1234");
        
        Cargo car1 = new Cargo("Gerente de IT", 'M', cofisa, 45000);
        
        Estudiante es1 = new Estudiante("20012002049", "Gerardo", "Ing. Industrial",
                                        19, dir2, car1);
        
        es1.imprimir();
        
    }
}
