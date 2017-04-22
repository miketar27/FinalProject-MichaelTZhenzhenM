package com.example.miket.finalproject_michaeltzhenzhenm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by miket on 4/22/2017.
 */

public class ProfileTab1BasicProfile extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.p_tab1_basic_profile, container, false);

        TextView playerFirstName = (TextView) rootView.findViewById(R.id.player_first_name);
        Intent intent = getActivity().getIntent();
        Player player = (Player) intent.getSerializableExtra("A Player");
        playerFirstName.setText(player.getFirstName());
        return rootView;


    }
}

