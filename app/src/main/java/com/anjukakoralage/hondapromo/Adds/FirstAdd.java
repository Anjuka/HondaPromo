package com.anjukakoralage.hondapromo.Adds;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.anjukakoralage.hondapromo.Quiestions.SecondQuiestion;
import com.anjukakoralage.hondapromo.R;

public class FirstAdd extends AppCompatActivity {

    private Button btnNext;
    private String answer;
    private ImageView ivOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_add);

        btnNext = (Button) findViewById(R.id.btnNext);
        ivOk = (ImageView) findViewById(R.id.ivOk);
        answer = getIntent().getExtras().getString("firstAnswer");

        if (answer.equalsIgnoreCase("yes")){
            final int sdk = android.os.Build.VERSION.SDK_INT;
            if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                ivOk.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.yes) );
            } else {
                ivOk.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.yes));
            }

        }else {
            ivOk.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.no));
        }

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondQuiestion.class);
                startActivity(intent);
            }
        });
    }
}
