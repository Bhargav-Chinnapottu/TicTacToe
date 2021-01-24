package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int myActive=0;
    int[] myGameState={2,2,2,2,2,2,2,2,2};

    public void imageTapped(View view) {
        ImageView myTapped = (ImageView) view;
        int tapped = Integer.parseInt(myTapped.getTag().toString());
        Log.i("TAG is", "imageTapped: " + myTapped.getTag().toString());
        if (myGameState[tapped] == 2) {
            myGameState[tapped]=myActive;
            if (myActive == 0) {
                myTapped.setImageResource(R.drawable.cross);
                myTapped.animate().rotation(360).setDuration(1000);
                myActive = 1;
            } else {
                myTapped.setImageResource(R.drawable.circle);
                myActive = 0;
            }
        }
        else{
            Toast.makeText(this,"Already selected",Toast.LENGTH_SHORT).show();
        }
    }
    public void playAgain(View view){
        myActive=0;
        for(int i=0;i<myGameState.length;i++){
            myGameState[i]=2;
        }
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.one);
        for(int i=0;i<linearLayout.getChildCount();i++){
            ((ImageView) linearLayout.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
        LinearLayout linearLayout1=(LinearLayout)findViewById(R.id.two);
        for(int i=0;i<linearLayout1.getChildCount();i++){
            ((ImageView) linearLayout1.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
        LinearLayout linearLayout2=(LinearLayout)findViewById(R.id.three);
        for(int i=0;i<linearLayout2.getChildCount();i++) {
            ((ImageView) linearLayout2.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}