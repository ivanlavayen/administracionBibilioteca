package com.miapp.biblioteca.ui;

import com.miapp.biblioteca.service.LibroService;

import java.util.Scanner;


import static com.miapp.biblioteca.ui.Inicio.menuInicio;


public class MenuLibro {
    public static void Menu() {
        System.out.println("MENU BIBLIOTECA");
        System.out.println("1-Para ingresar un libro ");
        System.out.println("2-Para ver los datos de un libro ");
        System.out.println("3-Para modificar un libro");
        System.out.println("4-Para borrar un libro");
        System.out.println("5-Para buscar un libro por ISBN ");
        System.out.println("6-Para ir a Inicio ");

        Scanner scanner = new Scanner(System.in);

        try {
            char caracterIngresado = scanner.next().charAt(0);
            char letra = Character.toLowerCase(caracterIngresado);
            switch (letra) {
                //creacion de libros
                case '1':
                    System.out.println("Ingrese título: ");
                    String tituloIngresado = "";
                    while (tituloIngresado.isEmpty()) {

                        tituloIngresado = scanner.nextLine();

                    }
                    String titulo=tituloIngresado.toUpperCase();

                    System.out.println("Ingrese autor: ");
                    String autor = scanner.nextLine();

                    System.out.println("Ingrese ISBN: ");
                    String isbn = scanner.next();

                    System.out.println("Ingrese genero: ");
                    String genero = scanner.next();

                        LibroService.crearLibro(titulo, autor, isbn, genero);
                        System.out.println("Se ha agregado el libro "+  titulo + " a la biblioteca");

                        break;



                //obtengo la lista de libros de la biblioteca
                case '2':

                    System.out.println(LibroService.getBiblioteca());
                    break;

                //para modificar un libro por isbn, si el isbn ingresado es = al
                // que tiene actualmente el libro hace la modificacion
                case '3':
                    System.out.println("Ingrese título: ");
                    String nuevoTituloIngresado = "";
                    while (nuevoTituloIngresado.isEmpty()) {
                        nuevoTituloIngresado = scanner.nextLine();
                    }
                    String nuevoTitulo=nuevoTituloIngresado.toUpperCase();
                    System.out.println("Ingrese autor: ");
                    String nuevoAutor = scanner.nextLine();

                    System.out.println("Ingrese ISBN: ");
                    String nuevoIsbn= scanner.next();

                    System.out.println("Ingrese genero: ");
                    String nuevoGenero = scanner.next();


                    if(LibroService.actualizarLibro( nuevoTitulo,  nuevoAutor, nuevoIsbn,  nuevoGenero)){
                        System.out.println("Se ha actulizado el libro correctamente");
                    }
                    else{
                        System.out.println("No existe el ISBN ingresado. No se realizo ningun cambio");
                    }

                    break;

                //para borrar un libro de la biblioteca dado un ISBN
                case '4':
                    System.out.println("Ingrese título: ");
                    String eliminarTituloIngresado = "";
                    while (eliminarTituloIngresado.isEmpty()) {

                        eliminarTituloIngresado = scanner.nextLine();
                    }
                    String eliminarTitulo=eliminarTituloIngresado.toUpperCase();
                    System.out.println("Ingrese autor: ");
                    String eliminarAutor = scanner.nextLine();

                    System.out.println("Ingrese ISBN: ");
                    String eliminarIsbn = scanner.next();

                    System.out.println("Ingrese genero: ");
                    String eliminarGenero = scanner.next();


                    if(LibroService.eliminarLibro( eliminarTitulo,eliminarAutor,eliminarIsbn,eliminarGenero)){
                        System.out.println("el libro "+eliminarTitulo+" ha sido eliminado de la biblioteca");
                    }
                    else{
                        System.out.println("Ha ingresado un dato incorrecto, no se elimino ningun libro");
                    }

                    break;

                /* para buscar un libro por ISBN */
                case '5':
                    System.out.println("ingrese ISBN del libro a buscar");
                    String codigo= scanner.next();
                    LibroService.buscarLibroUnico(codigo);

                    break;

                case '6':
                    menuInicio();


                default:
                    System.out.println("No ingreso una opcion valida");

            }
            Menu();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}