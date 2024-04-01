package com.miapp.biblioteca.ui;

import java.util.Scanner;

public class MenuLibro {
    public static void Menu() {
        System.out.println("menu de crud libro");
        System.out.println("para ingresar un libro presione C");
        System.out.println("para ver los datos de un libro presione R");
        System.out.println("para actualizar presione U");
        System.out.println("para buscar un libro por ISBN presione B");
        char crear = 'c';
        char leer = 'r';
        char borrar = 'd';
        char actualizar = 'u';
        char buscar = 'b';
        try {

            Scanner scanner = new Scanner(System.in);
            char caracterIngresado = scanner.next().charAt(0);
            char letra = Character.toLowerCase(caracterIngresado);
            switch (letra) {
                case 'c':
                    System.out.println("crear");
                    break;
                case 'r':
                    System.out.println("leer");
                    break;
                case 'd':
                    System.out.println("actulizar");
                    break;
                case 'b':
                    System.out.println("buscar");
                    break;

            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}