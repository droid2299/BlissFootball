package com.darryl.blissfootball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;





public class UEFA extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Integer> Number1;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    RecyclerViewAdapter RecyclerViewHorizontalAdapter;
    LinearLayoutManager HorizontalLayout ;
    View ChildView ;
    int RecyclerViewItemPosition ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uefa);



        recyclerView = findViewById(R.id.recyclerview1);

        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(RecyclerViewLayoutManager);

        AddItemsToRecyclerViewArrayList();

        RecyclerViewHorizontalAdapter = new RecyclerViewAdapter(Number1);

        HorizontalLayout = new LinearLayoutManager(UEFA.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(HorizontalLayout);

        recyclerView.setAdapter(RecyclerViewHorizontalAdapter);



        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            GestureDetector gestureDetector = new GestureDetector(UEFA.this, new GestureDetector.SimpleOnGestureListener() {

                @Override public boolean onSingleTapUp(MotionEvent motionEvent) {

                    return true;
                }

            });
            @Override
            public boolean onInterceptTouchEvent(RecyclerView Recyclerview, MotionEvent motionEvent) {

                ChildView = Recyclerview.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

                if(ChildView != null && gestureDetector.onTouchEvent(motionEvent)) {


                    RecyclerViewItemPosition = Recyclerview.getChildAdapterPosition(ChildView);


                    Toast.makeText(UEFA.this, "Redirecting...", Toast.LENGTH_LONG).show();

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


        Number1 = new ArrayList<Integer>();
        Number1.add(R.drawable.austria);
        Number1.add(R.drawable.belgium);
        Number1.add(R.drawable.france);
        Number1.add(R.drawable.germany);
        Number1.add(R.drawable.ireland);
        Number1.add(R.drawable.netherland);
        Number1.add(R.drawable.portugal);
        Number1.add(R.drawable.russia);
        Number1.add(R.drawable.spain);
        Number1.add(R.drawable.switzerland);
        Number1.add(R.drawable.turkey);
        Number1.add(R.drawable.ukraine);

        

    }


}

