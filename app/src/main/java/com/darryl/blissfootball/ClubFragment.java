package com.darryl.blissfootball;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;



public class ClubFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_club, container, false);


        ImageButton bundesliga = v.findViewById(R.id.bundesliga);
        ImageButton laliga = v.findViewById(R.id.laliga);
        ImageButton epl = v.findViewById(R.id.epl);
        ImageButton ligue1 = v.findViewById(R.id.ligue1);
        ImageButton seriea = v.findViewById(R.id.seriea);



        bundesliga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Bliss Football" , "Button Pressed");
                Intent myIntent = new Intent(getContext() , bundesliga.class);
                startActivity(myIntent);

            }
        });

        laliga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Bliss Football" , "Button Pressed");
                Intent myIntent = new Intent(getContext() , laliga.class);
                startActivity(myIntent);

            }
        });

        epl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Bliss Football" , "Button Pressed");
                Intent myIntent = new Intent(getContext() , epl.class);
                startActivity(myIntent);

            }
        });

        ligue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Bliss Football" , "Button Pressed");
                Intent myIntent = new Intent(getContext() , ligue1.class);
                startActivity(myIntent);

            }
        });

        seriea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Bliss Football" , "Button Pressed");
                Intent myIntent = new Intent(getContext() , seriea.class);
                startActivity(myIntent);

            }
        });

        return(v);
    }
}