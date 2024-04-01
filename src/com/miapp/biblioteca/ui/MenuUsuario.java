package com.miapp.biblioteca.ui;

import com.miapp.biblioteca.Usuario;
import com.miapp.biblioteca.service.UsuarioService;

import java.util.Scanner;

public class MenuUsuario {


    public static void Menu() {
        System.out.println("menu de crud USUARIO");
        System.out.println("para ingresar un usuario presione C");
        System.out.println("para ver los datos de un usuario presione R");
        System.out.println("para actualizar usuario U");
        System.out.println("para buscar un usuario por ID presione B");
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
                    Scanner scanner1 = new Scanner(System.in);

                    System.out.println("Ingrese el nombre del usuario: ");
                    String nombre = scanner1.next();

                    System.out.println("Ingrese el ID del usuario: ");
                    String id = scanner.next();
                    UsuarioService.crearUsuario(nombre, id);
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