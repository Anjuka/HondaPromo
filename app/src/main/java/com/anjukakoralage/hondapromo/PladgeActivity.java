package com.anjukakoralage.hondapromo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PladgeActivity extends AppCompatActivity {

    private Button btnPladge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pladge);

        btnPladge = (Button) findViewById(R.id.btnPladge);

        btnPladge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CongratsActivity.class);
                startActivity(intent);
            }
        });
    }
}
