package me.cpjk.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class CustomerActivity extends AppCompatActivity {

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

}
