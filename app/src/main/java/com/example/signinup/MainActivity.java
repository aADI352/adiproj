package com.example.signinup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private EditText etEmail, etPassword, etConfirmPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectComponents();
    }

    private void connectComponents() {
        etEmail = findViewById(R.id.EmailAddress);
        etPassword = findViewById(R.id.Password);
        etConfirmPassword = findViewById(R.id.password_confirmation);
    }

    public void signup(View view) {

        String email   , password, confirmpassword;

        email = etEmail.getText().toString();
        password = etPassword.getText().toString();
        confirmpassword = etPassword.getText().toString();

        if(email.trim().isEmpty() || password.trim().isEmpty() || confirmpassword.trim().isEmpty())
        {
            Toast.makeText(this, "some fields are missing!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!isEmailvalid(email))
        {
            Toast.makeText(this, "Email is incorrect! ", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!isPasswordVaild(password))
        {
            Toast.makeText(this, "Password is Incorrect  !", Toast.LENGTH_SHORT).show();
        }

        if(!password.equals(confirmpassword))
        {
            Toast.makeText(this, "passwords don't match..", Toast.LENGTH_SHORT).show();
            return;
        }

    }

    private boolean isPasswordVaild(String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();
    }

    public boolean isEmailvalid(String email)
    {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}