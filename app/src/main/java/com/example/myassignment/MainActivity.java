package com.example.myassignment;

//import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.google.firebase.auth.FirebaseAuth;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button btnLogout;
    FirebaseAuth mAuth;
    RecycleViewAdapter recyclerViewAdapter;
    ArrayList<Integer> ImageList;
    RecyclerView recycleView;
    boolean doubleBackToExitPressedOnce = false;

 /*   private static final String TAG =   "MainActivity";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogout=findViewById(R.id.btnLogout);
        mAuth=FirebaseAuth.getInstance();

    //    getImages();

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();;
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        ImageList = new ArrayList<>(Arrays.asList(
                R.drawable.lamp,R.drawable.lamp2,
                R.drawable.lamp3,R.drawable.lamp)
        );
        recycleView = findViewById(R.id.recycleViewStagged);

        //setting recycleView layoutManager
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recycleView.setLayoutManager(layoutManager);

        recyclerViewAdapter = new RecycleViewAdapter(this,ImageList);
        //setting recycleViewAdapter
        recycleView.setAdapter(recyclerViewAdapter);


    }
    public void onBackPressed(){
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
/*
    private void getImages(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_960_720.jpg");
        mNames.add("Havasu Falls");

        mImageUrls.add("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_960_720.jpg");
        mNames.add("Trondheim");

        mImageUrls.add("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_960_720.jpg");
        mNames.add("Portugal");

        mImageUrls.add("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_960_720.jpg");
        mNames.add("Rocky Mountain National Park");


        mImageUrls.add("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_960_720.jpg");
        mNames.add("Mahahual");

        mImageUrls.add("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_960_720.jpg");
        mNames.add("Frozen Lake");


        mImageUrls.add("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_960_720.jpg");
        mNames.add("White Sands Desert");

        mImageUrls.add("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_960_720.jpg");
        mNames.add("Austrailia");

        mImageUrls.add("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_960_720.jpg");
        mNames.add("Washington");

        initRecyclerView();

    }
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdaptercircle adaptercircle = new RecyclerViewAdaptercircle(this,mNames,mImageUrls);
        recyclerView.setAdapter(adaptercircle);
    }*/
}