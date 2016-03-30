package me.cpjk.washu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PaymentActivity extends AppCompatActivity {

    private String ccNumber;

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
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String licensePlate = extras.getString("licensePlate");
            String washType = extras.getString("washType");
            String imageFileUri = extras.getString("imageFileUri");
            Log.d("IMAGEFILE written", imageFileUri);

            // saved order information
            // String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            // String orderName = "order_" + "timeStamp";
            String orderName = "order1";
            SharedPreferences sharedPrefs = this.getSharedPreferences(orderName, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPrefs.edit();

            editor.putString("licensePlate", licensePlate);
            editor.putString("washType", washType);
            editor.putString("imageFileUri", imageFileUri);
            editor.commit();
            Toast.makeText(this, "Order information sent to washer!", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Order information could not be retrieved.", Toast.LENGTH_LONG).show();
            return;
        }
        Intent startOrderCompleteActivityIntent = new Intent(PaymentActivity.this, OrderCompleteActivity.class);
        PaymentActivity.this.startActivity(startOrderCompleteActivityIntent);
    }
}
