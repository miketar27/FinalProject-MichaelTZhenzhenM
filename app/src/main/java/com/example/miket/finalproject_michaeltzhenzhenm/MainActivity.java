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
                this, R.array.levels, R.layout.spinner_layout);
        levelsAdapter.setDropDownViewResource(R.layout.spinner_layout);
        levels.setAdapter(levelsAdapter);

//        spinner=(Spinner) findViewById(spinner);
//        adapter= ArrayAdapter.createFromResource(this, R.array.levles, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
        levels.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                ((TextView) parent.getChildAt(0)).setTextColor(Color.BLUE);
//                ((TextView) parent.getChildAt(0)).setTextSize(20);
                Toast.makeText(getBaseContext(),parent.getItemIdAtPosition(position)+ " selected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });



    }
}
