package me.cpjk.washu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button orderButton = (Button) findViewById(R.id.orderButton);
    }

    public void openOrderCompleteActivity(View view){
        Intent startOrderCompleteActivityIntent = new Intent(PaymentActivity.this, OrderCompleteActivity.class);
        PaymentActivity.this.startActivity(startOrderCompleteActivityIntent);
    }
}
