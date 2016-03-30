package me.cpjk.washu;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import me.cpjk.washu.R;

public class CustomerEditProfileActivity extends AppCompatActivity {
    private String name;
    private int age;
    private String ccNumber;
    private String licensePlateNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_edit_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences sharedPrefs = this.getSharedPreferences(getString(R.string.profile_file_name), Context.MODE_PRIVATE);
        name = sharedPrefs.getString(this.getString(R.string.user_profile_name), "Bob Smith");
        age = sharedPrefs.getInt(this.getString(R.string.user_profile_age), 20);
        ccNumber = sharedPrefs.getString(this.getString(R.string.user_profile_cc), "111111111");
        licensePlateNumber = sharedPrefs.getString(this.getString(R.string.user_profile_license), "VJ8 Z19");

        EditText nameField = (EditText) findViewById(R.id.profileNameInput);
        EditText ageField = (EditText) findViewById(R.id.profileAgeInput);
        EditText ccField = (EditText) findViewById(R.id.profileAgeInput);
        EditText licenseField = (EditText) findViewById(R.id.profileLicensePlateInput);

        nameField.setText(name);
        ageField.setText(Integer.toString(age));
        ccField.setText(ccNumber);
        licenseField.setText(licensePlateNumber);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void submitProfileChanges(View view) {
        Context context = this;
        SharedPreferences sharedPrefs = context.getSharedPreferences(getString(R.string.profile_file_name), Context.MODE_PRIVATE);
        // grab the info and save it

    }
}
