package com.anjukakoralage.hondapromo.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.anjukakoralage.hondapromo.Adds.FirstAdd;
import com.anjukakoralage.hondapromo.R;

public class PladgeActivity extends AppCompatActivity {

    private ImageButton btnPladge;
    private String gender;
    String genderText;
    private TextView quiestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pladge);

        btnPladge = (ImageButton) findViewById(R.id.btnPladge);
        quiestion = (TextView) findViewById(R.id.tvQui);


        SharedPreferences preferences = getSharedPreferences("genderSelect", Activity.MODE_PRIVATE);
        gender = preferences.getString("Selected_Gender", "");

        switch (gender) {
            case "mother":
                genderText = String.format(getResources().getString(R.string.PladgeM));
                quiestion.setText(genderText);
                break;
            case "father":
                genderText = String.format(getResources().getString(R.string.PladgeF));
                quiestion.setText(genderText);
                break;
            case "brother":
                genderText = String.format(getResources().getString(R.string.PladgeB));
                quiestion.setText(genderText);
                break;
            case "sister":
                genderText = String.format(getResources().getString(R.string.PladgeS));
                quiestion.setText(genderText);
                break;
            case "couple":
                genderText = String.format(getResources().getString(R.string.PladgeC));
                quiestion.setText(genderText);
                break;
        }

        btnPladge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CongratsActivity.class);
                startActivity(intent);
            }
        });
    }

}
