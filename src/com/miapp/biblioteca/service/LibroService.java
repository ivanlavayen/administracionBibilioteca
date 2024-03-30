package com.miapp.biblioteca.service;

import com.miapp.biblioteca.Libro;

import java.util.ArrayList;

public class LibroService {
    //arreglo con la coleccion de libros
    private ArrayList<Libro> biblioteca;

    public LibroService(ArrayList<Libro> biblioteca) {
        this.biblioteca = biblioteca;
    }
    //metodos para trabajar con los libros de la biblioteca  CRUD

    //1) Crear libros   CREAT

    public void crearLibro(String titulo, String autor, String ISBN, String genero) {
        Libro nuevoLibro = new Libro(titulo, autor, ISBN, genero);
        biblioteca.add(nuevoLibro);
    }

    //2)listar libros   READ
    public ArrayList<Libro> getBiblioteca() {
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

}

