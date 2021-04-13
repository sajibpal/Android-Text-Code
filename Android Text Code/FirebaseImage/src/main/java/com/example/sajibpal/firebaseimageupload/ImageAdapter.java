package com.example.sajibpal.firebaseimageupload;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private Context mContext;
    private List<Upload> mUploads;
    OnItemClickListener listener;

    public ImageAdapter(Context context, List<Upload> uploads)
    {
        mContext=context;
        mUploads=uploads;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v=LayoutInflater.from(mContext).inflate(R.layout.image_item, viewGroup,false);
        return  new ImageViewHolder(v);
    }

    //Firebase upload image show for set name and image textview and Imageview
    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {
        Upload uploadCur=mUploads.get(i);
        imageViewHolder.img_description.setText(uploadCur.getImgName());
        Picasso.with(mContext)
                .load(uploadCur.getImgUrl())
                .placeholder(R.drawable.imagepreview)//default image show when not load image
                .fit()
                .centerCrop()
                .into(imageViewHolder.image_view);

    }

    @Override
    public int getItemCount() {

        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnCreateContextMenuListener,MenuItem.OnMenuItemClickListener{

        public TextView img_description;
        public ImageView image_view;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);  //image_item.xml text and imageview found
            img_description = (TextView) itemView.findViewById(R.id.img_description);
            image_view = (ImageView) itemView.findViewById(R.id.image_view);

            itemView.setOnClickListener(this);
            itemView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onClick(View v) {

            if(listener !=null){

                int position =getAdapterPosition();

                if(position !=RecyclerView.NO_POSITION){

                    listener.onItemClick(position);
                }
            }

    }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

            menu.setHeaderTitle("Choose an action");
            MenuItem doAnyTask=menu.add(Menu.NONE,1,1,"Do any task");
            MenuItem delete=menu.add(Menu.NONE,2,2,"Delete");

            doAnyTask.setOnMenuItemClickListener(this);
            delete.setOnMenuItemClickListener(this);

        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            if(listener !=null){

                int position =getAdapterPosition();

                if(position !=RecyclerView.NO_POSITION){

                    switch (item.getItemId()){

                        case 1:
                            listener.onDoAnyTask(position);
                            return true;
                        case 2:
                            listener.onDelete (position);
                            return true;
                    }
                }
            }
            return false;
        }

    }

    public  interface  OnItemClickListener{

        void onItemClick(int position);
        void onDoAnyTask(int position);
        void onDelete(int position);

    }

    public  void setOnItemClickListener(OnItemClickListener listener){

        this.listener=listener;
    }

}


