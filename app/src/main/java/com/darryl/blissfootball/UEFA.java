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





public class UEFA extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Integer> Number1;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    RecyclerViewAdapter RecyclerViewHorizontalAdapter;
    LinearLayoutManager HorizontalLayout ;
    View ChildView ;
    int RecyclerViewItemPosition ;
    public static String position = "0";
    RecyclerView recyclerView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uefa);



        recyclerView = findViewById(R.id.recyclerview1);
        recyclerView1 = findViewById(R.id.recyclerview);

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

                    position = String.valueOf(recyclerView.getChildLayoutPosition(ChildView));
                    Toast.makeText(UEFA.this, "Redirecting...", Toast.LENGTH_LONG).show();
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
        recyclerView1.setLayoutManager(new StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.VERTICAL ));
        recyclerView1.setAdapter(myRecyclerAdapter);

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

    private class GridLayoutAdapter extends RecyclerView.Adapter<UEFA.GridHolder> {

        Bitmap[] bitmaps;

        public GridLayoutAdapter(Bitmap[] bitmaps) {
            this.bitmaps = bitmaps;
        }

        @Override
        public UEFA.GridHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(UEFA.this).inflate(R.layout.grid_rv, parent, false);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myintent = new Intent(UEFA.this , Trophies.class);
                    startActivity(myintent);
                }
            });
            return new UEFA.GridHolder(view);
            //return null;
        }


        @Override
        public void onBindViewHolder(UEFA.GridHolder holder, int position) {
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




