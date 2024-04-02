package com.miapp.biblioteca.service;

import com.miapp.biblioteca.Libro;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
//public class LibroService {
//    private static ArrayList<Libro> biblioteca = new ArrayList<>(); // Inicializar la variable como un atributo estático
//
//    public static void crearLibro(String titulo, String autor, String ISBN, String genero) {
//        Libro nuevoLibro = new Libro(titulo, autor, ISBN, genero);
//        biblioteca.add(nuevoLibro);
//    }
//}
public class LibroService {

    //arreglo con la coleccion de libros
    private static ArrayList<Libro> biblioteca=new ArrayList<>();

    public LibroService(ArrayList<Libro> biblioteca) {
        this.biblioteca = biblioteca;
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
    public void actualizarLibro(String nuevoTitulo, String nuevoAutor, String ISBN, String nuevoGenero) {
        //recorro la biblioteca buscando un isbn ==
        for(Libro libro:biblioteca){
            if(libro.getISBN().equals(ISBN)){
                libro.setTitulo(nuevoTitulo);
                libro.setAutor(nuevoAutor);
                libro.setGenero(nuevoGenero);
            }
        }
    }

    //4)Borrar libro  DELETE
    public void eliminarLibro(String titulo, String autor, String ISBN, String genero) {
        biblioteca.removeIf(libro -> libro.getISBN().equals(ISBN));
        /*tambien se puede hacer con un for de la siguiente manera:
        for(Libro libro:biblioteca){
            if(libro.getISBN().equals(ISBN)){
                biblioteca.remove(libro);
            }
         */
    }
    //buscar un libro por ISBN public Libro buscarLibroUnico(String ISBN){
    //        for(Libro libro:biblioteca){
    //            if(libro.getISBN().equals(ISBN)){
    //                return libro;
    //
    //            }
    //        }
    //        return null;
    //    }

}

