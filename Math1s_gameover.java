package com.example.project;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Math1s_gameover extends AppCompatActivity {
    private Button returnMain;
    private Button returnHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math1s_gameover);
        Intent intent=getIntent();
        int score=intent.getIntExtra(Math1s.EXTRA_NUMBER,0);
        TextView textView1=(TextView) findViewById(R.id.score);
        textView1.setText("Score: "+ score);



        returnMain=(Button)findViewById(R.id.return_game);
        returnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset_math1s();
            }
        });

        returnHome=(Button)findViewById(R.id.return_home);
        returnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home();
            }
        });
    }


    public void home(){
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
