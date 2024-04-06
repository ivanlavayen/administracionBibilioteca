package com.miapp.biblioteca.service;

import com.miapp.biblioteca.Libro;

import java.util.ArrayList;

public class LibroService {

    //arreglo con la coleccion de libros
    private static ArrayList<Libro> biblioteca=new ArrayList<>();

    public LibroService(ArrayList<Libro> biblioteca) {
        LibroService.biblioteca = biblioteca;
    }
    //metodos para trabajar con los libros de la biblioteca  CRUD

    //1) Crear libros   CREAT
    public static void crearLibro(String titulo, String autor, String ISBN, String genero) {
        Libro nuevoLibro = new Libro(titulo, autor, ISBN, genero);
        biblioteca.add(nuevoLibro);
    }

    //2)listar libros   READ
    public static ArrayList<Libro> getBiblioteca() {
        return biblioteca;
    }


    //3)actualizar libros  UPDATE
    public static boolean actualizarLibro(String nuevoTitulo, String nuevoAutor, String ISBN, String nuevoGenero) {
        //recorro la biblioteca buscando un isbn ==
        boolean cambioRealizado=false;
        for(Libro libro:biblioteca){
            if(libro.getISBN().equals(ISBN)){
                libro.setTitulo(nuevoTitulo);
                libro.setAutor(nuevoAutor);
                libro.setGenero(nuevoGenero);
                cambioRealizado=true;
            }
        }
        return cambioRealizado;
    }

    //4)Borrar libro  DELETE
    public static boolean eliminarLibro(String titulo, String autor, String ISBN, String genero) {
        return biblioteca.removeIf(libro -> libro.getISBN().equals(ISBN)
                                         &&(libro.getAutor().equals(autor)
                                         &&(libro.getTitulo().equals(titulo))));
        //para eliminar solicito que sea igual al menos el isbn,autor y titulo.
        //si se elimino el libro devuelve true, si no false
        /*tambien se puede hacer con un for de la siguiente manera:
        for(Libro libro:biblioteca){
            if(libro.getISBN().equals(ISBN)){
                biblioteca.remove(libro);
            }
         */

    }
    //buscar un libro por ISBN
     public static void buscarLibroUnico(String ISBN){
          for(Libro libro:biblioteca){
                if(libro.getISBN().equals(ISBN)){
                    return;
               }
          }
     }

    //verificar disponibilidad
    public boolean estaDisponible(Libro libro){
           return libro.isDisponible();
    }

}

