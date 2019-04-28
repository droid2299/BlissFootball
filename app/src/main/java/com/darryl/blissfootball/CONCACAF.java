package com.darryl.blissfootball;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class CONCACAF extends AppCompatActivity {

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concacaf);
    }*/

    RecyclerView recyclerView2;
    ArrayList<Integer> Number2;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    RecyclerViewAdapter RecyclerViewHorizontalAdapter2;
    LinearLayoutManager HorizontalLayout2 ;
    View ChildView2 ;
    int RecyclerViewItemPosition2 ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concacaf);



        recyclerView2 = findViewById(R.id.recyclerview2);

        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView2.setLayoutManager(RecyclerViewLayoutManager);

        AddItemsToRecyclerViewArrayList();

        RecyclerViewHorizontalAdapter2 = new RecyclerViewAdapter(Number2);

        HorizontalLayout2 = new LinearLayoutManager(CONCACAF.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(HorizontalLayout2);

        recyclerView2.setAdapter(RecyclerViewHorizontalAdapter2);



        recyclerView2.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            GestureDetector gestureDetector = new GestureDetector(CONCACAF.this, new GestureDetector.SimpleOnGestureListener() {

                @Override public boolean onSingleTapUp(MotionEvent motionEvent) {

                    return true;
                }

            });
            @Override
            public boolean onInterceptTouchEvent(RecyclerView Recyclerview, MotionEvent motionEvent) {

                ChildView2 = Recyclerview.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

                if(ChildView2 != null && gestureDetector.onTouchEvent(motionEvent)) {


                    RecyclerViewItemPosition2 = Recyclerview.getChildAdapterPosition(ChildView2);


                    Toast.makeText(CONCACAF.this, "Redirecting...", Toast.LENGTH_LONG).show();

                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView Recyclerview, MotionEvent motionEvent) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

    }


    public void AddItemsToRecyclerViewArrayList(){



        Number2 = new ArrayList<Integer>();
        Number2.add(R.drawable.canada);
        Number2.add(R.drawable.costarica);
        Number2.add(R.drawable.uba);
        Number2.add(R.drawable.elsalvador);
        Number2.add(R.drawable.guatemala);
        Number2.add(R.drawable.haiti);
        Number2.add(R.drawable.honduras);
        Number2.add(R.drawable.mexico);
        Number2.add(R.drawable.nicaragua);
        Number2.add(R.drawable.panama);
        Number2.add(R.drawable.suriname);
        Number2.add(R.drawable.us);

        Intent myIntent = new Intent(getBaseContext() , RecyclerViewAdapter.class);
        myIntent.putExtra("flags" , 2);

    }





}



