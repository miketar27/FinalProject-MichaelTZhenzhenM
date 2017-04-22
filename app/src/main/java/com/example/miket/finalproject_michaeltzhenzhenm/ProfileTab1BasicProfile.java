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

        TextView playerJerseyNumber = (TextView) rootView.findViewById(R.id.player_profile_jeresy_num);
        TextView playerBirthDate = (TextView) rootView.findViewById(R.id.player_profile_birth_date);
        TextView playerGroupLevel = (TextView) rootView.findViewById(R.id.player_profile_group_lvl);
        TextView playerGender = (TextView) rootView.findViewById(R.id.player_profile_gender);
        TextView playerParentsNames = (TextView) rootView.findViewById(R.id.player_profile_parents_names);
        TextView playerEmail = (TextView) rootView.findViewById(R.id.player_profile_email);

        Intent intent = getActivity().getIntent();

        Player player = (Player) intent.getSerializableExtra("A Player");
//        Parent parent1 = (Parent) intent.getSerializableExtra("A Player");

        playerJerseyNumber.setText(player.getJerseyNumber());
        playerBirthDate.setText(player.getBirthMonth() + " " + player.getBirthDay() + ", " + player.getBirthYear());
        playerGroupLevel.setText(player.getGroupLevel());
        playerGender.setText(player.getGender());
//        playerParentsNames.setText(parent1.getFirstName());
        playerEmail.setText(player.getEmailAddress());
        return rootView;


    }
}

