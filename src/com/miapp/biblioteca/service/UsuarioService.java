package com.miapp.biblioteca.service;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;

import java.util.ArrayList;
public class UsuarioService {
   public static ArrayList<Usuario> usuarios=new ArrayList<>();
   // private static ArrayList<Usuario>prestados=new ArrayList<>();
    public UsuarioService(ArrayList<Usuario> usuarios) {
        UsuarioService.usuarios = usuarios;
    }

    //metodos crud

    //crear usuario CREATE

    public static void crearUsuario(String nombre, String id) {
        Usuario usuarioNuevo = new Usuario(nombre, id);
        usuarios.add(usuarioNuevo);
    }

    // leer usuario READ  obtengo todos los usuarios
    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    //actualizar usuario UPDATE
    //actualizacion buscando por id

    public static boolean actualizarUsuarioPorId(String nuevoNombre, String id) {
        //creo una variable de tipo boolean para devolver si el cambio se efectuo. Si
        //el cambio se efecuto cambiorealizado se vuelve true. Este valor lo toma el case 'u' en
        //menuUsuario para informar si se efectuo el cambio o no.
        boolean cambioRealizado = false;
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                usuario.setNombre(nuevoNombre);
                cambioRealizado = true;
                break;  // Salimos del bucle tras encontrar coincidencia
            }
        }
        return cambioRealizado;
    }



    //actualizacion buscando por nombre
    public void actualizarUsuarioPorNombre(String nombre, String nuevoId) {

        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombre)) {
                usuario.setId(nuevoId);
            }
        }

    }

    //borrar un usuario DELETE
    //busqueda por id
    public static boolean borrarUsuarioPorId(String id) {
       return usuarios.removeIf(usuario -> usuario.getId().equals(id));

    }

    //borrar un usuario DELETE
    //busqueda por nombre
   // metodo boolean para que me devuelva true o false e informar en el menu si se efectuo la eliminacion
    public static boolean borrarUsuarioPorNombre(String nombre) {
        return usuarios.removeIf(usuario -> usuario.getNombre().equals(nombre));
    }

    //busqueda de usuario por id
    public static String buscarUsuarioPorId(String id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return id;

            }
        }
        return null;
    }

    //busqueda usuario por nombre
    public Usuario buscarUsuarioPorNombre(String nombre) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombre)) {
                return usuario;

            }
        }
        return null;
    }

    //metodo para prestar libro a ususario
    public static boolean prestarLibro(Usuario usuario, Libro libro) {
        boolean prestar = false;
        //verifico disponibilidad
        if (libro.isDisponible()) {
            usuario.getLibrosPrestados().add(libro);
            libro.setDisponible(false);
            prestar=true;
             }
        return prestar;
    }


    //ususario devuelve libro

    public static boolean devolverLibro(Usuario usuario, Libro libro) {
        boolean devolver=false;
        if (usuario.getLibrosPrestados().contains(libro)) {
            usuario.getLibrosPrestados().remove(libro);
            libro.setDisponible(true);

        }
        devolver=true;
        return devolver;
    }

}
