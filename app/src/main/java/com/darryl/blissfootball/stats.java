package com.darryl.blissfootball;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class stats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        Intent intent = getIntent();
        String positionCONCACAF = intent.getStringExtra("noOfProcessesCONCACAF");
        String positionUEFA = intent.getStringExtra("noOfProcessesUEFA");

        Log.d("Position", positionCONCACAF);
        Log.d("Position", positionUEFA);

        int UEFAposition = Integer.parseInt(positionUEFA);
        int CONCACAFposition = Integer.parseInt(positionCONCACAF);
        Log.d("Position", ""+UEFAposition);
        Log.d("Position", ""+CONCACAFposition);

        UEFAposition = -1;
        CONCACAFposition = -1;

        TextView description = findViewById(R.id.description);
        description.setMovementMethod(new ScrollingMovementMethod());
        description.setText("");
        ImageView crest= findViewById(R.id.crest);
        TextView title = findViewById(R.id.title);
        title.setText("");


        if(UEFAposition == 0){
            description.setText(R.string.austriaDescription);
            title.setText("Austria");
            UEFAposition = -1;
            crest.setImageResource(R.drawable.austriac);
        }

        switch (UEFAposition) {
            case 0:
                description.setText("");
                description.setText(R.string.austriaDescription);
                UEFAposition = -1;
                title.setText("austria");
                crest.setImageDrawable(getResources().getDrawable(R.drawable.austriac));

                break;

            case 1:
                description.setText("");
                description.setText(R.string.belgiumDescription);
                UEFAposition = -1;
                title.setText("belgium");
                crest.setImageDrawable(getResources().getDrawable(R.drawable.belgiumc));
                break;

            case 2:
                description.setText("");
                description.setText(R.string.franceDescription);
                UEFAposition = -1;
                title.setText("france");
                crest.setImageDrawable(getResources().getDrawable(R.drawable.francec));
                break;

            case 3:
                description.setText("");
                description.setText(R.string.germanyDescription);
                crest.setImageDrawable(getResources().getDrawable(R.drawable.germanyc));
                title.setText("germany");
                break;

            case 4:
                description.setText("");
                description.setText(R.string.irelandDescription);
                crest.setImageDrawable(getResources().getDrawable(R.drawable.irelandc));
                title.setText("ireland");
                break;

            case 5:
                description.setText("");
                description.setText(R.string.netherlandDescription);
                crest.setImageDrawable(getResources().getDrawable(R.drawable.netherlandc));
                title.setText("netherland");
                break;

            case 6:
                description.setText("");
                description.setText(R.string.portugalDescription);
                crest.setImageDrawable(getResources().getDrawable(R.drawable.portugalc));
                title.setText("portugal");
                break;

            case 7:
                description.setText("");
                description.setText(R.string.russiaDescription);
                crest.setImageDrawable(getResources().getDrawable(R.drawable.russiac));
                title.setText("russia");
                break;

            case 8:
                description.setText("");
                description.setText(R.string.spainDescription);
                crest.setImageDrawable(getResources().getDrawable(R.drawable.spainc));
                title.setText("spain");
                break;

            case 9:
                description.setText("");
                description.setText(R.string.switzerlandDescription);
                crest.setImageDrawable(getResources().getDrawable(R.drawable.switzerlandc));
                title.setText("switzerland");
                break;

            case 10:
                description.setText("");
                description.setText(R.string.turkeyDescription);
                crest.setImageDrawable(getResources().getDrawable(R.drawable.turkeyc));
                title.setText("turkey");
                break;

            case 11:
                description.setText("");
                description.setText(R.string.ukrainDescription);
                crest.setImageDrawable(getResources().getDrawable(R.drawable.ukrianec));
                title.setText("ukraine");
                break;
        }


        switch (CONCACAFposition) {
            case 0:
                description.setText("");
                description.setText(R.string.canadaDescription);
                CONCACAFposition = -1;
                title.setText("canada");
                crest.setImageDrawable(getResources().getDrawable(R.drawable.canadac));
                //description.setText("");
                break;

            case 1:
                description.setText("");
                description.setText(R.string.costaricaDescription);
                CONCACAFposition = -1;
                title.setText("costa rica");
                crest.setImageDrawable(getResources().getDrawable(R.drawable.costaricac));
                break;

            case 2:
                description.setText("");
                break;

            case 3:
                description.setText("");
                break;

            case 4:
                description.setText("");
                break;

            case 5:
                description.setText("");
                break;

            case 6:
                description.setText("");
                break;

            case 7:
                description.setText("");
                break;

            case 8:
                description.setText("");
                break;

            case 9:
                description.setText("");
                break;

            case 10:
                description.setText("");
                break;

            case 11:
                description.setText("");
                break;
        }


    }
}