package com.example.sajibpal.customcamera;

import android.hardware.Camera;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;


public class MainActivity extends AppCompatActivity {

    Camera camera;
    FrameLayout frameLayout;
    Showcamera showecamera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout= (FrameLayout) findViewById(R.id.frame);
        camera= Camera.open();
        showecamera=new Showcamera(this,camera);
        frameLayout.addView(showecamera);
    }

   Camera.PictureCallback mPictureCallback=new Camera.PictureCallback(){
       @Override
       public void onPictureTaken(byte[] data, Camera camera) {

           File picture=getOutputMediaFile();
           if(picture==null){

               return;
           }
           else{

               try {
                   FileOutputStream fos=new FileOutputStream(picture);
                   fos.write(data);
                   fos.close();

                   camera.startPreview();
               }
               catch (FileNotFoundException e) {
                   e.printStackTrace();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }
   };

   private  File getOutputMediaFile(){

       String sate= Environment.getExternalStorageState();
       if(!sate.equals(Environment.MEDIA_MOUNTED)){

           return  null;
       }
       else{

           File folder=new File(Environment.getExternalStorageDirectory()+File.separator+"Image");

           if(!folder.exists()){

               folder.mkdirs();
           }

           String image_id= UUID.randomUUID().toString()+".jpg";
           File outputfile=new File(folder,image_id);
           return outputfile;
       }
   }



    public  void show(View v){

       if(camera!=null){

          camera.takePicture(null,null,mPictureCallback);
       }
    }
}
