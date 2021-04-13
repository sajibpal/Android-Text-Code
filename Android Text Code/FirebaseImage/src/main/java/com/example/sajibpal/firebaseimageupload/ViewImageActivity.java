package com.example.sajibpal.firebaseimageupload;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import java.util.ArrayList;
import java.util.List;

public class ViewImageActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ImageAdapter mAdapter;

    private ProgressBar progressBar;
     LinearLayoutManager linearLayoutManager;
     DatabaseReference mDatabaseRef;
    private List<Upload> mUploads;
    FirebaseStorage firebaseStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);

        mRecyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        linearLayoutManager=new LinearLayoutManager(this);

        //for image show reverse order
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
       //************
        mRecyclerView.setLayoutManager(linearLayoutManager);

        progressBar= (ProgressBar) findViewById(R.id.progress_circular);

        mUploads=new ArrayList<>();

        //for uploads folder database from data read
        firebaseStorage=FirebaseStorage.getInstance();
        mDatabaseRef=FirebaseDatabase.getInstance().getReference("uploads");
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                mUploads.clear();
               for(DataSnapshot postSnapshot:dataSnapshot.getChildren())
               {
                   Upload upload=postSnapshot.getValue(Upload.class);//Upload class call received image name and imgURL
                   upload.setKey(postSnapshot.getKey());
                   mUploads.add(upload); //ArrayList add value
               }
               mAdapter=new ImageAdapter(ViewImageActivity.this, mUploads);
               mRecyclerView.setAdapter(mAdapter); //recyclerview view add textview and Imageview firebase image
               progressBar.setVisibility(View.INVISIBLE);

                mAdapter=new ImageAdapter(ViewImageActivity.this,mUploads);
                mRecyclerView.setAdapter(mAdapter);


                mAdapter.setOnItemClickListener(new ImageAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {

                        String text=mUploads.get(position).getImgName();
                        Toast.makeText(ViewImageActivity.this, text+"is Selected"+position, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDoAnyTask(int position) {

                        Toast.makeText(ViewImageActivity.this,"Do any Task is Selected", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDelete(int position) {

                        Upload selectItem=mUploads.get(position);
                        final String key=selectItem.getKey();

                        StorageReference storeRefarance=firebaseStorage.getReferenceFromUrl(selectItem.getImgUrl());
                        storeRefarance.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {

                                mDatabaseRef.child(key).removeValue();
                            }
                        });
                    }
                });

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(ViewImageActivity.this, "Error "+databaseError.getMessage() , Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.INVISIBLE);
            }
        });

    }
}


