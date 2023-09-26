package com.L20290998.myfirstapplication.usuario.repository;

import com.L20290998.myfirstapplication.usuario.model.Usuario;

import java.util.HashMap;

public class UsuarioRepository {
    private static UsuarioRepository repository = null;

    private HashMap<String,HashMap<String, Usuario>> registeredUsers;
    private UsuarioRepository(){
        Usuario u1 = new Usuario("gato", "1234", "alex", "21", "alex@alex.com");
        Usuario u2 = new Usuario("raton", "1234", "nath", "21", "nath@nath.com");
        Usuario u3 = new Usuario("perro", "1234", "ama", "21", "ama@ama.com");

        this.registeredUsers = new HashMap<String,HashMap<String,Usuario> >();

        registeredUsers.put(u1.getUsuario(),new HashMap<String,Usuario>());
        registeredUsers.get(u1.getUsuario()).put(u1.getPass(),u1);
        registeredUsers.get(u1.getUsuario()).put(u1.getEdad(),u1);
        registeredUsers.get(u1.getUsuario()).put(u1.getEmail(),u1);
        registeredUsers.get(u1.getUsuario()).put(u1.getNombre(),u1);


        registeredUsers.put(u2.getUsuario(),new HashMap<String,Usuario>());
        registeredUsers.get(u2.getUsuario()).put(u2.getPass(),u2);
        registeredUsers.get(u2.getUsuario()).put(u2.getEdad(),u2);
        registeredUsers.get(u2.getUsuario()).put(u2.getEmail(),u2);
        registeredUsers.get(u2.getUsuario()).put(u2.getNombre(),u2);

        registeredUsers.put(u3.getUsuario(),new HashMap<String,Usuario>());
        registeredUsers.get(u3.getUsuario()).put(u3.getPass(),u3);
        registeredUsers.get(u3.getUsuario()).put(u3.getEdad(),u3);
        registeredUsers.get(u3.getUsuario()).put(u3.getEmail(),u3);
        registeredUsers.get(u3.getUsuario()).put(u3.getNombre(),u3);
        //Copiarlo 3 veces con cada usuario


    };

    public static UsuarioRepository getInstance() {
        if (repository == null) {
            repository = new UsuarioRepository();
        }
        return repository;
    }
    public HashMap<String, HashMap<String, Usuario>> getRegisteredUsers() {
        return registeredUsers;
    }
}
