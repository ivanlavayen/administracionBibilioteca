package com.miapp.biblioteca.ui;

import com.miapp.biblioteca.service.LibroService;
import com.miapp.biblioteca.service.UsuarioService;

import java.util.Scanner;


import static com.miapp.biblioteca.ui.Inicio.menuInicio;

public class MenuUsuario {


    public static void Menu() {
        System.out.println("MENU USUARIO");
        System.out.println("1-Para ingresar un nuevo usuario presione C");
        System.out.println("2-Para ver los datos de un usuario presione R");
        System.out.println("3-Para actualizar usuario U");
        System.out.println("4-para eliminar un usuario por ID presione D");
        System.out.println("5-para eliminar un usuario por nombre presion N");
        System.out.println("6-Para buscar un usuario por ID presione B");
        System.out.println("7-Para volver a Inicio presione I");
        try {
            Scanner scanner = new Scanner(System.in);
            char caracterIngresado = scanner.next().charAt(0);
            char letra = Character.toLowerCase(caracterIngresado);
            Scanner scanner1 = new Scanner(System.in);
            switch (letra) {
                case 'c'://carga de un nuevo usuario
                    System.out.println("Ingrese el nombre del usuario: ");
                    String nombre = scanner1.next();

                    System.out.println("Ingrese el ID del usuario: ");
                    String id = scanner.next();

                    UsuarioService.crearUsuario(nombre, id);
                    System.out.println("Se ha cargado al sistema el usuario "+nombre);
                    break;

                case 'r': //lectura de la lista de usuarios
                    System.out.println("LISTA DE USUARIOS");
                    System.out.println(UsuarioService.getUsuarios());
                    break;

                case 'u'://actualizar un usuario dado el id
                    System.out.println("Ingrese el nuevo nombre");
                    String nuevoNombre= scanner1.next();
                    System.out.println("Ingrese el ID del usuario ");
                    String IdIngresado=scanner1.next();
                   if(UsuarioService.actualizarUsuarioPorId(nuevoNombre, IdIngresado)){
                       System.out.println("El usuario se actualizo correctamente");

                   }
                   else {
                       System.out.println("no existe el usuario");
                   }
                    break;

                case 'd'://eliminar un usuario dado un id
                    System.out.println("Ingrese el id del Usuario a eliminar");
                    String usuarioEliminar=scanner1.next();
                    if(UsuarioService.borrarUsuarioPorId(usuarioEliminar)){
                        System.out.println("El usuario con el Id "+usuarioEliminar+" ha sido eliminado");
                    }
                    else{
                        System.out.println("no existe el ID ingresado");
                    }
                    break;


                case 'n'://eliminar un usario por el nombre
                    System.out.println("Ingrese el nombre del Usuario a eliminar");
                    String nombreEliminar=scanner1.next();
                   if( UsuarioService.borrarUsuarioPorNombre(nombreEliminar)){
                       System.out.println(nombreEliminar+ " ha sido eliminado");
                   }
                   else{
                       System.out.println("No existe el usuario "+nombreEliminar);
                   }


                    break;

                case 'b'://buscar usuario por Id
                    System.out.println("ingrese Id del Usuario");
                    String idUsuario= scanner.next();
                    UsuarioService.buscarUsuarioPorId(idUsuario);
                    break;

                case 'i':
                    menuInicio();

            }
            Menu();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}