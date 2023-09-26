package com.L20290998.myfirstapplication.usuario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;

import com.L20290998.myfirstapplication.R;
import com.L20290998.myfirstapplication.usuario.model.Usuario;
import com.L20290998.myfirstapplication.usuario.repository.UsuarioRepository;

import java.util.Objects;

public class DashBoardUsuario extends AppCompatActivity {
    private UsuarioRepository ur;
    private Usuario userInfo;
    TextView tvUsr;

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

         
        /*
        @Override
         public boolean onCreateOptionsMenu(Menu menu){

            Toolbar toolbar = findViewById(R.id.toolbar2);
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.tolbar_menu,menu);
            return super.onCreateOptionsMenu(menu);
        }

         */

    }
}