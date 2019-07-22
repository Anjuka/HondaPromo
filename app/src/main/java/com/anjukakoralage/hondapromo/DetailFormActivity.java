package com.anjukakoralage.hondapromo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DetailFormActivity extends AppCompatActivity {

    private Button btnNext;
    private LinearLayout llmain;
    private CoordinatorLayout coordinatorLayout;
    private EditText etName;
    private EditText etAge;
    private AutoCompleteTextView etDistrict;
    private EditText etTP;
    private EditText etCity;

    DatabaseReference databaseUser;


    String[] languages = {"Ampara", "Anuradhapura", "Badulla", "Colombo", "Galle", "Gampaha",
            "Hambantota", "Jaffna", "Kalutara", "Kandy", "Kegalle", "Kilinochchi", "Kurunegala",
            "Mannar", "Matale", "Matara", "Moneragala", "Mullaitivu", "Nuwara Eliya", "Polonnaruwa",
            "Puttalam", "Ratnapura", "Trincomalee", "Vavuniya"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_form);

        databaseUser = FirebaseDatabase.getInstance().getReference("user");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_singlechoice, languages);

        etDistrict = (AutoCompleteTextView) findViewById(R.id.etCity);
        btnNext = (Button) findViewById(R.id.btnNext);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);
        etName = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etAge);
        etTP = (EditText) findViewById(R.id.etTP);

        etDistrict.setThreshold(1);
        etDistrict.setAdapter(adapter);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserData();
                Intent intent = new Intent(getApplicationContext(), SelectGenderActivity.class);
                startActivity(intent);
            }
        });

        coordinatorLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeKeyBoard();
            }
        });
    }

    private void closeKeyBoard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void saveUserData() {
        String name = etName.getText().toString().trim();
        String age = etAge.getText().toString().trim();
        String city = etDistrict.getText().toString().trim();
        String tp = etTP.getText().toString().trim();

        if (!TextUtils.isEmpty(name)) {

            String id = databaseUser.push().getKey();
            UserDetails userDetails = new UserDetails(name,age,city,tp);
            databaseUser.child(id).setValue(userDetails);
        } else {
            Toast.makeText(this, "You Should Enter A Name", Toast.LENGTH_LONG).show();
        }
    }


}
