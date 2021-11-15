package com.jks.amal.TypesOfCancers;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jks.amal.R;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView name = findViewById(R.id.tv_name);
        TextView desc = findViewById(R.id.tv_desc);
        TextView causes = findViewById(R.id.tv_causes);
        TextView symptoms = findViewById(R.id.tv_symptoms);
        TextView diagnosis = findViewById(R.id.tv_diagnosis);
        TextView therapy = findViewById(R.id.tv_therapy);

        name.setText(getIntent().getStringExtra("name"));
        desc.setText(getIntent().getStringExtra("desc"));
        causes.setText(getIntent().getStringExtra("causes"));
        symptoms.setText(getIntent().getStringExtra("symptoms"));
        diagnosis.setText(getIntent().getStringExtra("diagnosis"));
        therapy.setText(getIntent().getStringExtra("therapy"));
    }
}