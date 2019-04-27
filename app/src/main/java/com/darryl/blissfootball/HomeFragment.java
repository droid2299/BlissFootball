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



public class HomeFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);


        ImageButton legends = v.findViewById(R.id.legends);
        ImageButton coaches = v.findViewById(R.id.coaches);



        legends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Bliss Football" , "Button Pressed");
                Intent myIntent = new Intent(getContext() , Legends.class);
                startActivity(myIntent);

            }
        });

        coaches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Bliss Football" , "Button Pressed");
                Intent myIntent = new Intent(getContext() , Coaches.class);
                startActivity(myIntent);

            }
        });

        return(v);

    }
}
