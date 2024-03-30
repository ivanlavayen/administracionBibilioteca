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

      //1) Crear libros

    public void crearLibro(String titulo, String autor, String ISBN, String genero){
        Libro nuevoLibro=new Libro( titulo,  autor,  ISBN,  genero);
        biblioteca.add(nuevoLibro);
    }

    public  ArrayList<Libro> getBiblioteca(){
        return biblioteca;
    }

}

