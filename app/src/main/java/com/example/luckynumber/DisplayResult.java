package com.example.luckynumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class DisplayResult extends AppCompatActivity {
    Button share;
    TextView displayresulttext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_display_result);

        displayresulttext = findViewById(R.id.luckyText);
        share = findViewById(R.id.share);

        // Receiving data from main activity
        Intent intent = getIntent();
        String username = intent.getStringExtra("name");

        //Generating Random Numbers to display as lucky number
        int randomnum = generateRandom();
        displayresulttext.setText(""+randomnum);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(username, randomnum);
            }
        });

    }

    public int generateRandom(){
        Random randomnumber = new Random();
        int upperlimit = 1000;
        return randomnumber.nextInt(upperlimit);
    }

    public void shareData(String username, int randomnum){
        //Implicit Intent
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, username + " got lucky today!");
        intent.putExtra(Intent.EXTRA_TEXT, "Their lucky number is "+randomnum);
        startActivity(Intent.createChooser(intent, "Choose a platform to share"));
    }
}