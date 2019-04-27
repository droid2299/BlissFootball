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



public class InternationalFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_international, container, false);


        ImageButton uefa = v.findViewById(R.id.uefa);
        ImageButton concacaf = v.findViewById(R.id.concaf);



        uefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Bliss Football" , "Button Pressed");
                Intent myIntent = new Intent(getContext() , UEFA.class);
                startActivity(myIntent);

            }
        });

        concacaf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Bliss Football" , "Button Pressed");
                Intent myIntent = new Intent(getContext() , CONCACAF.class);
                startActivity(myIntent);

            }
        });

        return(v);

    }
}