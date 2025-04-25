package com.example.scb11;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {
TextView homeTv;
EditText contactEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        homeTv = findViewById(R.id.tvHome);
        contactEt = findViewById(R.id.etContact);
//        String myName = getIntent().getExtras().getString("name");
//        homeTv.setText(myName);

    }

    public void getContact(View view) {
        String con = contactEt.getText().toString();
        homeTv.setText(con);
    }
}