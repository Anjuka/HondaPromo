package com.anjukakoralage.hondapromo.Adds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.anjukakoralage.hondapromo.Activity.PladgeActivity;
import com.anjukakoralage.hondapromo.Quiestions.ThirdQuiestion;
import com.anjukakoralage.hondapromo.R;

public class SeventhAdd extends AppCompatActivity {

    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh_add);

        btnNext = (Button) findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PladgeActivity.class);
                startActivity(intent);
            }
        });
    }
}
