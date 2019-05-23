package com.example.project;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.view.View;

import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

public class Math1s_gameover extends AppCompatActivity {
    //private Button returnGame;
  //  private Button returnHome;

    private static TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_math1s_gameover);
        Intent intent=getIntent();
        int score=intent.getIntExtra(Math1s.EXTRA_NUMBER,0);
        textView1=(TextView) findViewById(R.id.score);
        textView1.setText("Score: "+ score);



       ImageButton returnGame=(ImageButton) findViewById(R.id.return_game);
        returnGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset_math1s();
            }
        });


    }


    public void home(View view){
        Intent in = new Intent(this,MainActivity.class);
        startActivity(in);
        finish();
    }


    public  void reset_math1s(){
        Intent intent =new Intent(this,Math1s.class);
        startActivity(intent);
        finish();
    }
}
