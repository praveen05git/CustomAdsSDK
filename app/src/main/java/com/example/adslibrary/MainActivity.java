package com.example.adslibrary;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

     List<adProperties> testLists;
     FirebaseDatabase newfirebaseDatabase;
     DatabaseReference newdatabaseReference;
     ImageView NewimageView;
     String imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testLists=new ArrayList<>();
        NewimageView=findViewById(R.id.imageView);


            newfirebaseDatabase= FirebaseDatabase.getInstance();

            newdatabaseReference = newfirebaseDatabase.getReference("bannerads");


            newdatabaseReference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            for (DataSnapshot postSnapshot : snapshot.getChildren()) {

                adProperties ads = postSnapshot.getValue(adProperties.class);
                testLists.add(ads);

            }

            Random random = new Random();
            int r=random.nextInt(3);
                        imageUrl = (testLists.get(r).Url).toString();
                        Picasso.get().load(imageUrl).into(NewimageView);

        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {
            Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
        }
    });






    }
}