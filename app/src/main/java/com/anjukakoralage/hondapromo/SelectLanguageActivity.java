package com.anjukakoralage.hondapromo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class SelectLanguageActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSinhala;
    private Button btnEnglish;
    private Button btnTamil;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_language);

        //set Language
        loadLocal();

        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinator);
        btnSinhala = (Button) findViewById(R.id.btnSinhala);
        btnSinhala.setOnClickListener(this);
        btnEnglish = (Button) findViewById(R.id.btnEnglish);
        btnEnglish.setOnClickListener(this);
        btnTamil = (Button) findViewById(R.id.btnTamil);
        btnTamil.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSinhala:
                //Set Sinhala Language
                setLocal("si");
                recreate();
                moveOn();
                break;
            case R.id.btnEnglish:
                //Set English Language
                setLocal("en");
                recreate();
                moveOn();
                break;
            case R.id.btnTamil:
                //Set Tamil Language
                setLocal("ta");
                recreate();
                moveOn();
                break;
        }
    }

    private void snakBarMassege() {
        NotificationUtil.showSnakbarTypeOne(coordinatorLayout,getResources().getString(R.string.snakBarTitle), 0 );
    }

    private void moveOn() {

        Intent intent = new Intent(getApplicationContext(), DetailFormActivity.class);
        startActivity(intent);
        snakBarMassege();
    }

    private void setLocal(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext()
                .getResources().getDisplayMetrics());

        SharedPreferences.Editor editor = getSharedPreferences("settings", Activity.MODE_PRIVATE).edit();
        editor.putString("Selected_Lang", lang);
        editor.apply();

    }

    public void loadLocal() {
        SharedPreferences preferences = getSharedPreferences("settings", Activity.MODE_PRIVATE);
        String language = preferences.getString("Selected_Lang", "");
        setLocal(language);
    }
}
