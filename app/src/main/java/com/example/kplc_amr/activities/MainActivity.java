package com.example.kplc_amr.activities;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.kplc_amr.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;

public class MainActivity extends AppCompatActivity {
    private AppCompatButton btnReadMeter;
    private AppCompatTextView txtMeterNumber;
    private AppCompatImageView imgThumbnail;
    private final String TAG = getClass().getSimpleName();
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnReadMeter = findViewById(R.id.btnReadMeter);
        txtMeterNumber = findViewById(R.id.txtMeterNumber);
        imgThumbnail = findViewById(R.id.imgThumbnail);

        auth = FirebaseAuth.getInstance();

        btnReadMeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OcrCaptureActivity.class);
                startActivity(intent);
            }
        });
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