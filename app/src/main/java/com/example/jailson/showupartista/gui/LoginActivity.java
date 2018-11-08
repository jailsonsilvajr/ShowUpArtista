package com.example.jailson.showupartista.gui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.jailson.showupartista.R;
import com.example.jailson.showupartista.entidade.Artista;
import com.example.jailson.showupartista.service.ArtistaService;

public class LoginActivity extends AppCompatActivity {

    private ArtistaService service;

    static RelativeLayout login_layout_progressBar;
    private Button button_entrar;
    private Button button_register;
    private EditText editText_email;
    private EditText editText_senha;

    private String email;
    private String senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.service = new ArtistaService();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        this.login_layout_progressBar = (RelativeLayout) findViewById(R.id.login_layout_progressBar);
        this.login_layout_progressBar.setVisibility(View.GONE);

        this.editText_email = (EditText) findViewById(R.id.login_edittext_email);
        this.editText_senha = (EditText) findViewById(R.id.login_edittext_senha);

        this.button_entrar = (Button) findViewById(R.id.login_button_entrar);
        this.button_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
            }
        });

        this.button_register = (Button) findViewById(R.id.login_button_cadastrar);
        this.button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doRegister();
            }
        });

    }

    public void doLogin(){

        //Toast.makeText(this, "Click Button Login", Toast.LENGTH_SHORT).show();
        this.email = this.editText_email.getText().toString();
        this.senha = this.editText_senha.getText().toString();

        Artista artista = this.service.loginArtista(this.email, this.senha);

        if(artista != null){

            Toast.makeText(this, "Email e Senha OK!", Toast.LENGTH_SHORT).show();
        }else{

            Toast.makeText(this, "Email e Senha FAIL!", Toast.LENGTH_SHORT).show();
        }

    }

    public void doRegister(){

        Toast.makeText(this, "Click Button Register", Toast.LENGTH_SHORT).show();
    }
}