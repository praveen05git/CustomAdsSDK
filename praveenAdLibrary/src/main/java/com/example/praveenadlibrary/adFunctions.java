package com.example.praveenadlibrary;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class adFunctions {

    static List<adProperties> adLists;
    static FirebaseDatabase firebaseDatabase;
    static DatabaseReference databaseReference;
    static String adUrl;

    public static String getLink(final Context context)
    {
        adLists=new ArrayList<>();

        firebaseDatabase=FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference("adlist");


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot postSnapshot: snapshot.getChildren())
                {
                    Toast.makeText(context,"Reference",Toast.LENGTH_LONG).show();
                    /*
                    adProperties ads= postSnapshot.getValue(adProperties.class);
                    adLists.add(ads);

                     */
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        adProperties props = new adProperties();
        props.name="iam";
        props.url="batman";
        adLists.add(props);
        adUrl=adLists.get(0).getUrl();


        return "hi";
    }

}
