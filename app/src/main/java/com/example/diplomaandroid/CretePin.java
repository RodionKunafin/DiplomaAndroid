package com.example.diplomaandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CretePin extends AppCompatActivity {
    //final String SAVED_NEW_PIN = "saved_new_pin";
    final String SAVED_PIN = "saved_pin";
    EditText inputNewPin;
    Button btnSaveNewPin;
    Button btnReturnToPin;
    SharedPreferences sharedPrefCreatePin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_pin);

        inputNewPin = findViewById(R.id.inputNewPin);

        btnSaveNewPin = findViewById(R.id.btnSaveNewPin);
        btnSaveNewPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPrefCreatePin = getSharedPreferences("PinPref", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPrefCreatePin.edit();
                editor.putString(SAVED_PIN, inputNewPin.getText().toString());
                editor.apply();
                Toast.makeText(CretePin.this, "PIN saved", Toast.LENGTH_SHORT).show();
            }
        });

        btnReturnToPin = findViewById(R.id.btnReturnToPin);
        btnReturnToPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CretePin.this, PinCodeActivity.class);
                startActivity(intent);
            }
        });
    }
}

