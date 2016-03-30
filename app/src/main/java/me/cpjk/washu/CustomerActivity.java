package me.cpjk.washu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class CustomerActivity extends AppCompatActivity {

    private final int EDIT_PROFILE_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button customerOrdersButton = (Button) findViewById(R.id.customerCreateOrderButton);
    }

    public void openCustomerCreateOrderActivity(View view) {
        Intent startCustomerCreateOrderActivityIntent = new Intent(CustomerActivity.this, CustomerCreateOrderActivity.class);
        CustomerActivity.this.startActivity(startCustomerCreateOrderActivityIntent);
    }

    public void openCustomerEditProfileActivity(View view) {
        Intent startCustomerEditProfileActivityIntent = new Intent(CustomerActivity.this, CustomerEditProfileActivity.class);
        CustomerActivity.this.startActivityForResult(startCustomerEditProfileActivityIntent, EDIT_PROFILE_REQUEST_CODE);
    }
}
