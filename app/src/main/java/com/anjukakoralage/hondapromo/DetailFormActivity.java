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

import java.util.Calendar;

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


    String[] city = {"Colombo 6","Nugegoda","Kottawa","Piliyandala","Dehiwala","Angoda","Athurugiriya",
            "Avissawella","Battaramulla","Boralesgamuwa","Colombo 1","Colombo 10","Colombo 11","Colombo 12",
            "Colombo 13","Colombo 14","Colombo 15","Colombo 2","Colombo 3","Colombo 4","Colombo 5","Colombo 7",
            "Colombo 8","Colombo 9","Hanwella","Homagama","Kaduwela","Kesbewa","Kohuwala","Kolonnawa","Kotte",
            "Maharagama","Malabe","Moratuwa","Mount Lavinia","Nawala","Padukka", "Pannipitiya","Rajagiriya","Ratmalana",
            "Talawatugoda","Wellampitiya","Kandy","Gampola","Katugastota","Peradeniya", "Akurana","Ampitiya",
            "Digana","Galagedara","Gelioya","Kadugannawa","Kundasale","Madawala Bazaar","Nawalapitiya","Pilimatalawa",
            "Wattegama","Gampaha","Kiribathgoda","Negombo","Kadawatha","Wattala","Delgoda","Divulapitiya","Ganemulla",
            "Ja-Ela","Kandana","Katunayake","Kelaniya","Minuwangoda","Mirigama","Nittambuwa","Ragama","Veyangoda",
            "Kurunegala","Kuliyapitiya","Polgahawela","Narammala","Pannala","Alawwa","Bingiriya","Galgamuwa","Giriulla",
            "Hettipola","Ibbagamuwa","Mawathagama","Nikaweratiya","Wariyapola","Kalutara","Panadura","Horana",
            "Matugama","Bandaragama","Alutgama","Beruwala","Ingiriya","Wadduwa","Ampara","Akkarepattu","Kalmunai","Ampara",
            "Sainthamaruthu","Anuradhapura","Kekirawa","Tambuttegama","Eppawala","Medawachchiya","Galenbindunuwewa",
            "Galnewa","Habarana","Mihintale","Nochchiyagama","Talawa","Badulla","Bandarawela","Welimada","Mahiyanganaya",
            "Diyatalawa","Ella","Hali Ela","Haputale","Passara","Batticaloa","Galle","Ambalangoda","Elpitiya",
            "Hikkaduwa","Batapola","Ahangama","Baddegama","Bentota","Karapitiya","Hambantota","Tangalla","Beliatta",
            "Ambalantota","Hambantota","Tissamaharama","Jaffna","Nallur","Chavakachcheri","Kegalle","Mawanella",
            "Warakapola","Ruwanwella","Rambukkana","Dehiowita","Deraniyagala","Galigamuwa","Kitulgala","Yatiyantota",
            "Kilinochchi","Mannar","Matale","Dambulla","Galewela","Ukuwela","Sigiriya","Palapathwela","Rattota",
            "Yatawatta","Matara","Akuressa","Weligama","Hakmana","Dikwella","Deniyaya","Kamburugamuwa",
            "Kamburupitiya","Kekanadurra","Moneragala", "Wellawaya","Buttala","Bibile","Kataragama","Mullativu",
            "Nuwara Eliya","Hatton","Ginigathena","Madulla","Polonnaruwa","Kaduruwela","Hingurakgoda","Medirigiriya","Puttalam",
            "Chilaw","Wennappuwa","Nattandiya","Puttalam","Marawila","Dankotuwa", "Ratnapura","Embilipitiya","Balangoda",
            "Pelmadulla","Eheliyagoda","Kuruwita","Trincomalee","Kinniya","Vavuniya"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_form);

        databaseUser = FirebaseDatabase.getInstance().getReference("user");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_singlechoice, city);

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
        String dateTime = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());


        if (!TextUtils.isEmpty(name)) {

            String id = databaseUser.push().getKey();
            UserDetails userDetails = new UserDetails(name,age,city,tp,dateTime);
            databaseUser.child(id).setValue(userDetails);

            Intent intent = new Intent(getApplicationContext(), SelectGenderActivity.class);
            startActivity(intent);

        } else {
            Toast.makeText(this, "You Should Enter A Name", Toast.LENGTH_LONG).show();
        }
    }


}
