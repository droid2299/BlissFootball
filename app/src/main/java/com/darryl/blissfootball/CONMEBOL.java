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

public class CONMEBOL extends AppCompatActivity {

    RecyclerView recyclerView3;
    ArrayList<Integer> Number3;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    RecyclerViewAdapter RecyclerViewHorizontalAdapter3;
    LinearLayoutManager HorizontalLayout3 ;
    View ChildView3 ;
    int RecyclerViewItemPosition3 ;
    public static String position = "0";
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conmebol);

        recyclerView = findViewById(R.id.recyclerview1);
        recyclerView3 = findViewById(R.id.recyclerview);

        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(RecyclerViewLayoutManager);

        AddItemsToRecyclerViewArrayList();

        RecyclerViewHorizontalAdapter3 = new RecyclerViewAdapter(Number3);

        HorizontalLayout3 = new LinearLayoutManager(CONMEBOL.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(HorizontalLayout3);

        recyclerView.setAdapter(RecyclerViewHorizontalAdapter3);



        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            GestureDetector gestureDetector = new GestureDetector(CONMEBOL.this, new GestureDetector.SimpleOnGestureListener() {

                @Override public boolean onSingleTapUp(MotionEvent motionEvent) {

                    return true;
                }

            });
            @Override
            public boolean onInterceptTouchEvent(RecyclerView Recyclerview, MotionEvent motionEvent) {

                ChildView3 = Recyclerview.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

                if(ChildView3 != null && gestureDetector.onTouchEvent(motionEvent)) {


                    RecyclerViewItemPosition3 = Recyclerview.getChildAdapterPosition(ChildView3);

                    position = String.valueOf(recyclerView.getChildLayoutPosition(ChildView3));
                    Toast.makeText(CONMEBOL.this, "Redirecting...", Toast.LENGTH_LONG).show();
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
        CONMEBOL.GridLayoutAdapter myRecyclerAdapter = new CONMEBOL.GridLayoutAdapter(bitmaps);
        recyclerView3.setLayoutManager(new StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.VERTICAL ));
        recyclerView3.setAdapter(myRecyclerAdapter);

    }

    private Bitmap[] getBitmaps() {
        Bitmap[] bitmaps = new Bitmap[11];
        bitmaps[0] = BitmapFactory.decodeResource(getResources(), R.drawable.euro);
        bitmaps[1] = BitmapFactory.decodeResource(getResources(), R.drawable.eurou21);
        bitmaps[2] = BitmapFactory.decodeResource(getResources(), R.drawable.womenseuro);
        bitmaps[3] = BitmapFactory.decodeResource(getResources(), R.drawable.unationsleague);
        bitmaps[4] = BitmapFactory.decodeResource(getResources(), R.drawable.championsl);
        bitmaps[5] = BitmapFactory.decodeResource(getResources(), R.drawable.europa);
        bitmaps[6] = BitmapFactory.decodeResource(getResources(), R.drawable.supercup);
        bitmaps[7] = BitmapFactory.decodeResource(getResources(), R.drawable.youthleague);
        bitmaps[8] = BitmapFactory.decodeResource(getResources(), R.drawable.regionscup);
        bitmaps[9] = BitmapFactory.decodeResource(getResources(), R.drawable.womenschampionsl);
        bitmaps[10] = BitmapFactory.decodeResource(getResources(), R.drawable.ufutsal);
        return bitmaps;
    }


    public void AddItemsToRecyclerViewArrayList(){


        Number3 = new ArrayList<Integer>();
        Number3.add(R.drawable.argentina);
        Number3.add(R.drawable.bolivia);
        Number3.add(R.drawable.france);
        Number3.add(R.drawable.chile);
        Number3.add(R.drawable.columbia);
        Number3.add(R.drawable.netherland);
        Number3.add(R.drawable.portugal);
        Number3.add(R.drawable.russia);
        Number3.add(R.drawable.spain);
        Number3.add(R.drawable.switzerland);
        Number3.add(R.drawable.turkey);
        Number3.add(R.drawable.ukraine);



    }

    private class GridLayoutAdapter extends RecyclerView.Adapter<CONMEBOL.GridHolder> {

        Bitmap[] bitmaps;

        public GridLayoutAdapter(Bitmap[] bitmaps) {
            this.bitmaps = bitmaps;
        }

        @Override
        public CONMEBOL.GridHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(CONMEBOL.this).inflate(R.layout.grid_rv, parent, false);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myintent = new Intent(CONMEBOL.this , Trophies.class);
                    startActivity(myintent);
                }
            });
            return new CONMEBOL.GridHolder(view);
            //return null;
        }


        @Override
        public void onBindViewHolder(CONMEBOL.GridHolder holder, int position) {
            holder.imageView.requestLayout();
            holder.imageView.setImageBitmap(bitmaps[position]);
            holder.textView.setText("");
        }

        @Override
        public int getItemCount() {
            return bitmaps.length;
        }
    }



    private class GridHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public GridHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivImage);
            textView = itemView.findViewById(R.id.tvCaption);
        }
    }
}
