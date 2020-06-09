package com.example.agri_doctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Expert_Connect extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;

    Toolbar toolbar;
    ImageView mcallButton1,mcallButton2,mcallButton3,mcallButton4;
    TextView num1,num2,num3,num4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert__connect);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Expert Connect");

        mcallButton1 = findViewById(R.id.callButton1);
        mcallButton2 = findViewById(R.id.callButton2);
        mcallButton3 = findViewById(R.id.callButton3);
        mcallButton4 = findViewById(R.id.callButton4);
        num1 = findViewById(R.id.number1);
        num2 = findViewById(R.id.number2);
        num3 = findViewById(R.id.number3);
        num4 = findViewById(R.id.number4);

        mcallButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = num1.getText().toString();
                makephonecall(number);
            }
        });
        mcallButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = num2.getText().toString();
                makephonecall(number);
            }
        });
        mcallButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = num3.getText().toString();
                makephonecall(number);
            }
        });
        mcallButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = num4.getText().toString();
                makephonecall(number);
            }
        });
    }

    private void makephonecall(String number) {
        String dail = "tel:"+ number;
        if(ContextCompat.checkSelfPermission(Expert_Connect.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Expert_Connect.this,new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }else {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse(dail));
            startActivity(callIntent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CALL){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                String number = num1.getText().toString();
                makephonecall(number);
            }else {
                Toast.makeText(this,"Permission Denied",Toast.LENGTH_SHORT).show();
            }
        }
    }
}