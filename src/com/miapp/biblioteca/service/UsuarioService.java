package com.miapp.biblioteca.service;

import com.miapp.biblioteca.Usuario;

import java.util.ArrayList;

public class UsuarioService {
    private ArrayList<Usuario> usuarios;//defino un array list de ususarios

    public UsuarioService(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    //metodos para el CRUD}

    //crear usuario CREATE

    public void crearUsuario(String nombre, String id){
        Usuario nuevoUsuario=new Usuario( nombre,  id);
        usuarios.add(nuevoUsuario);
    }


    //
    //modificar usuario UPDATE

    public void modificarUsuario(String nuevoNombre, String id){
        for(Usuario usuario:usuarios){
            if(usuario.getId().equals(id) ){
                usuario.setNombre(nuevoNombre);
            }
        }
    }

}
