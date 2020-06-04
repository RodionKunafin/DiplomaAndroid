package com.example.diplomaandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    final String SAVED_PIN = "saved_pin";
    EditText inputPin;
    Button btnSavePin;
    Button btnSign;
    Button btnCreatePin;
    //public static final String APP_PREFERENCES_PIN = "pin";
    SharedPreferences sPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputPin = findViewById(R.id.inputPin);
        btnSavePin = findViewById(R.id.btnSavePin);
        btnSavePin.setOnClickListener(this);
        btnSign = findViewById(R.id.btnSign);
        btnSign.setOnClickListener(this);

        btnCreatePin = findViewById(R.id.btnCreatePin);
        btnCreatePin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CretePin.class);
                startActivity(intent);
            }
        });
        SignPin();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSavePin:
                savePin();
                break;
            case R.id.btnSign:
                SignPin();
                break;
            default:
                break;
        }
    }

    private void savePin() {
        sPref = getSharedPreferences("PinPref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_PIN, inputPin.getText().toString());
        ed.apply();
        Toast.makeText(MainActivity.this, "PIN saved", Toast.LENGTH_SHORT).show();
    }

    private void SignPin() {
        sPref = getSharedPreferences("PinPref", MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_PIN, "");
        if (inputPin.getText().toString().equals(savedText)) {
            Intent in = new Intent(MainActivity.this, Notes.class);
            startActivity(in);
            Toast.makeText(MainActivity.this, "PIN is correct", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Incorrectly,try again", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SignPin();
    }
}
