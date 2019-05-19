package com.example.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void math1s(View view) {
        Intent in = new Intent(this, Math1s.class);
        startActivity(in);
        finish();

    }

    //public static int LEVEL=3;
    public void puzzle3(View view) {
       // this.LEVEL = 3;
        Intent in = new Intent(this, Puzzle_level.class);
        startActivity(in);
        finish();

    }

    public void connect4(View view) {
        Intent in = new Intent(this, Connect4.class);
        startActivity(in);
        finish();

    }

    public void quit(View view){
        System.exit(0);
    }

}


