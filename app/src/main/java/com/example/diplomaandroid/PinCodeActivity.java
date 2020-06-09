package com.example.diplomaandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class PinCodeActivity extends AppCompatActivity implements View.OnClickListener {
    final String SAVED_PIN = "saved_pin";
    EditText inputPin;
    Button btnSign;
    SharedPreferences sPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputPin = findViewById(R.id.inputPin);
        btnSign = findViewById(R.id.btnSign);
        btnSign.setOnClickListener(this);


    }

    @Override
    protected void onResume() {
        super.onResume();
            if (sPref.getString(SAVED_PIN,"").length()!=0) {
                Toast.makeText(PinCodeActivity.this, "ENTER PIN", Toast.LENGTH_LONG).show();
            } else {
                Intent intent = new Intent(PinCodeActivity.this, CretePin.class);
                startActivity(intent);
            }
        }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSign:
                SignPin();
                break;
            default:
                break;
        }
    }

    private void SignPin() {
        sPref = getSharedPreferences("PinPref", MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_PIN, "");
        if (inputPin.getText().toString().equals(savedText)) {
            Intent in = new Intent(PinCodeActivity.this, Notes.class);
            startActivity(in);
            Toast.makeText(PinCodeActivity.this, "PIN is correct", Toast.LENGTH_SHORT).show();
        } else {
            inputPin.setText(null);
            Toast.makeText(PinCodeActivity.this, "Incorrectly,try again", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SignPin();
    }
}
