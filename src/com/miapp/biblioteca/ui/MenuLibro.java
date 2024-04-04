package com.miapp.biblioteca.ui;

import com.miapp.biblioteca.service.LibroService;
import com.miapp.biblioteca.service.UsuarioService;

import java.util.Scanner;

public class MenuLibro {
    public static void Menu() {
        System.out.println("MENU BIBLIOTECA");
        System.out.println("para ingresar un libro presione C");
        System.out.println("para ver los datos de un libro presione R");
        System.out.println("para actualizar presione U");
        System.out.println("para borrar un libro  presione D");
        System.out.println("para buscar un libro por ISBN presione B");
        char crear = 'c';
        char leer = 'r';
        char actualizar = 'u';
        char borrar = 'd';
        char buscar = 'b';
        Scanner scanner = new Scanner(System.in);
        try {
            char caracterIngresado = scanner.next().charAt(0);
            char letra = Character.toLowerCase(caracterIngresado);
            switch (letra) {
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




                case 'r':

                    System.out.println(LibroService.getBiblioteca());
                    break;

                case 'u':
                    System.out.println("actulizar");
                    break;
                case 'd':
                    System.out.println("borrar");
                    break;
                case 'b':
                    System.out.println("buscar por id");

                default:
                    System.out.println("no ingreso una opcion valida");

            }
            Menu();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}