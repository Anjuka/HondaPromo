package com.anjukakoralage.hondapromo.Quiestions;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.anjukakoralage.hondapromo.Adds.FifthAdd;
import com.anjukakoralage.hondapromo.Adds.FirstAdd;
import com.anjukakoralage.hondapromo.R;

public class FifthQuiestion extends AppCompatActivity implements View.OnClickListener {

    private Button btnYes;
    private Button btnNo;
    private String gender;
    String genderText;
    private TextView quiestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_quiestion);

        quiestion = (TextView) findViewById(R.id.tvQui);
        btnYes = (Button) findViewById(R.id.btnYes);
        btnYes.setOnClickListener(this);
        btnNo = (Button) findViewById(R.id.btnNo);
        btnNo.setOnClickListener(this);

        SharedPreferences preferences = getSharedPreferences("genderSelect", Activity.MODE_PRIVATE);
        gender = preferences.getString("Selected_Gender", "");

        switch (gender) {
            case "mother":
                genderText = String.format(getResources().getString(R.string.FifthQuestionM));
                quiestion.setText(genderText);
                break;
            case "father":
                genderText = String.format(getResources().getString(R.string.FifthQuestionF));
                quiestion.setText(genderText);
                break;
            case "brother":
                genderText = String.format(getResources().getString(R.string.FifthQuestionB));
                quiestion.setText(genderText);
                break;
            case "sister":
                genderText = String.format(getResources().getString(R.string.FifthQuestionS));
                quiestion.setText(genderText);
                break;
            case "couple":
                genderText = String.format(getResources().getString(R.string.FifthQuestionC));
                quiestion.setText(genderText);
                break;
        }
    }
    @Override
    public void onClick(View v) {
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
        Intent intent = new Intent(getApplicationContext(), FifthAdd.class);
        startActivity(intent);
    }
}
