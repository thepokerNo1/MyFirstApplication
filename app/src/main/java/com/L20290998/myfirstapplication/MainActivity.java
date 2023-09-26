package com.L20290998.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.L20290998.myfirstapplication.usuario.DashBoardUsuario;
import com.L20290998.myfirstapplication.usuario.repository.UsuarioRepository;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private HashMap <String,String> registeredUsers =new HashMap<String,String>();
    UsuarioRepository ur = UsuarioRepository.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        registeredUsers.put("Luis","perro");
        registeredUsers.put("Pedro","123");
        registeredUsers.put("Ana","555");*/
    }

    private AlertDialog createAlertDialog (String title,String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //Los mutables son aquellos que cuando accedemos son los que podemos editar su valor, los inmutables son los que no nos dejan cambiar su valor, string is inmutable
        builder.setTitle(title)
                .setMessage(message);


        return builder.create();
    }


    public void onBtnIngresarTap(View view){
        /*
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog dialog = builder.create();*/

        EditText etUsuario = findViewById(R.id.etUsuario);
        EditText etPass = findViewById(R.id.etPass);






        String user,pass;
        user = etUsuario.getText().toString();
        pass = etPass.getText().toString();

        if(!ur.getRegisteredUsers().containsKey(user)){

            /*dialog.setTitle("Atencion");
            dialog.setMessage("El usuario no es correcto");
            dialog.show();*/

            this.createAlertDialog("Atencion","Usuario no registrado").show(); //refactorizar

            return;

        }

        if(!ur.getRegisteredUsers().get(user).containsKey(pass)){
/*
            dialog.setTitle("Atencion");
            dialog.setMessage("La contraseña no es correcta");
            dialog.show();*/

            this.createAlertDialog("Atencion", "La contrasena no coincide").show();

            return;

        }

        //user=user.toUpperCase();
        //dialog.setTitle("Felicidade has iniciado sesion");
        //dialog.setMessage("Miguel Mendoza");
        //dialog.setMessage(String.format("Datos ingresados\nUsuario: %s\nPassword:%s",user,pass));
        //dialog.show();
        String message = ("Felicidades ha iniciado");
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

        //Intent i = new Intent(.DashBoardUsuario.class);
        //Cuando algo falle poner this
        Intent i = new Intent(this,DashBoardUsuario.class);

        i.putExtra("Usuario",user);
        i.putExtra("pass",pass);
        startActivity(i);


        //Se va mostrar informacion de el usuarion en el dashboard usuario


    }
}