package com.example.sajibpal.recycleview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import java.util.ArrayList;

/**
 * Created by sajib pal on 10/10/2018.
 */

public class RecyclerShow extends RecyclerView.Adapter<RecyclerShow.MyholderView> {

    ArrayList<Album> arrayList=new ArrayList<>();
    Context context1;

    RecyclerShow(Context context, ArrayList<Album> arrayList){

     this.arrayList=arrayList;
        this.context1=context;
    }
    @Override
    public MyholderView onCreateViewHolder(ViewGroup parent, int viewType) {

        View ok=LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);

        return new MyholderView(ok);
    }

    @Override
    public void onBindViewHolder(MyholderView holder, final int position) {

        holder.imageView.setImageResource(arrayList.get(position).getImage_id());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context1,Detail.class);
                intent.putExtra("Image",arrayList.get(position).getImage_id());
                context1.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return arrayList.size();
    }

    public  static  class  MyholderView extends RecyclerView.ViewHolder{

        ImageView imageView;
        CardView cardView;
        public MyholderView(View itemView) {

            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.img);
            cardView=(CardView)itemView.findViewById(R.id.card);
        }
    }
}
