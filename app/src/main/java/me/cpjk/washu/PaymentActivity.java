package me.cpjk.washu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PaymentActivity extends AppCompatActivity {

    private final boolean AUTOFILL = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (AUTOFILL) {
            SharedPreferences sharedPrefs = this.getSharedPreferences(getString(R.string.profile_file_name), Context.MODE_PRIVATE);
            String ccNumber = sharedPrefs.getString(this.getString(R.string.user_profile_cc), "");

            EditText licensePlateEditText = (EditText) findViewById(R.id.paymentCCNumberEditText);
            licensePlateEditText.setText(ccNumber);
        }

        Button orderButton = (Button) findViewById(R.id.orderButton);
    }

    public void openOrderCompleteActivity(View view){
        Intent startOrderCompleteActivityIntent = new Intent(PaymentActivity.this, OrderCompleteActivity.class);
        PaymentActivity.this.startActivity(startOrderCompleteActivityIntent);
    }
}
