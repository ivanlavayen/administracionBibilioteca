package com.miapp.biblioteca.ui;

import com.miapp.biblioteca.service.LibroService;

import java.util.Scanner;

import static com.miapp.biblioteca.ui.Inicio.menuInicio;


public class MenuLibro {
    public static void Menu() {
        System.out.println("MENU BIBLIOTECA");
        System.out.println("Para ingresar un libro presione C");
        System.out.println("Para ver los datos de un libro presione R");
        System.out.println("Para actualizar presione U");
        System.out.println("Para borrar un libro  presione D");
        System.out.println("Para buscar un libro por ISBN presione B");
        System.out.println("Para ir a Inicio presione I");

        Scanner scanner = new Scanner(System.in);
        try {
            char caracterIngresado = scanner.next().charAt(0);
            char letra = Character.toLowerCase(caracterIngresado);
            switch (letra) {
                //creacion de libros
                case 'c':

                        System.out.println("ingrese titulo: ");
                        String titulo = scanner.next();

                        System.out.println("ingrese autor: ");
                        String autor = scanner.next();

                        System.out.println(("ingrese ISBN"));
                        String isbn = scanner.next();

                        System.out.println(("ingrese genero"));
                        String genero = scanner.next();

                        LibroService.crearLibro(titulo, autor, isbn, genero);
                        System.out.println("Se ha agregador el libro "+  titulo + " a la biblioteca");

                        break;



                //obtengo la lista de libros de la biblioteca
                case 'r':

                    System.out.println(LibroService.getBiblioteca());
                    break;

                //para modificar un libro por isbn, si el isbn ingresado es = al
                // que tiene actualmente el libro hace la modificacion
                case 'u':
                    System.out.println("ingrese titulo: ");
                    String nuevoTitulo = scanner.next();

                    System.out.println("ingrese autor: ");
                    String nuevoAutor = scanner.next();

                    System.out.println("ingrese ISBN: ");
                    String nuevoIsbn = scanner.next();

                    System.out.println(("ingrese genero"));
                    String nuevoGenero = scanner.next();

                    if(LibroService.actualizarLibro( nuevoTitulo,  nuevoAutor, nuevoIsbn,  nuevoGenero)){
                        System.out.println("Se ha actulizado el libro correctamente");
                    }
                    else{
                        System.out.println("No existe el ISBN ingresado. No se realizo ningun cambio");
                    }

                    break;

                //para borrar un libro de la biblioteca dado un ISBN
                case 'd':
                    System.out.println("ingrese titulo: ");
                    String eliminarTitulo = scanner.next();

                    System.out.println("ingrese autor: ");
                    String eliminarAutor = scanner.next();

                    System.out.println("ingrese ISBN: ");
                    String eliminarIsbn = scanner.next();

                    System.out.println(("ingrese genero"));
                    String eliminarGenero = scanner.next();

                    if(LibroService.eliminarLibro( eliminarTitulo,eliminarAutor,eliminarIsbn,eliminarGenero)){
                        System.out.println("el libro "+eliminarTitulo+" ha sido eliminado de la biblioteca");
                    }
                    else{
                        System.out.println("Ha ingresado un dato incorrecto, no se elimnio ningun libro");
                    }

                    break;

                /* para buscar un libro por ISBN */
                case 'b':
                    System.out.println("ingrese ISBN del libro a buscar");
                    String codigo= scanner.next();
                    LibroService.buscarLibroUnico(codigo);

                    break;

                case 'i':
                    menuInicio();


                default:
                    System.out.println("no ingreso una opcion valida");

            }
            Menu();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}