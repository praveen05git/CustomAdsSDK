package com.example.adslibrary;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

     List<adProperties> testLists;
     FirebaseDatabase newfirebaseDatabase;
     DatabaseReference newdatabaseReference;
     TextView adtest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adtest=findViewById(R.id.test);
        testLists=new ArrayList<>();

        try{
            newfirebaseDatabase= FirebaseDatabase.getInstance();

            newdatabaseReference = newfirebaseDatabase.getReference("bannerads");


            newdatabaseReference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            for (DataSnapshot postSnapshot : snapshot.getChildren()) {

                adProperties ads = postSnapshot.getValue(adProperties.class);
                testLists.add(ads);

            }
            String newString=testLists.get(0).Name;
            adtest.setText(newString);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {
            Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
        }
    });
}
catch (Exception e)
{
    Log.i("errormsg",e.getMessage());

}



    }
}