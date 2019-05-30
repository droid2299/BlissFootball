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

    public static int _utfValue ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_international, container, false);


        ImageButton uefa = v.findViewById(R.id.uefa);
        ImageButton concacaf = v.findViewById(R.id.concaf);
        ImageButton conmebol = v.findViewById(R.id.conmebol);



        uefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Bliss Football" , "Button Pressed");
                Intent myIntent = new Intent(getContext() , UEFA.class);
                startActivity(myIntent);
                _utfValue = 0;

            }
        });

        concacaf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Bliss Football" , "Button Pressed");
                Intent myIntent = new Intent(getContext() , CONCACAF.class);
                startActivity(myIntent);
                _utfValue = 1;

            }
        });

        conmebol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Bliss Football" , "Button Pressed");
                Intent myIntent = new Intent(getContext() , CONMEBOL.class);
                startActivity(myIntent);
                _utfValue = 3;

            }
        });


        return(v);

    }
}