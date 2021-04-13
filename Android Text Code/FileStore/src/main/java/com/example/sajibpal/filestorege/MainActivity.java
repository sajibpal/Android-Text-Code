package com.example.sajibpal.filestorege;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;



public class MainActivity extends AppCompatActivity {
   EditText txt;
   Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt= (EditText) findViewById(R.id.text);
        btn= (Button) findViewById(R.id.button);
    }
    public void show(View j){

        if(j.getId()==R.id.button) {

            String message = txt.getText().toString();

            if (message != null) {

                writefile(message);

            } else {
                Toast.makeText(this, "Please Enter some Text ", Toast.LENGTH_SHORT).show();
            }
        }

      if(j.getId()==R.id.button1){

          readfile();
      }
    }
   public  void writefile(String text){

      String state= Environment.getExternalStorageState();
       if(Environment.MEDIA_MOUNTED.equals(state)){

           String root=Environment.getExternalStorageDirectory().getAbsolutePath();
           File dir=new File(root+"/inbox");

           if(!dir.exists()){
               dir.mkdir();
           }

           File fi=new File(dir,"data.txt");

           try{
               FileOutputStream file=new FileOutputStream(fi);
               file.write(text.getBytes());
               file.close();
               Toast.makeText(this, "Message saved", Toast.LENGTH_SHORT).show();
               txt.setText("");

           } catch (FileNotFoundException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
     else{

           Toast.makeText(this, "SD card not found ", Toast.LENGTH_SHORT).show();
       }

   }
   public  void readfile(){

       String root=Environment.getExternalStorageDirectory().getAbsolutePath();
       File dir=new File(root+"/inbox");
       File fi=new File(dir,"data.txt");
       try {
           FileInputStream file=new FileInputStream(fi);
           InputStreamReader reader=new InputStreamReader(file);
           BufferedReader buffer=new BufferedReader(reader);
           String line;
           StringBuffer stringbuffer=new StringBuffer();

            while((line=buffer.readLine())!=null){

                stringbuffer.append(line+"\n");
            }

         txt.setText(stringbuffer.toString());
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}
