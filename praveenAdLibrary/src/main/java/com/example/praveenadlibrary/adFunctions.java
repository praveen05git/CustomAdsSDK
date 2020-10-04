package com.example.praveenadlibrary;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class adFunctions extends AppCompatActivity {

    static List<adProperties> adLists;
    static FirebaseDatabase firebaseDatabase;
    static DatabaseReference databaseReference;
    static String adUrl;
    static int count;

    public static int getLink(final Context context)
    {
        adLists=new ArrayList<>();

        firebaseDatabase=FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference("adlist");


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot postSnapshot: snapshot.getChildren())
                {

                    adProperties ads= postSnapshot.getValue(adProperties.class);
                    adLists.add(ads);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        int count=adLists.size();


        return count;
    }

}
