package me.cpjk.washu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import me.cpjk.washu.R;

public class SelectWashTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_wash_type);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void selectPlatinumPlusWashType(View view) {
        Intent resultData = new Intent();
        resultData.putExtra("washType", "Platinum Plus");
        setResult(SelectWashTypeActivity.RESULT_OK, resultData);
        finish();
    }

    public void selectPlatinumWashType(View view) {
        Intent resultData = new Intent();
        resultData.putExtra("washType", "Platinum");
        setResult(SelectWashTypeActivity.RESULT_OK, resultData);
        finish();
    }

    public void selectSuperWashType(View view) {
        Intent resultData = new Intent();
        resultData.putExtra("washType", "Super");
        setResult(SelectWashTypeActivity.RESULT_OK, resultData);
        finish();
    }
}
