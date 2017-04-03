package com.example.miket.finalproject_michaeltzhenzhenm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//    Spinner spinner;
//    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner levels = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> levelsAdapter = ArrayAdapter.createFromResource(
                this, R.array.group_levels, R.layout.spinner_layout);
        levelsAdapter.setDropDownViewResource(R.layout.spinner_layout);
        levels.setAdapter(levelsAdapter);

        levels.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),parent.getItemIdAtPosition(position)+ " selected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });



    }
}
