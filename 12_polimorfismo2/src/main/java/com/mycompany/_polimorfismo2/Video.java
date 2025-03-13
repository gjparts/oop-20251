package com.mycompany._polimorfismo2;
import java.util.Calendar;
import java.util.LinkedList;
public class Video extends Media {
    //attributes
    public String codec;
    public int chapters;
    public String[] audio;
    public LinkedList<Subtitle> subtitles;
    //constructor
    public Video(String codec, int chapters, String[] audio,
            LinkedList<Subtitle> subtitles, Author author,
            int duration, String name, long size,
            String extension, Calendar creationDate) {
        super(author, duration, name, size, extension, creationDate);
        this.codec = codec;
        this.chapters = chapters;
        this.audio = audio;
        this.subtitles = subtitles;
    }
    //methods
    @Override
    public void print() {
        super.print(); //Override parcial
        System.out.println("Codec: "+this.codec);
        System.out.println("Chapters: "+this.chapters);
        //coleccion de pistas de audio
        if( this.audio != null ){
            if( this.audio.length > 0 ){
                System.out.println("Audio tracks:");
                for (int i = 0; i < this.audio.length; i++) {
                    if( this.audio[i] != null )
                        System.out.println("\t* "+this.audio[i]);
                }
            }
        }
        //coleccion de subtitilos
        if( this.subtitles != null ){
            if( this.subtitles.size() > 0 ){
                System.out.println("Subtitles:");
                for (int i = 0; i < this.subtitles.size(); i++) {
                    if( this.subtitles.get(i) != null ){
                        System.out.print("\t* "+this.subtitles.get(i).language);
                        System.out.println(", "+this.subtitles.get(i).author.name);
                    }
                }
            }
        }
    }
    
}
