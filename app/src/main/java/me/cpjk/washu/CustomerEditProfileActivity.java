package me.cpjk.washu;

import android.content.Context;
import android.content.Intent;
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
    private String age;
    private String ccNumber;
    private String licensePlateNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_edit_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences sharedPrefs = this.getSharedPreferences(getString(R.string.profile_file_name), Context.MODE_PRIVATE);
        name = sharedPrefs.getString(this.getString(R.string.user_profile_name), "");
        age = sharedPrefs.getString(this.getString(R.string.user_profile_age), "");
        ccNumber = sharedPrefs.getString(this.getString(R.string.user_profile_cc), "");
        licensePlateNumber = sharedPrefs.getString(this.getString(R.string.user_profile_license), "");

        EditText nameField = (EditText) findViewById(R.id.profileNameInput);
        EditText ageField = (EditText) findViewById(R.id.profileAgeInput);
        EditText ccField = (EditText) findViewById(R.id.profileCreditCardInput);
        EditText licenseField = (EditText) findViewById(R.id.profileLicensePlateInput);

        nameField.setText(name);
        ageField.setText(age);
        ccField.setText(ccNumber);
        licenseField.setText(licensePlateNumber);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void submitProfileChanges(View view) {
        SharedPreferences sharedPrefs = this.getSharedPreferences(getString(R.string.profile_file_name), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();

        EditText nameField = (EditText) findViewById(R.id.profileNameInput);
        EditText ageField = (EditText) findViewById(R.id.profileAgeInput);
        EditText ccField = (EditText) findViewById(R.id.profileCreditCardInput);
        EditText licenseField = (EditText) findViewById(R.id.profileLicensePlateInput);

        name = nameField.getText().toString();
        age = ageField.getText().toString();
        ccNumber = ccField.getText().toString();
        licensePlateNumber = licenseField.getText().toString();

        editor.putString(this.getString(R.string.user_profile_name), name);
        editor.putString(this.getString(R.string.user_profile_age), age);
        editor.putString(this.getString(R.string.user_profile_cc), ccNumber);
        editor.putString(this.getString(R.string.user_profile_license), licensePlateNumber);
        editor.commit();

        Intent resultData = new Intent();
        setResult(CustomerEditProfileActivity.RESULT_OK, resultData);
        finish();
    }
}
