package com.darryl.blissfootball;



import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
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
    public static String position = "0";
    RecyclerView recyclerView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concacaf);



        recyclerView2 = findViewById(R.id.recyclerview2);
        recyclerView = findViewById(R.id.rvMain);

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

                    position = String.valueOf(recyclerView2.getChildLayoutPosition(ChildView2));
                    Toast.makeText(CONCACAF.this, "Redirecting...", Toast.LENGTH_LONG).show();
                    Log.d("UEFA"  , position);
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


        Bitmap[] bitmaps = getBitmaps();
        GridLayoutAdapter myRecyclerAdapter = new GridLayoutAdapter(bitmaps);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.VERTICAL ));
        recyclerView.setAdapter(myRecyclerAdapter);

    }

    private Bitmap[] getBitmaps() {
        Bitmap[] bitmaps = new Bitmap[6];
        bitmaps[0] = BitmapFactory.decodeResource(getResources(), R.drawable.goldcup);
        bitmaps[1] = BitmapFactory.decodeResource(getResources(), R.drawable.nationsleague);
        bitmaps[2] = BitmapFactory.decodeResource(getResources(), R.drawable.u20);
        bitmaps[3] = BitmapFactory.decodeResource(getResources(), R.drawable.womensgoldcup);
        bitmaps[4] = BitmapFactory.decodeResource(getResources(), R.drawable.womenu20);
        bitmaps[5] = BitmapFactory.decodeResource(getResources(), R.drawable.futsal);
        //bitmaps[6] = BitmapFactory.decodeResource(getResources(), R.drawable.seriea);
        //bitmaps[7] = BitmapFactory.decodeResource(getResources(), R.drawable.france);
        //bitmaps[8] = BitmapFactory.decodeResource(getResources(), R.drawable.austria);
        //bitmaps[9] = BitmapFactory.decodeResource(getResources(), R.drawable.belgium);
        return bitmaps;
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

    private class GridLayoutAdapter extends RecyclerView.Adapter<GridHolder> {

        Bitmap[] bitmaps;

        public GridLayoutAdapter(Bitmap[] bitmaps) {
            this.bitmaps = bitmaps;
        }

        @Override
        public GridHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(CONCACAF.this).inflate(R.layout.grid_rv, parent, false);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myintent = new Intent(CONCACAF.this , Trophies.class);
                    startActivity(myintent);
                }
            });
            return new GridHolder(view);
            //return null;
        }

        @Override
        public void onBindViewHolder(GridHolder holder, int position) {
            holder.imageView.requestLayout();
            holder.imageView.setImageBitmap(bitmaps[position]);
            holder.textView.setText("");
        }

        @Override
        public int getItemCount() {
            return bitmaps.length;
        }
    }



    public static class GridHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public GridHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivImage);
            textView = itemView.findViewById(R.id.tvCaption);
        }
    }



}



