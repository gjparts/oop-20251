package com.mycompany._asociacion_de_clases_factura_multiplicidad;
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
        
        //coleccion de productos para fac1
        Producto arreglo1[] = { pp03, pp02 };
        Factura fac1 = new Factura(1, fecha1, cli2, arreglo1);
        fac1.imprimir();
        
        Producto arreglo2[] = {pp05, pp04, pp03, pp04};
        Factura fac2 = new Factura(2, Calendar.getInstance(), null, arreglo2);
        fac2.imprimir();
        
        Producto arreglo3[] = {pp03,pp03,pp03,pp03,pp01,pp01,pp02,pp02,pp04};
        Factura fac3 = new Factura(3, Calendar.getInstance(), null, arreglo3);
        fac3.imprimir();
        
        //se puede instanciar el arreglo sin variable directamente en el parametro del constructor:
        Factura fac4 = new Factura(4, Calendar.getInstance(), cli2, new Producto[]{pp05,pp05,pp05,pp04});
        fac4.imprimir();
    }
}
