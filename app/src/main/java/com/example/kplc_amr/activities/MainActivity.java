package com.example.kplc_amr.activities;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.kplc_amr.R;
import com.example.kplc_amr.utilities.GlideApp;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
    private AppCompatButton btnReadMeter;
    private AppCompatTextView txtMeterNumber;
    private AppCompatImageView imgThumbnail;
    private static final int CAMERA = 1;
    private final String TAG = getClass().getSimpleName();

    private StorageReference storageRef;
    private FirebaseAuth auth;
    private Uri uri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnReadMeter = findViewById(R.id.btnReadMeter);
        txtMeterNumber = findViewById(R.id.txtMeterNumber);
        imgThumbnail = findViewById(R.id.imgThumbnail);

        FirebaseStorage storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();
        auth = FirebaseAuth.getInstance();

        btnReadMeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_CANCELED)
            return;

        if (requestCode == CAMERA) {
            // The resulting data as bitmap
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

            // Set to image view
            GlideApp.with(MainActivity.this)
                    .load(bitmap)
                    .circleCrop()
                    .into(imgThumbnail);

            imgThumbnail.setVisibility(View.VISIBLE);

            // Upload to Firebase cloud storage


            // Create a reference to 'images/new_image.jpg'
            String filePath = getRealPathFromURIPath(uri, MainActivity.this);

            StorageReference newImagesRef = storageRef.child("images/" + filePath);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] data1 = baos.toByteArray();

            UploadTask uploadTask = newImagesRef.putBytes(data1);
            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    Log.w(TAG, exception.getMessage());
                    Toast.makeText(MainActivity.this, "Upload Failed", Toast.LENGTH_SHORT).show();
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    Toast.makeText(MainActivity.this, "Upload Successful", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private String getRealPathFromURIPath(Uri contentURI, Activity activity) {
        Cursor cursor = activity.getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) {
            return contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            return cursor.getString(idx);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.actions_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.signOut:
                auth.signOut();
                Intent i = new Intent(MainActivity.this, AccessActivity.class);
                startActivity(i);
                ActivityCompat.finishAffinity(MainActivity.this);
                return true;
            default:
                return false;
        }
    }
}