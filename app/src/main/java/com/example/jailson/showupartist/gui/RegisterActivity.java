package com.example.jailson.showupartist.gui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jailson.showupartist.R;
import com.example.jailson.showupartist.entity.Artist;
import com.example.jailson.showupartist.service.ArtistService;

public class RegisterActivity extends AppCompatActivity {

    private ArtistService service;

    private EditText editText_email;
    private EditText editText_password;
    private EditText editText_password2;
    private Button button_submit;

    private String email;
    private String password;
    private String password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        this.service = new ArtistService(this);

        this.editText_email = (EditText) findViewById(R.id.register_edittext_email);
        this.editText_password = (EditText) findViewById(R.id.register_edittext_password);
        this.editText_password2 = (EditText) findViewById(R.id.register_edittext_password2);
        this.button_submit = (Button) findViewById(R.id.register_button_submit);

        this.button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doRegister();
            }
        });
    }

    public void doRegister(){

        this.email = this.editText_email.getText().toString();
        this.password = this.editText_password.getText().toString();
        this.password2 = this.editText_password2.getText().toString();

        if(this.email.equals("") || this.password.equals("")){

            Toast.makeText(this, "Email or Password invalid!", Toast.LENGTH_LONG).show();
        }else if(this.password.equals(this.password2)){

                if(this.service.registerArtist(this.email, this.password)){

                    Toast.makeText(this, "Register Ok!!", Toast.LENGTH_LONG).show();
                }else{

                    Toast.makeText(this, "Register Fail", Toast.LENGTH_LONG).show();
                }
            }else{

                Toast.makeText(this, "ERRO: Passwords", Toast.LENGTH_LONG).show();
            }
    }
}
