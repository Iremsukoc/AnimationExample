package com.iremsukoc.animationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class Login extends AppCompatActivity {

    //Variables
    TextInputLayout email, password;
    Button login,signUp;
    String userEmail, userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Hooks
        email = findViewById(R.id.emailEditTextLogin);
        password = findViewById(R.id.passwordEditTextLogin);
        login = findViewById(R.id.loginBtn);
        signUp = findViewById(R.id.signUpBtn);



    }

    public void loginBtn(View view) {

        if (isEmailValid())
        {
            //Convert to String
            userEmail = Objects.requireNonNull(email.getEditText()).getText().toString().trim();
            userPassword = Objects.requireNonNull(password.getEditText()).getText().toString().trim();

            Intent intent = new Intent(getApplicationContext(),Dashboard.class);
            intent.putExtra("email",userEmail);
            intent.putExtra("password",userPassword);
            startActivity(intent);
        }

    }

    private boolean isEmailValid() {
        String val = Objects.requireNonNull(email.getEditText()).getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


        if (val.isEmpty())
        {
            email.setError("Field cannot be empty");
            return false;

        }else if (!val.matches(emailPattern))
        {
            email.setError("Invalid email address");
            return false;

        }else
        {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;

        }
    }
}