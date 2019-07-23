package com.anjukakoralage.hondapromo.Quiestions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.anjukakoralage.hondapromo.Adds.ThirdAdd;
import com.anjukakoralage.hondapromo.R;
import com.anjukakoralage.hondapromo.Adds.SecondAdd;


public class ThirdQuiestion extends AppCompatActivity implements View.OnClickListener {

    private Button btnYes;
    private Button btnNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_quiestion);

        btnYes = (Button) findViewById(R.id.btnYes);
        btnYes.setOnClickListener(this);
        btnNo = (Button) findViewById(R.id.btnNo);
        btnNo.setOnClickListener(this);

    }
        @Override
        public void onClick (View v){
            switch (v.getId()) {
                case R.id.btnYes:
                    moveOn();
                    break;
                case R.id.btnNo:
                    moveOn();
                    break;
            }
        }

        private void moveOn() {
            Intent intent = new Intent(getApplicationContext(), ThirdAdd.class);
            startActivity(intent);
        }
    }

