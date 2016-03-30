package me.cpjk.washu;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import me.cpjk.washu.R;

public class PendingOrdersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_orders);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences sharedPrefs = this.getSharedPreferences("order1", Context.MODE_PRIVATE);
        String licensePlate = sharedPrefs.getString("licensePlate", "");
        String imageFileUri = sharedPrefs.getString("imageFileUri", "");
        String washType = sharedPrefs.getString("washType", "");

        TextView licenseTextView = (TextView) findViewById(R.id.pendingLicenseValueTextView);
        TextView washTypeTextView = (TextView) findViewById(R.id.pendingWashTypeValueTextView);

        ImageView carImageView = (ImageView) findViewById(R.id.pendingImageView);

        // scale down the image for thumbnail display
        try {
            Uri imageUri = imageUri(imageFileUri);
            Bitmap carImageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
            Bitmap scaledcarImageBitmap = Bitmap.createScaledBitmap(carImageBitmap, 512, 512, true);

            carImageView.setImageBitmap(scaledcarImageBitmap);
        }
        catch (Exception e) {
            //Toast.makeText(this, "Could not find image file for display", Toast.LENGTH_LONG).show();
            Log.d("DERP", e.toString() + " -> " + imageFileUri);
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
            return;
        }

        licenseTextView.setText("License Plate Number: " + licensePlate);
        washTypeTextView.setText("Wash Type: " + washType);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private Uri imageUri(String uriString) {
        /*
        String state = Environment.getExternalStorageState();
        if (! Environment.MEDIA_MOUNTED.equals(state)) return null;

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "Washu");
        mediaStorageDir.

        File imageFile = ;
        Uri imageFileUri = Uri.fromFile(imageFile)
        */
        return Uri.parse(uriString);

    }
}
