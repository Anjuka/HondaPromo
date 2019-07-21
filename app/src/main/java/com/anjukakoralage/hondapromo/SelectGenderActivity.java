package com.anjukakoralage.hondapromo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class SelectGenderActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnMother;
    private Button btnFather;
    private Button btnSister;
    private Button btnBrother;
    private Button btnCouple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_gender);

        btnMother = (Button) findViewById(R.id.btnMother);
        btnMother.setOnClickListener(this);
        btnFather = (Button) findViewById(R.id.btnFather);
        btnFather.setOnClickListener(this);
        btnSister = (Button) findViewById(R.id.btnSister);
        btnSister.setOnClickListener(this);
        btnBrother = (Button) findViewById(R.id.btnBrother);
        btnBrother.setOnClickListener(this);
        btnCouple = (Button) findViewById(R.id.btnCouple);
        btnCouple.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMother:
                setGender("mother");
                moveOn();
                break;
            case R.id.btnFather:
                setGender("father");
                moveOn();
                break;
            case R.id.btnBrother:
                setGender("brother");
                moveOn();
                break;
            case R.id.btnSister:
                setGender("sister");
                moveOn();
                break;
            case R.id.btnCouple:
                setGender("couple");
                moveOn();
                break;
        }
    }

    private void moveOn() {

        Intent intent = new Intent(getApplicationContext(), FirstQuestion.class);
        startActivity(intent);
    }

    private void setGender(String gender) {

        SharedPreferences.Editor editor = getSharedPreferences("genderSelect", Activity.MODE_PRIVATE).edit();
        editor.putString("Selected_Lang", gender);
        editor.apply();

    }
}
