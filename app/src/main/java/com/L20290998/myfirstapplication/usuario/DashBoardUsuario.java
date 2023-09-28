package com.L20290998.myfirstapplication.usuario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.L20290998.myfirstapplication.R;
import com.L20290998.myfirstapplication.usuario.model.Usuario;
import com.L20290998.myfirstapplication.usuario.repository.UsuarioRepository;

import java.util.Objects;

public class DashBoardUsuario extends AppCompatActivity {
    private UsuarioRepository ur;
    private Usuario userInfo;
    TextView tvUsr;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board_usuario);
        //Aqui creamos la instancia del usuario repository
        ur = UsuarioRepository.getInstance();
        //Esta es la manera en que recibimos info de otro activiti
        String usuario =getIntent().getStringExtra("Usuario");
        String pass =getIntent().getStringExtra("pass");

        //Obtenemos info de el usuario logeado
        userInfo = ur.getRegisteredUsers().get(usuario).get(pass);

        TextView tvUs = findViewById(R.id.tvUsr);
        TextView tvPs = findViewById(R.id.tvPs);
        TextView tvEd = findViewById(R.id.tvEdad);
        TextView tvEmail = findViewById(R.id.tvEmail);
        TextView tvName = findViewById(R.id.tvName);

         tvUs.setText(userInfo.getUsuario());

         tvPs.setText(userInfo.getPass());

         tvEd.setText(userInfo.getEdad());

         tvName.setText(userInfo.getNombre());
         tvEmail.setText(userInfo.getEmail());

         toolbar = findViewById(R.id.toolbar2);

         setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        toolbar = findViewById(R.id.toolbar2);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        ur = UsuarioRepository.getInstance();
        //Esta es la manera en que recibimos info de otro activiti
        String usuario =getIntent().getStringExtra("Usuario");
        String pass =getIntent().getStringExtra("pass");

        //Obtenemos info de el usuario logeado
        userInfo = ur.getRegisteredUsers().get(usuario).get(pass);
        if(item.getItemId() == R.id.miBorrar){
            this.createAlertDialog("Borrar","¿Seguro que deseas borrar?", true).show(); //refactorizar
        } else if (item.getItemId() == R.id.miInfo) {
            String tvUs = userInfo.getUsuario();
            String tvEd = userInfo.getEdad();
            String tvName= userInfo.getNombre();
            String tvEmail = userInfo.getEmail();
            String txt = "Usuario: %s, Edad: %s, Nombre: %s, Email: %s";
            String info = String.format(txt,tvUs,tvEd,tvName,tvEmail);
            this.createAlertDialog("Info",info, false).show(); //refactorizar
            Toast.makeText(this,"info",Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == R.id.miSetting) {
            String message = ("Abriste configuraciones");
            Toast.makeText(this,message,Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    private AlertDialog createAlertDialog (String title, String message,boolean yn) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        //Los mutables son aquellos que cuando accedemos son los que podemos editar su valor, los inmutables son los que no nos dejan cambiar su valor, string is inmutable
        builder.setTitle(title)
                .setMessage(message);
        if(yn == true) {
            builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    //código Java si se ha pulsado sí
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    //código java si se ha pulsado no
                }
            });
        }


        return builder.create();
    }
}