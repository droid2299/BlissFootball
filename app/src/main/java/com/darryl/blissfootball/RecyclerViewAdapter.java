package com.darryl.blissfootball;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyView> {



    //String value = getIntent.getExtra("String key which you used when send value");
    private ArrayList<Integer> list;
    ArrayList<Integer> Number1 , Number2 , Number3;

    public class MyView extends RecyclerView.ViewHolder {

        public ImageView textView;

        public MyView(View view) {
            super(view);

            textView = view.findViewById(R.id.textview1);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("RecyclerView" , "UEFA POSITION = " + UEFA.position);
                    v.getContext().startActivity(new Intent(v.getContext(), stats.class).putExtra("noOfProcessesCONCACAF" , CONCACAF.position).putExtra("noOfProcessesUEFA" , UEFA.position).putExtra("noOfProcessesCONMEBOL" , CONMEBOL.position));

                }
            });

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

        Number3 = new ArrayList<Integer>();
        Number3.add(R.drawable.argentina);
        Number3.add(R.drawable.bolivia);
        Number3.add(R.drawable.uba);
        Number3.add(R.drawable.chile);
        Number3.add(R.drawable.columbia);
        Number3.add(R.drawable.haiti);
        Number3.add(R.drawable.honduras);
        Number3.add(R.drawable.mexico);
        Number3.add(R.drawable.nicaragua);
        Number3.add(R.drawable.panama);
        Number3.add(R.drawable.suriname);
        Number3.add(R.drawable.us);

        //Number2.add(R.drawable.austria);

        //holder.textView.setText(list.get(position));7
        int value = InternationalFragment._utfValue;
        if(value == 1)
        {
            holder.textView.setImageResource(Number2.get(position));
        }
        else if(value == 0) {
            holder.textView.setImageResource(Number1.get(position));
            //holder.textView.setImageResource(R.drawable.belgium);
        }

        else {
            holder.textView.setImageResource(Number3.get(position));
            //holder.textView.setImageResource(R.drawable.belgium);
        }


    }

    @Override
    public int getItemCount() {
        Log.d("Recyclerview" , ""+list.size());
        return list.size();
    }

}