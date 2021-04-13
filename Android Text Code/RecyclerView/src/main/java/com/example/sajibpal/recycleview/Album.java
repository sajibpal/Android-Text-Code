package com.example.sajibpal.recycleview;

/**
 * Created by sajib pal on 10/10/2018.
 */

public class Album {

   private int image_id;

    Album(int image){

      setImage_id(image);
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image) {
        this.image_id = image;
    }
}
