package com.example.project;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;


public class Math1s extends AppCompatActivity {
    private ProgressBar progressBar;
    int score=0;
    public static final String  EXTRA_NUMBER="com.example.project.EXTRA_NUMBER";
    private Button correct,incorrect;
    private boolean isPause;

    private TextView txtScore, txtSum, txtOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math1s);
        initialize_Component();

        initialize_Data();
    }

    private void initialize_Component(){

        txtScore=(TextView)findViewById(R.id.txtScore);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        txtOperation=(TextView)findViewById(R.id.txtOperation);
        txtSum=(TextView)findViewById(R.id.txtSum);

        setup_countdown();
        //---------------------
        correct=findViewById(R.id.correct);
        incorrect=findViewById(R.id.incorrect);
        correct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sum==fake_sum){
                    isPause=false;
                    initialize_Data();
                    timer.start();
                    score++;
                    txtScore.setText(String.valueOf(score));

                }else{
                    isPause=true;
                    gameOver();


                }

            }
        });
        incorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sum!=fake_sum){
                    isPause=false;
                    initialize_Data();
                    timer.start();
                    score++;
                    txtScore.setText(String.valueOf(score));
                }else{
                    isPause=true;
                    gameOver();

                }
            }
        });

        //----------

    }
    private CountDownTimer timer;
    private void setup_countdown(){
        timer =new CountDownTimer(1200,50){
            public void onTick(long millisUntilFinished) {
                if(isPause){
                    cancel();

                }
                progressBar.setProgress((int)(millisUntilFinished/10));
            }

            public void onFinish() {
                gameOver();

            }
        };
    }

    int sum=0, fake_sum=0;

    private void initialize_Data(){
        int a=random_Number();
        int b=random_Number();
        sum=a+b;
        fake_sum=random_Number2();
        txtOperation.setText(String.format("%s+%s",a,b));
        int randomTrueFalse =random_Number();
        if(randomTrueFalse%2==0){
            txtSum.setText(String.format("= %s",sum));
            fake_sum=sum;
        }
        else {
            txtSum.setText(String.format("= %s",fake_sum));
        }


    }

    private int random_Number(){
        Random r=new Random();
        int i=r.nextInt(30)+1;
        return i;
    }

    private int random_Number2(){
        Random r=new Random();
        int i=r.nextInt(60)+1;
        return i;
    }

    public  void gameOver(){

        Intent intent=new Intent(getApplicationContext(),Math1s_gameover.class);
        intent.putExtra(EXTRA_NUMBER,score);
        startActivity(intent);
    }


}
