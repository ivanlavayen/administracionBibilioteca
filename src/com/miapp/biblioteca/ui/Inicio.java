package com.miapp.biblioteca.ui;

import java.util.Scanner;

public class Inicio {
    public static void menuInicio() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("MENU INICIO");
            char libro = 'l';
            char usuario = 'u';
            char salida= 's';
            System.out.println("1- Para  acceder a menu Biblioteca presione L");
            System.out.println("2- Para acceder a menu usuario presione U");
            System.out.println("3- Para salir del sistema presione S");
            char caracterIngresado1 = scanner.next().charAt(0);
            char letra1 = Character.toLowerCase(caracterIngresado1);

            if (letra1 == libro) {
                MenuLibro.Menu();

            }
            else if (letra1 == usuario) {
                MenuUsuario.Menu();
            }
            else if(letra1==salida){
                System.out.println("Salida exitosa");
                System.exit(0);
            }

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }
}
