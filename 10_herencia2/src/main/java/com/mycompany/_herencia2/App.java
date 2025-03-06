package com.mycompany._herencia2;
import java.util.Calendar;
import java.util.LinkedList;
public class App {
    public static void main(String[] args) {
        Author autor1 = new Author("Gerardo", "califik.com", "");
        Calendar f1 = Calendar.getInstance();
        f1.set(2025,0,17);
        
        Document monografia = new Document(autor1, f1, 90000, "Monografia",
                215125236, "pdf", f1);
        monografia.print();
        
        Audio c1 = new Audio("Def Leppard", "Hysteria", 1987, 4, autor1,
                300, "Love Bites", 458260123, "mp3", f1);
        c1.print();
        
        String[] idiomas = {"Ingles","Español","Chino"};
        LinkedList subtitulos = new LinkedList();
        subtitulos.push( new Subtitle("Ingles", autor1));
        subtitulos.push( new Subtitle("Español", autor1));
        subtitulos.push( new Subtitle("Chino", autor1));
        subtitulos.push( new Subtitle("Aleman", autor1));
        
        Video v1 = new Video("h264", 6, idiomas, subtitulos,
                autor1, 5400, "Flow", 1450451125, "mp4", f1);
        v1.print();
    }
}
