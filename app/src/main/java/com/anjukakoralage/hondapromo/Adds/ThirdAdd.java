package com.anjukakoralage.hondapromo.Adds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.anjukakoralage.hondapromo.Quiestions.FourthQuiestion;
import com.anjukakoralage.hondapromo.Quiestions.ThirdQuiestion;
import com.anjukakoralage.hondapromo.R;

public class ThirdAdd extends AppCompatActivity {

    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_add);

        btnNext = (Button) findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FourthQuiestion.class);
                startActivity(intent);
            }
        });
    }
}
