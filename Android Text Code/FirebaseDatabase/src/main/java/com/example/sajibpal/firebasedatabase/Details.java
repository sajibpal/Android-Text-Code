package com.example.sajibpal.firebasedatabase;



import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class Details extends AppCompatActivity {

    ListView listView;
   // DatabaseReference dataReference;
    List<Student> studentList1;
    CustomAdapter adapter;
    Query query;
    EditText search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


     //for firebase database search
        search= (EditText) findViewById(R.id.edit);
        search.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {



            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                query = FirebaseDatabase.getInstance().getReference("student")
                .orderByChild("name").startAt(s.toString()).endAt(s.toString()+"\uf8ff");

                onStart();
        }

    });

//************************* end search code *************


        // dataReference= FirebaseDatabase.getInstance().getReference("student");

            query=FirebaseDatabase.getInstance().getReference("student");
                  // .orderByChild("name").limitToLast("sajib");


        studentList1=new ArrayList<>();
        adapter=new CustomAdapter(Details.this,studentList1);

        listView= (ListView)findViewById(R.id.list);


        /*for show data bottom  list
        listView.setStackFromBottom(true); */

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Student selecteditem = studentList1.get(position);
                final String key=selecteditem.getKey();
                showUpdateDeleteDialog(key,selecteditem.getAge(), selecteditem.getName());
                return true;

            }
        });
    }

    @Override
    protected void onStart() {

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                studentList1.clear();

                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){

                    Student student=dataSnapshot1.getValue(Student.class);
                    student.setKey(dataSnapshot1.getKey());
                    studentList1.add(student);
                }

                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(Details.this, "Database Error", Toast.LENGTH_SHORT).show();
            }
        });
        super.onStart();
    }

//update and delete dialog

    private void showUpdateDeleteDialog(final String keyid ,String age, String name) {


        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.updatedata, null);
        dialogBuilder.setView(dialogView);

        final EditText editTextName = (EditText) dialogView.findViewById(R.id.name);
        final EditText editTextage = (EditText) dialogView.findViewById(R.id.age);
        final Button buttonUpdate = (Button) dialogView.findViewById(R.id.update);
        final Button buttonDelete = (Button) dialogView.findViewById(R.id.delete);

        editTextage.setText(age);
        editTextName.setText(name);

        dialogBuilder.setTitle(name);
        final AlertDialog b = dialogBuilder.create();
        b.show();


        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString().trim();
                String age =editTextage.getText().toString().trim();


                if (!name.isEmpty()) {
                    updateArtist(keyid ,name, age);
                    b.dismiss();
                }
            }
        });


        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                deleteArtist(keyid);
                b.dismiss();

            }
        });
    }

 //update methode

    private boolean updateArtist(String id,String name, String age) {
        //getting the specified artist reference
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("student").child(id);

        //updating artist
        Student artist = new Student(name,age);
        dR.setValue(artist);
        Toast.makeText(getApplicationContext(), "Data Updated", Toast.LENGTH_LONG).show();
        return true;
    }

    //Delete methode

    private boolean deleteArtist(String id) {
        //getting the specified artist reference
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("student").child(id);

        dR.removeValue();
        Toast.makeText(getApplicationContext(), "Data Deleted", Toast.LENGTH_LONG).show();
        return true;
    }
}
