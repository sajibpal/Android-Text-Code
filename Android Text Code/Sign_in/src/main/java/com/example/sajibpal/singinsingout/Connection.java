package com.example.sajibpal.singinsingout;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by sajib pal on 10/5/2018.
 */

public class Connection extends SQLiteOpenHelper {

    private  static final String DATABASE_NAME="Data.db";
    private  static final String TABLE_NAME="inform";
    private  static final  int VERSION_NUMBER=1;
    private  static final String ID="_id";
    private  static final String NAME="Name";
    private  static final String EMAIL="Email";
    private  static final String PASSWORD="Password";
    private  static  final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+ "("+ID+" INTEGER PRIMARY KEY  AUTOINCREMENT,"+NAME+" VARCHAR(25),"+EMAIL+" TEXT NOT NULL,"+PASSWORD+" TEXT NOT NULL);";
    private static  final  String DROP_TABLE="DROP TABLE IF EXISTS "+TABLE_NAME;
    private  static final String SHOW_DATA="SELECT *FROM "+TABLE_NAME;
    private Context context1;

    public Connection(Context context) {
        super(context,DATABASE_NAME, null, VERSION_NUMBER);
        this.context1=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try{
            db.execSQL(CREATE_TABLE);
            Toast.makeText(context1, "Database is create", Toast.LENGTH_LONG).show();

        }catch (Exception e){

            Toast.makeText(context1, "Exception :"+e , Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try{

            Toast.makeText(context1, "onUpdate is called :" , Toast.LENGTH_LONG).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);

        }
        catch (Exception e){

            Toast.makeText(context1, "Exception :"+e , Toast.LENGTH_LONG).show();
        }

    }

    public  long  insetData(String name,String email,String password){

        SQLiteDatabase data=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(NAME,name);
        values.put(EMAIL,email);
        values.put(PASSWORD,password);
        long rowid=data.insert(TABLE_NAME,null,values);

        return rowid;
    }

    public  boolean findpassword(String name,String password){

        SQLiteDatabase data=this.getReadableDatabase();
        Cursor cursor=data.rawQuery("SELECT *FROM "+TABLE_NAME,null);
        boolean result=false;


        if(cursor.getCount()==0){

            Toast.makeText(context1, "No data found", Toast.LENGTH_SHORT).show();
        }
       else {
            while (cursor.moveToNext()) {

              String nam=cursor.getString(1);
              String pass=cursor.getString(3);

               if(nam.equals(name) && pass.equals(password)){

                   result=true;
                   break;
               }
            }
        }
      return result;
    }
}
