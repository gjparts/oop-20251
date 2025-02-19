package com.mycompany._asociacion_de_clases_factura;
import java.util.Calendar;
public class App {

    public static void main(String[] args) {
        Cliente cli1 = new Cliente("Filomeno Colinas", 12345678, 99991111, "");
        Cliente cli2 = new Cliente("Estevancito Maravilla", 987654321, 33332222, "");
        
        CategoriaProducto cat1 = new CategoriaProducto("Snacks", "17");
        CategoriaProducto cat2 = new CategoriaProducto("Refrescos", "A5");
        
        Producto pp01 = new Producto("Taqueritos Fuego", cat1, 25);
        Producto pp02 = new Producto("Zambos con chile", cat1, 24);
        Producto pp03 = new Producto("Coca Cola 3L", cat2, 65);
        Producto pp04 = new Producto("Sprite 2L", cat2, 28);
        Producto pp05 = new Producto("Manzana", new CategoriaProducto("Frutas", "B1"), 8);
        
        Calendar fecha1 = Calendar.getInstance();
        fecha1.set(2025, 1, 14);
        
        Factura fac1 = new Factura(1, fecha1, cli2, pp03);
        fac1.producto4 = pp02;
        fac1.imprimir();
        
        Factura fac2 = new Factura(2, Calendar.getInstance(), null, pp05);
        fac2.producto2 = pp04;
        fac2.producto3 = pp03;
        fac2.producto4 = pp04;
        fac2.imprimir();
    }
}
