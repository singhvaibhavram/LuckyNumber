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

        lucky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayResultActivity();
            }
        });
    }

    public void displayResultActivity(){

        Intent intent = new Intent(this, DisplayResult.class);
        startActivity(intent);
    }
}