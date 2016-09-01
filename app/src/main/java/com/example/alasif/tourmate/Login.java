package com.example.alasif.tourmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private EditText emailEt,passwordEt;
    private Button loginBtn,registerBtn;
    private DbHelper database;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEt = (EditText) findViewById(R.id.emailEditText);
        passwordEt = (EditText) findViewById(R.id.passwordEditText);
        loginBtn = (Button) findViewById(R.id.loginButton);
        registerBtn = (Button) findViewById(R.id.registerButton);

        loginBtn.setOnClickListener(this);
        registerBtn.setOnClickListener(this);
        database = new DbHelper(this);
        session = new Session(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.loginButton:
                login();
                break;
            case R.id.registerButton:
                startActivity(new Intent(Login.this,Register.class));
                break;
            default:
                break;
        }
    }

    private void login(){
        String email = emailEt.getText().toString();
        String password = passwordEt.getText().toString();
        if(database.getUser(email,password)){
            session.setLoggedin(true);
            startActivity(new Intent(Login.this,MainActivity.class));
            finish();
        }
        else{
            Toast.makeText(getApplicationContext(),"wrong email/password",Toast.LENGTH_SHORT).show();
        }
    }
}
