package com.miapp.biblioteca;

import com.miapp.biblioteca.service.UsuarioService;
import com.miapp.biblioteca.ui.MenuLibro;
import com.miapp.biblioteca.ui.MenuUsuario;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("BIENVENIDO BOOKMANAGER");

        try {
            System.out.println("Si desea continuar presione la letra S, para salir presione E");
            char ingresar = 's';
            char salir = 'e';

            Scanner scanner = new Scanner(System.in);
            char caracterIngresado = scanner.next().charAt(0);
            char letra = Character.toLowerCase(caracterIngresado);

            if (letra == ingresar) {
                System.out.println("menu de opciones");
                char libro = 'b';
                char usuario = 'u';
                System.out.println("para  CRUD de libro presione B");
                System.out.println(("para CRUD de usuario presione U"));
                Scanner scanner1= new Scanner(System.in);
                char caracterIngresado1 = scanner.next().charAt(0);
                char letra1 = Character.toLowerCase(caracterIngresado1);





                if (letra1 == libro) {
                      MenuLibro.Menu();
                }
                if (letra1 == usuario) {
                    MenuUsuario.Menu();
                }
            }

            if (letra == salir) {
                System.out.println("gracias por elegirnos");


            }

        }
        catch (Exception e) {

            throw new RuntimeException(e);
        }
    }
}