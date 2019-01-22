package com.example.jailson.showupartista.gui;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.jailson.showupartista.R;
import com.example.jailson.showupartista.entidade.Artist;
import com.example.jailson.showupartista.service.ArtistService;

public class LoginActivity extends AppCompatActivity {

    private ArtistService service;

    static RelativeLayout login_layout_progressBar;
    private Button button_enter;
    private Button button_register;
    private EditText editText_email;
    private EditText editText_password;

    private String email;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.service = new ArtistService();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        this.login_layout_progressBar = (RelativeLayout) findViewById(R.id.login_layout_progressBar);
        this.login_layout_progressBar.setVisibility(View.GONE);

        this.editText_email = (EditText) findViewById(R.id.login_edittext_email);
        this.editText_password = (EditText) findViewById(R.id.login_edittext_senha);

        this.button_enter = (Button) findViewById(R.id.login_button_enter);
        this.button_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
            }
        });

        this.button_register = (Button) findViewById(R.id.login_button_register);
        this.button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doRegister();
            }
        });

    }

    public void doLogin(){

        this.email = this.editText_email.getText().toString();
        this.password = this.editText_password.getText().toString();

        Artist artist = this.service.loginArtist(this.email, this.password);

        if(artist != null){

            Intent in = new Intent(LoginActivity.this, InitialActivity.class);
            in.putExtra("paramsArtista", artist);
            startActivity(in);
        }else{

            Toast.makeText(this, "Login FAIL!", Toast.LENGTH_SHORT).show();
        }
    }

    public void doRegister(){

        Intent in = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(in);
    }

    private class CheckLogin extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            //Tornando o progressBar visível
            login_layout_progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... params) {

            //Chamar o ArtistService passando email e login:
            return null;
        }

        @Override
        protected void onPostExecute(String s) {


            //Escondendo o progressBar
            login_layout_progressBar.setVisibility(View.GONE);
        }
    }
}