package com.miapp.biblioteca.ui;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;

import com.miapp.biblioteca.service.LibroService;
import com.miapp.biblioteca.service.UsuarioService;

import java.util.Scanner;


import static com.miapp.biblioteca.service.LibroService.*;
import static com.miapp.biblioteca.service.UsuarioService.*;
import static com.miapp.biblioteca.ui.Inicio.menuInicio;

public class MenuUsuario {


    public static void Menu() {
        System.out.println("MENU USUARIO");
        System.out.println("1-Para ingresar un nuevo usuario");
        System.out.println("2-Para ver los datos de un usuario ");
        System.out.println("3-Para modificar usuario");
        System.out.println("4-para eliminar un usuario por ID ");
        System.out.println("5-para eliminar un usuario por nombre ");
        System.out.println("6-Para buscar un usuario por ID ");
        System.out.println("7_Para prestar un libro ");
        System.out.println("8_Para devolver un libro ");
        System.out.println("9-Para volver a Inicio ");
        try {
            Scanner scanner = new Scanner(System.in);
            char opcion = scanner.next().charAt(0);

            Scanner scanner1 = new Scanner(System.in);
            switch (opcion) {
                case '1'://carga de un nuevo usuario
                    System.out.println("Ingrese usuario: ");
                    String nombreIngresado = "";
                    while (nombreIngresado.isEmpty()) {

                        nombreIngresado = scanner.nextLine();
                    }
                    String nombre=nombreIngresado.toUpperCase();//convierto el texto a mayuscula para resaltarlo en el sout


                    System.out.println("Ingrese el ID del usuario: ");
                    String id = scanner.nextLine();

                    UsuarioService.crearUsuario(nombre, id);
                    //informo que se ha cargado el nuevo usuario
                    System.out.println("Se ha cargado al sistema el usuario "+nombre);
                    break;

                case '2': //lectura de la lista de usuarios
                    System.out.println("LISTA DE USUARIOS");
                    System.out.println(UsuarioService.getUsuarios());
                    break;

                case '3'://actualizar un usuario dado el id
                    System.out.println("Ingrese usuario: ");
                    String nuevoNombreIngresado = "";
                    while (nuevoNombreIngresado.isEmpty()) {

                        nuevoNombreIngresado= scanner.nextLine();
                    }
                    String nuevoNombre=nuevoNombreIngresado.toUpperCase();

                    System.out.println("Ingrese el ID del usuario ");
                    String IdIngresado=scanner1.nextLine();
                    //verifico que se ha efectuado el cambio y lo informo
                   if(UsuarioService.actualizarUsuarioPorId(nuevoNombre, IdIngresado)){
                       System.out.println("El usuario se actualizo correctamente");

                   }
                   else {
                       System.out.println("no existe el usuario");
                   }
                    break;

                case '4'://eliminar un usuario dado un id
                    System.out.println("Ingrese el id del Usuario a eliminar");
                    String usuarioEliminar=scanner1.next();

                    if(UsuarioService.borrarUsuarioPorId(usuarioEliminar)){
                        System.out.println("El usuario con el Id "+usuarioEliminar+" ha sido eliminado");
                    }
                    else{
                        System.out.println("no existe el ID ingresado");
                    }
                    break;


                case '5'://eliminar un usario por el nombre
                    System.out.println("Ingrese el nombre del Usuario a eliminar: ");
                    String nombreEliminarIngresado = "";
                    while (nombreEliminarIngresado.isEmpty()) {

                        nombreEliminarIngresado = scanner.nextLine();
                    }
                    String nombreEliminar=nombreEliminarIngresado.toUpperCase();


                    //verifico si el usuario fue eliminado
                   if( UsuarioService.borrarUsuarioPorNombre(nombreEliminar)){
                       System.out.println(nombreEliminar+ " ha sido eliminado");
                   }
                   else{
                       System.out.println("No existe el usuario "+nombreEliminar);
                   }


                    break;

                case '6'://buscar usuario por Id
                    System.out.println("ingrese Id del Usuario");
                    String idUsuario= scanner.next();
                    UsuarioService.buscarUsuarioPorId(idUsuario);
                    break;


                case '7'://prestar libro
                    System.out.println("Ingrese el ID del usuario: ");
                    String usuarioId = scanner.next();

                    System.out.println("Ingrese el título del libro: ");
                    String libroIsbn = scanner.next();

                        Usuario usuarioEncontrado = null;
                        Libro libroEncontrado = null;

                        for (Usuario usuario : usuarios) {//recorro usuarios buscando el ingresado
                            if (usuario.getId().equals(usuarioId)) {
                                usuarioEncontrado = usuario;

                            }
                        }

                        for (Libro libro : biblioteca) {//recorro libro buscando el ingresado
                            if (libro.getISBN().equals(libroIsbn)) { // Llama a getISBN() sobre la instancia 'libro'

                                libroEncontrado = libro;

                            }
                        }
                    if (estaDisponible(libroEncontrado)) {

                        //si se encontro usuario y libro invoco a prestarLibro
                        if (usuarioEncontrado != null) {

                            if (prestarLibro(usuarioEncontrado, libroEncontrado)) {
                                System.out.println("Se ha prestado el libro");
                            }
                            ;
                        } else {
                            System.out.println("Usuario o libro no encontrado.");
                            Menu();
                        }

                    }
                    else{
                        System.out.println("el libro ya se encuentra prestado, no tenemos otro ejemplar");
                    }



                    break;

                case'8'://devolver libro
                    System.out.println("Ingrese el ID del usuario: ");
                    String usuarioDevolver = scanner.next();

                    System.out.println("Ingrese el ID del libro: ");
                    String libroDevolver = scanner.next();

                    Usuario usuarioDevolverEncontrado = null;
                    Libro libroDevolverEncontrado = null;

                    for (Usuario usuario: usuarios ) {//recorro usuarios buscando el ingresado
                        if (usuario.getId().equals(usuarioDevolver)) {
                            usuarioDevolverEncontrado = usuario;

                        }
                    }

                    for (Libro libro : biblioteca) {//recorro libro buscando el ingresado
                        if (libro.getISBN().equals(libroDevolver)) { // Llama a getISBN() sobre la instancia 'libro'
                            libroDevolverEncontrado = libro;

                        }
                    }
                    //si se encontro usuario y libro invoco a prestarLibro
                    if (usuarioDevolverEncontrado != null && libroDevolverEncontrado != null) {

                        prestarLibro(usuarioDevolverEncontrado, libroDevolverEncontrado);
                    } else {
                        System.out.println("Usuario o libro no encontrado.");

                    }
                   if(devolverLibro(usuarioDevolverEncontrado, libroDevolverEncontrado)){
                       System.out.println("El libro ha sido devuelto");
                   }

                    break;

                case '9':
                    menuInicio();
                    break;


            }
            Menu();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}