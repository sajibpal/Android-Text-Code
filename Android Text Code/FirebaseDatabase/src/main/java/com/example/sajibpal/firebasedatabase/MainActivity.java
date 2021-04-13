package com.example.sajibpal.firebasedatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText name1,age1;
    Button btn,btn1;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name1= (EditText) findViewById(R.id.name);
        age1= (EditText) findViewById(R.id.age);
        btn= (Button) findViewById(R.id.button);
        btn1= (Button) findViewById(R.id.butt);

        databaseReference= FirebaseDatabase.getInstance().getReference("student");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveData();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Showdata();
            }
        });
    }

    public void SaveData(){

        String name=name1.getText().toString().trim();
        String age=age1.getText().toString().trim();

        String key=databaseReference.push().getKey();

        Student student=new Student(name,age);

        databaseReference.child(key).setValue(student);
        Toast.makeText(this, "Data add Sucessfully", Toast.LENGTH_SHORT).show();
        name1.setText("");
        age1.setText("");
    }

    public  void Showdata(){

        Intent intent=new Intent(MainActivity.this,Details.class);
        startActivity(intent);
    }
}
