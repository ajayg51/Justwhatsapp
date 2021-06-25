package com.ajay.justwhatsapp;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import static android.Manifest.permission.READ_PHONE_NUMBERS;
import static android.Manifest.permission.READ_PHONE_STATE;
import static android.Manifest.permission.READ_SMS;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    EditText phoneArea,countryCode;
    Button whatsapp;
    String phoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneArea=(EditText) findViewById(R.id.phoneNo);
        countryCode=(EditText) findViewById(R.id.Ccode);
        whatsapp=(Button) findViewById(R.id.whatsapp);

        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ccode=countryCode.getText().toString();
                String phone=phoneArea.getText().toString();
                String text="Invalid mobile number.";
                if(ccode.length()==0){
                    countryCode.setText("+91");
                }
                if(phone.length()==0 || phone.length()==text.length()){
                    phoneArea.setText(text);
                }
                else{
                    phoneNo=countryCode.getText().toString();
                    phoneNo=phoneNo.concat(phoneArea.getText().toString());
                    Uri uri=Uri.parse("https://wa.me/"+phoneNo);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                return;
            }
        });
    }

}