package com.miapp.biblioteca.service;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;

import java.util.ArrayList;
public class UsuarioService {
    private ArrayList<Usuario> usuarios;

    public UsuarioService(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    //metodos crud

    //crear usuario CREATE
    public void crearUsuario(String nombre, String id){
        Usuario usuarioNuevo= new Usuario(nombre,id);
        usuarios.add(usuarioNuevo);
    }

    // leer usuario READ  obtengo todos los usuarios
    public ArrayList<Usuario>getUsuarios(){
        return usuarios;
    }

    //actualizar usuario UPDATE
         //actualizacion buscando por id
    public void actualizarUsuarioPorId(String nuevoNombre,String id) {

        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                usuario.setNombre(nuevoNombre);
            }
        }

    }

    //actualizacion buscando por nombre
    public void actualizarUsuarioPorNombre(String nombre,String nuevoId) {

        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombre)) {
                usuario.setId(nuevoId);
            }
        }

    }

    //borrar un usuario DELETE
      //busqueda por id
    public void borrarUsuarioPorId(String id){
        usuarios.removeIf(usuario -> usuario.getId().equals(id));

    }

    //borrar un usuario DELETE
      //busqueda por nombre
    public void borrarUsuarioPorNombre(String nombre){
        usuarios.removeIf(usuario -> usuario.getNombre().equals(nombre));

    }

    //busqueda de usuario por id
    public Usuario buscarUsuarioPorId(String id){
        for(Usuario usuario:usuarios){
            if(usuario.getId().equals(id)){
                return usuario;

            }
        }
        return null;
    }

    //busqueda usuario por nombre
    public Usuario buscarUsuarioPorNombre(String nombre){
        for(Usuario usuario:usuarios){
            if(usuario.getNombre().equals(nombre)){
                return usuario;

            }
        }
        return null;
    }

}
