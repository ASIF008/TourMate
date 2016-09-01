package com.example.alasif.tourmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity implements View.OnClickListener {
    private EditText emailEt,passwordEt;
    private Button registerBtn;
    private DbHelper database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailEt = (EditText) findViewById(R.id.emailEditText);
        passwordEt = (EditText) findViewById(R.id.passwordEditText);
        registerBtn = (Button) findViewById(R.id.registerButton);
        registerBtn.setOnClickListener(this);
        database = new DbHelper(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.registerButton:
                register();
                break;
            case R.id.loginButton:
                startActivity(new Intent(Register.this,Login.class));
                break;
            default:

                break;
        }
    }

    private void register(){
        String email = emailEt.getText().toString();
        String password = passwordEt.getText().toString();

        if (email.isEmpty() && password.isEmpty()){
            displayToast("username/password is empty");
        }
        else {
            database.addUser(email,password);
            displayToast("user registered");
            finish();
        }
    }

    private void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
}
