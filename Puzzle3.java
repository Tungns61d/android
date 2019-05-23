package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;

import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Puzzle3 extends AppCompatActivity {

    private PuzzleBoardView boardView;
    private static TextView bestScore;


    private static TextView score;
    private static SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_puzzle3);

        score=(TextView)findViewById(R.id.score2);
        bestScore=(TextView)findViewById(R.id.bestscore2);


        // this code programmatically adds the PuzzleBoardView to the UI
        RelativeLayout container=(RelativeLayout)findViewById(R.id.puzzle_container);
        boardView=new PuzzleBoardView(this);

        //Some setup of view
        boardView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT));
        container.addView(boardView);

        sharedpreferences=getSharedPreferences("BestScore", Context.MODE_PRIVATE);
        setBestScore(-1);

        container.post(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.defaul_image);
                boardView.initialize(bitmap);
            }
        });


}


  /*  @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if( requestCode == 1 && resultCode == RESULT_OK ){

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            boardView.initialize(bitmap);
        }
        else{
            Toast.makeText(getApplicationContext(),"Image not selected",Toast.LENGTH_SHORT).show();
        }


    }
*/

       public void shuffleImage(View view) {
        boardView.shuffle();
    }



    public void home(View view){
        Intent in = new Intent(this,MainActivity.class);
        startActivity(in);
        finish();
    }

    public static void setScore(int Score){
        score.setText(""+Score);
        return ;
    }

    public static void setBestScore(int bScore){

        SharedPreferences.Editor editor = sharedpreferences.edit();
        String key = Integer.toString(Puzzle_level.LEVEL);

        int bestscore = sharedpreferences.getInt(key,-1);
        if(bestscore == -1 ){
            bestScore.setText("--");
        }
        else {
            bestScore.setText("" + bestscore);
        }
        if(bScore == -1){
            return ;
        }

        String tempScore=  bestScore.getText().toString();
        if(tempScore.equals("--")){
            bestScore.setText("" + bScore);
            editor.putInt(key, bScore);
            editor.commit();
            return ;
        }
        int temp = Integer.parseInt(tempScore);
        if(temp > bScore) {
            bestScore.setText("" + bScore);
            editor.putInt(key, bScore);
            editor.commit();
        }
    }
}
