package com.mycompany._abstraccion2;
public class App {
    public static void main(String[] args) {
        //Figura f1 = new Figura("Paralelogramo");
        
        Rectangulo rr1 = new Rectangulo(4, 5.5);
        System.out.println("Area de rr1: "+rr1.calcularArea());
        System.out.println("Perimetro de rr1: "+rr1.calcularPerimetro());
        
        Circulo c1 = new Circulo(20.3);
        System.out.println("Area de c1: "+c1.calcularArea());
        System.out.println("Perimetro de c1: "+c1.calcularPerimetro());
        
        TrianguloEquilatero t1 = new TrianguloEquilatero(5, 8);
        System.out.println("Area de t1: "+t1.calcularArea());
        System.out.println("Perimetro de t1: "+t1.calcularPerimetro());
        
        Figura cuadrado1 = new Figura("Cuadrado"){
            public double lado = 6; //es posible crearle atributos al objeto cuadrado1 desde aqui
                                //este atributo no esta disponible desde un ambito externo
                                //aunque sea publico. (A)
                                //por eso se le debe poner le valor desde aqui en este caso 6
            @Override
            public double calcularArea() {
                return Math.pow(this.lado, 2);
            }
            @Override
            public double calcularPerimetro() {
                return 4*this.lado;
            }
        };
        //cuadrado1.lado = 5; (A)
        System.out.println("Area de cuadrado1: "+cuadrado1.calcularArea());
        System.out.println("Perimetro de cuadrado1: "+cuadrado1.calcularPerimetro());
    }
}
