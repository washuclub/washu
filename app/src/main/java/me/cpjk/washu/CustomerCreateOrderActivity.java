package me.cpjk.washu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerCreateOrderActivity extends AppCompatActivity {
    private String washType;
    private Uri imageFileUri;

    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    private static final int START_SELECT_WASH_TYPE_ACTIVITY_REQUEST_CODE = 101;
    public static final int MEDIA_TYPE_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_create_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == START_SELECT_WASH_TYPE_ACTIVITY_REQUEST_CODE) { // wash type
            this.washType = data.getStringExtra("washType");
            TextView washTypeTextView = (TextView) findViewById(R.id.washTypeText);
            washTypeTextView.setText(this.washType);
        } else if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) { // camera
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Image captured.", Toast.LENGTH_LONG).show();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Image capture cancelled.", Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(this, "Image capture error.", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void startSelectWashTypeActivity(View view) {
        Intent startSelectWashTypeIntent = new Intent(CustomerCreateOrderActivity.this, SelectWashTypeActivity.class);
        CustomerCreateOrderActivity.this.startActivityForResult(startSelectWashTypeIntent, START_SELECT_WASH_TYPE_ACTIVITY_REQUEST_CODE);
    }

    public void startCameraCapture(View view) {
        Intent startCameraCaptureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        imageFileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);

        startCameraCaptureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUri);

        startActivityForResult(startCameraCaptureIntent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
    }

    /** Create a file Uri for saving an image or video */
    private static Uri getOutputMediaFileUri(int type){
        return Uri.fromFile(getOutputMediaFile(type));
    }

    /** Create a File for saving an image or video */
    private static File getOutputMediaFile(int type){
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "Washu");
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                Log.d("Washu", "failed to create camera image directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE){
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "IMG_"+ timeStamp + ".jpg");
        } else {
            return null;
        }

        return mediaFile;
    }

}
