package com.example.kplc_amr.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;

import com.example.kplc_amr.R;

public class CreateMeterActivity extends AppCompatActivity {
    private AppCompatEditText txtMtrNo;
    private AppCompatButton btncontinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_meter);
        txtMtrNo = findViewById(R.id.txtMtrNumber);
        btncontinue = findViewById(R.id.btnContinue);

        final String mtrNo = txtMtrNo.getText().toString().trim();

        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateMeterActivity.this, MainActivity.class);
                intent.putExtra("meter", mtrNo);
                startActivity(intent);
        }
        });
    }
}
