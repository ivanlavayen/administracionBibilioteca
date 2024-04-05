package com.miapp.biblioteca.service;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;

import java.util.ArrayList;
public class UsuarioService {
    private static ArrayList<Usuario> usuarios=new ArrayList<>();

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
    public static boolean borrarUsuarioPorNombre(String nombre) {
        return usuarios.removeIf(usuario -> usuario.getNombre().equals(nombre));
    }

    //busqueda de usuario por id
    public static void buscarUsuarioPorId(String id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return;

            }
        }
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
    public void prestarLibro(Usuario usuario, Libro libro) {
        //verifico disponibilidad
        if (libro.isDisponible()) {
            usuario.getLibrosPrestados().add(libro);
            libro.setDisponible(false);
        } else {
            System.out.println("no esta el libro");
        }
    }


    //ususario devuelve libro

    public void devolverLibro(Usuario usuario, Libro libro) {
        if (usuario.getLibrosPrestados().contains(libro)) {
            usuario.getLibrosPrestados().remove(libro);
            libro.setDisponible(true);
        } else {
            System.out.println("el usuario no tiene el libro mencionado");
        }
    }
}
