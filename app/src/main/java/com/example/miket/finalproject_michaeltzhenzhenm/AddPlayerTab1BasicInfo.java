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
public class AddPlayerTab1BasicInfo extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.ap_tab1_basic_info, container, false);

        Spinner monthSpinner = (Spinner) rootView.findViewById(R.id.player_bday_months_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> monthAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.months_array, R.layout.spinner_layout);
        // Specify the layout to use when the list of choices appears
        monthAdapter.setDropDownViewResource(R.layout.spinner_layout);
        // Apply the adapter to the spinner
        monthSpinner.setAdapter(monthAdapter);

        Spinner dayOfMonthSpinner = (Spinner) rootView.findViewById(R.id.player_bday_day_spinner);
        ArrayAdapter<CharSequence> dayOfMonthAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.days_of_month_array, R.layout.spinner_layout);
        dayOfMonthAdapter.setDropDownViewResource(R.layout.spinner_layout);
        dayOfMonthSpinner.setAdapter(dayOfMonthAdapter);

        Spinner yearsSpinner = (Spinner) rootView.findViewById(R.id.player_bday_year_spinner);
        ArrayAdapter<CharSequence> yearsAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.years_array, R.layout.spinner_layout);
        yearsAdapter.setDropDownViewResource(R.layout.spinner_layout);
        yearsSpinner.setAdapter(yearsAdapter);

        Spinner levelsAddSpinner = (Spinner) rootView.findViewById(R.id.levels_add_spinner);
        ArrayAdapter<CharSequence> levelsAddAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.group_levels, R.layout.spinner_layout);
        levelsAddAdapter.setDropDownViewResource(R.layout.spinner_layout);
        levelsAddSpinner.setAdapter(levelsAddAdapter);

        return rootView;
    }
}
