package com.example.miket.finalproject_michaeltzhenzhenm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by miket on 4/15/2017.
 */
public class Tab1BasicInfo extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1_basic_info, container, false);
        Spinner monthSpinner = (Spinner) rootView.findViewById(R.id.months_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> monthAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.months_array, R.layout.spinner_layout);
        // Specify the layout to use when the list of choices appears
        monthAdapter.setDropDownViewResource(R.layout.spinner_layout);
        // Apply the adapter to the spinner
        monthSpinner.setAdapter(monthAdapter);

        Spinner dayOfMonthSpinner = (Spinner) rootView.findViewById(R.id.days_of_month_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> dayOfMonthAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.days_of_month_array, R.layout.spinner_layout);
        // Specify the layout to use when the list of choices appears
        monthAdapter.setDropDownViewResource(R.layout.spinner_layout);
        // Apply the adapter to the spinner
        dayOfMonthSpinner.setAdapter(dayOfMonthAdapter);

        Spinner yearsSpinner = (Spinner) rootView.findViewById(R.id.years_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> yearsAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.years_array, R.layout.spinner_layout);
        // Specify the layout to use when the list of choices appears
        monthAdapter.setDropDownViewResource(R.layout.spinner_layout);
        // Apply the adapter to the spinner
        yearsSpinner.setAdapter(yearsAdapter);

        return rootView;
    }
}
