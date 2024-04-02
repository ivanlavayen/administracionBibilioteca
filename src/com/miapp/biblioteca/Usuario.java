package com.miapp.biblioteca;


import java.util.ArrayList;

public class Usuario {
      private String nombre;
      private String id;
      private ArrayList<Libro> librosPrestados;


      //constructor
       public Usuario(String nombre, String id) {
           this.nombre = nombre;
           this.id = id;
           //this.librosPrestados=new ArrayList<>();
       }

       //Getter y Setter
       public String getNombre() {
           return nombre;
       }

       public void setNombre(String nombre) {
           this.nombre = nombre;
       }

       public String getId() {
           return id;
       }

       public void setId(String id) {
           this.id = id;
       }

       public ArrayList <Libro> getLibrosPrestados(){
           return librosPrestados;
       }



       @Override
           public String toString() {
               return "Usuario{" +
                       "nombre='" + nombre + '\'' +
                       ", id='" + id + '\'' +
                       '}';
           }
   }


