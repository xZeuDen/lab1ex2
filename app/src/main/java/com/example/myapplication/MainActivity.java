package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void button(View view) {

        //Find the fields by id
        EditText name = findViewById(R.id.name);
        EditText password = findViewById(R.id.password);
        EditText email = findViewById(R.id.email);
        EditText phone = findViewById(R.id.phone);

        //Parse the input text from text to strings
        String txtName = name.getText().toString();
        String txtPassword = password.getText().toString();
        String txtEmail = email.getText().toString();
        String txtPhone = phone.getText().toString();


        if(txtPhone.matches("[a-zA-Z]+")) {
            phone.setError("Phone must only contain numbers");
            phone.requestFocus();
            return;
        }
        if(!txtName.matches("[a-zA-Z]+")) {
            name.setError("Name must only contain letters");
            name.requestFocus();
            return;
        }
        Toast.makeText(this, "Thank you for submitting your response " + txtName, Toast.LENGTH_SHORT).show();
    }
}