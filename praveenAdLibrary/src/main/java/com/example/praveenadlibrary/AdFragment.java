package com.example.praveenadlibrary;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AdFragment# newInstance} factory method to
 * create an instance of this fragment.
 */
public class AdFragment extends Fragment {

    static List<adProperties> adLists;
    static FirebaseDatabase firebaseDatabase;
    static DatabaseReference databaseReference;
    ImageView adImage;
    static String adImageUrl;

    public AdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.ad_fragment, container, false);

        adImage = root.findViewById(R.id.adImage);

        adLists = new ArrayList<>();

        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference("bannerads");


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {

                    adProperties ads = postSnapshot.getValue(adProperties.class);
                    adLists.add(ads);

                }

                Random random = new Random();
                int r = random.nextInt(3);
                adImageUrl = adLists.get(r).Url;
                Picasso.get().load(adImageUrl).into(adImage);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        return root;
    }
}



