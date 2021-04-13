package com.example.sajibpal.customcamera;

import android.content.Context;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;
import java.util.List;

public class Showcamera extends SurfaceView implements SurfaceHolder.Callback{

    Camera camera1;
    SurfaceHolder holder;
    public Showcamera(Context context, Camera camera) {
        super(context);
        this.camera1=camera;
        holder=getHolder();
        holder.addCallback(this);
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {


       Camera.Parameters param=camera1.getParameters();

        List<Camera.Size> sizes=param.getSupportedPictureSizes();
        Camera.Size msize=null;
        for(Camera.Size size : sizes ){

           msize=size;
        }


       if(this.getResources().getConfiguration().orientation!= Configuration.ORIENTATION_LANDSCAPE){

           param.set("orientation","portrait");
           camera1.setDisplayOrientation(90);
           param.setRotation(90);
        }
      else {

           param.set("orientation","landscape");
           camera1.setDisplayOrientation(0);
           param.setRotation(0);

       }

       param.setPictureSize(msize.width,msize.height);
       camera1.setParameters(param);

        try{

          camera1.setPreviewDisplay(holder);
            camera1.startPreview();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        camera1.stopPreview();
        camera1.release();
    }
}
