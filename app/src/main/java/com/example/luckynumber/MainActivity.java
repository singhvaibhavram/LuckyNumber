package com.example.luckynumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button lucky;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        lucky = findViewById(R.id.lucky);
        name = findViewById(R.id.nameText);

        lucky.setOnClickListener(v -> displayResultActivity());
    }

    public void displayResultActivity(){

        String username = name.getText().toString();

        // Explicit Intent
        Intent intent = new Intent(getApplicationContext(), DisplayResult.class);

        // Pass name to the second activity
        intent.putExtra("name", username);

        startActivity(intent);
    }
}