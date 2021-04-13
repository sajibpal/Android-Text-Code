package com.example.sajibpal.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


/**
 * Created by sajib pal on 10/1/2018.
 */

public class Connection extends SQLiteOpenHelper {

    private  static final String DATABASE_NAME="Find.db";
    private  static final String TABLE_NAME="information";
    private  static final  int VERSION_NUMBER=1;
    private  static final String ID="_id";
    private  static final String NAME="Name";
    private  static final String AGE="Age";
    private  static final String GENDER="Gender";
    private  static  final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+ "("+ID+" INTEGER PRIMARY KEY  AUTOINCREMENT,"+NAME+" VARCHAR(25),"+AGE+"  INTEGER,"+GENDER+" VARCHAR(25));";
    private static  final  String DROP_TABLE="DROP TABLE IF EXISTS "+TABLE_NAME;
    private  static final String SHOW_DATA="SELECT *FROM "+TABLE_NAME;
    private Context context1;

    /*database connection code start*/

    public Connection(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
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

    } /*database connection code end*/

    //database add/insert function

    public  long  insetData(String name,String age,String gender){

        SQLiteDatabase data=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(NAME,name);
        values.put(AGE,age);
        values.put(GENDER,gender);
       long rowid=data.insert(TABLE_NAME,null,values);

      return rowid;
    }
    //database display function

    public Cursor displaydata(){

        SQLiteDatabase data=this.getWritableDatabase();
       Cursor cursor= data.rawQuery(SHOW_DATA,null);

     return cursor;
    }

    //database update function

    public boolean updatedata(String id,String name,String age,String gender){

        SQLiteDatabase data=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(ID,id);
        values.put(NAME,name);
        values.put(AGE,age);
        values.put(GENDER,gender);

        data.update(TABLE_NAME,values,ID+" =?",new String[]{id});

        return true;
    }
//database delete function
    public  int deletedata(String id){

        SQLiteDatabase data=this.getWritableDatabase();
       int value= data.delete(TABLE_NAME,ID+" =?",new String[]{id});
       return  value;
    }
}
