package com.anjukakoralage.hondapromo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class DetailFormActivity extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteTextView;

    String[] languages = {"Ampara", "Anuradhapura", "Badulla", "Colombo", "Galle", "Gampaha",
            "Hambantota", "Jaffna", "Kalutara", "Kandy", "Kegalle", "Kilinochchi", "Kurunegala",
            "Mannar", "Matale", "Matara", "Moneragala", "Mullaitivu", "Nuwara Eliya", "Polonnaruwa",
            "Puttalam", "Ratnapura", "Trincomalee", "Vavuniya"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_form);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_singlechoice, languages);

        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.etDistrict);

        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(adapter);

    }

}
