package com.darryl.blissfootball;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.content.Intent.getIntent;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyView> {


    private ArrayList<Integer> list;
    ArrayList<Integer> Number1;

    public class MyView extends RecyclerView.ViewHolder {

        public ImageView textView;

        public MyView(View view) {
            super(view);

            textView = (ImageView) view.findViewById(R.id.textview1);

        }
    }


    public RecyclerViewAdapter(ArrayList<Integer> horizontalList) {
        this.list = horizontalList;
    }

    @Override
    public MyView onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_item, parent, false);

        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(final MyView holder, final int position) {

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

        //holder.textView.setText(list.get(position));
        holder.textView.setImageResource(Number1.get(position));
        //holder.textView.setImageResource(R.drawable.belgium);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}