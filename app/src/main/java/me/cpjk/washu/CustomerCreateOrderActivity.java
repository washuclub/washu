package me.cpjk.washu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class CustomerCreateOrderActivity extends AppCompatActivity {
    private String washType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_create_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) { // wash type
            this.washType = data.getStringExtra("washType");
            TextView washTypeTextView = (TextView) findViewById(R.id.washTypeText);
            washTypeTextView.setText(this.washType);
        }
    }

    public void startSelectWashTypeActivity(View view) {
        Intent startSelectWashTypeIntent = new Intent(CustomerCreateOrderActivity.this, SelectWashTypeActivity.class);
        CustomerCreateOrderActivity.this.startActivityForResult(startSelectWashTypeIntent, 1);
    }


}
