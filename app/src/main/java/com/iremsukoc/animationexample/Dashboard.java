package com.iremsukoc.animationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    // Variables
    String email,password;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Hooks
        textView = findViewById(R.id.dashBoardTextView);

        // Get data from login
        email = getIntent().getStringExtra("email");
        System.out.println("email" +email);
        password = getIntent().getStringExtra("password");

        String completeSentences = email+"\n"+password;
        textView.setText(completeSentences);
    }
}