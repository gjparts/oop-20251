
package com.mycompany._polimorfismo1;
public class App {

    public static void main(String[] args) {
        Animal a1 = new Animal("Jirafa","Mamifero",4,true);
        a1.imprimir();
        a1.hablar();
        
        Gato g1 = new Gato("Tinieblas", true, true);
        g1.hablar();
        g1.imprimir();
        g1.ronronear();
        
        Perro p1 = new Perro("Firulais", "Mixto", true);
        p1.hablar();
        p1.imprimir();
        p1.jugar();
        
        /*Tambien es posible hacer polimorfismo al momento de inicializar
        un objeto*/
        Animal a2 = new Animal("Elefante", "Paquidermo", 4, true){
            //aqui esta dentro de la definicion del objeto
            @Override
            public void hablar(){
                System.out.println("Hace sonidos de elefante.");
            }
        };
        a2.hablar();
        a2.imprimir();
        //lo anterior no afecta a la clase Animal solo al objeto a2
        
        Animal a3 = new Animal("Loro", "Ave", 2, true);
        a3.hablar();
        a3.imprimir();
    }
}
