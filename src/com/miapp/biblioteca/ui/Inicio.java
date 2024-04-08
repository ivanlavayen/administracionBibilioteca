package com.miapp.biblioteca.ui;

import java.util.Scanner;

public class Inicio {
    public static void menuInicio() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("MENU INICIO");
            char libro = '1';
            char usuario = '2';
            char salida= '3';
            System.out.println("1- Para  acceder a menu Biblioteca  ");
            System.out.println("2- Para acceder a menu Usuario  ");
            System.out.println("3- Para salir del sistema  ");
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
                System.exit(0);//para terminar el proceso
            }

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }
}
