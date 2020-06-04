package com.example.diplomaandroid;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class Notes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes);
        Toolbar toolbar = findViewById(R.id.toollbarNotes);
        setSupportActionBar(toolbar);

    }
}