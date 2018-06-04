package com.exemple.android.courtcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class ScoreActivity extends AppCompatActivity implements YellowCardDialog.PlayerName,RedCardDialog.PlayerName,Serializable {
    int scoreA = 0;
    int scoreB = 0;
    ArrayList<String> yellowRedCard = new ArrayList<>();
    Button stats;
    String whichTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        TextView a = findViewById(R.id.A);
        TextView b = findViewById(R.id.B);
        Button yellowA = findViewById(R.id.yellowA);
        Button yellowB = findViewById(R.id.yellowB);
        Button redA = findViewById(R.id.redA);
        Button redB = findViewById(R.id.redB);
        stats = findViewById(R.id.stat);
        final String teamA = getIntent().getStringExtra("TeamAName");
        final String teamB = getIntent().getStringExtra("TeamBName");
        a.setText(teamA);
        b.setText(teamB);
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);

        yellowA.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startYellowDialog();
               whichTeam = teamA;
           }
       });

        yellowB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startYellowDialog();
                whichTeam = teamB;

            }
        });

        redA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRedDialog();
                whichTeam = teamA;

            }
        });

        redB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRedDialog();
                whichTeam = teamB;
            }
        });
        final LinearLayout buttons = findViewById( R.id.buttons );
        final LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        stats.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i=0;i<yellowRedCard.size();i++){
                    final TextView Tv = new TextView( ScoreActivity.this );
                    Tv.setLayoutParams( lParams );
                    Tv.setText( yellowRedCard.get(i) );
                    Tv.setGravity( Gravity.CENTER );
                    Tv.setTextSize( 18 );
                    buttons.addView( Tv );
                }
            }
        } );
    }


    public void displayForTeamA(int score) {
        TextView scoreView = findViewById(R.id.score_A);
        scoreView.setText(String.valueOf(score));
    }
    public void displayForTeamB(int number) {
        TextView scoreView = findViewById(R.id.score_B);
        scoreView.setText(String.valueOf(number));
    }
    public void goalA(View view){
        scoreA++;
        displayForTeamA(scoreA);
    }
    public void goalB(View view){
        scoreB++;
        displayForTeamB(scoreB);
    }
    public void reset(View v){
        scoreA = 0;
        scoreB = 0;
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
    }

    public void startYellowDialog(){
        YellowCardDialog carddialog =  new YellowCardDialog();
        carddialog.show(getSupportFragmentManager(),"Card Dialog");
    }

    public void startRedDialog(){
        RedCardDialog cardDialog = new RedCardDialog();
        cardDialog.show(getSupportFragmentManager(),"Card Dialog");
    }

    @Override
    public void getYellowName(String playerName) {
        yellowRedCard.add("Yellow Card : "+playerName+" From "+whichTeam);
    }

    @Override
    public void getRedName(String name) {
        yellowRedCard.add("Red Card : "+name+" From "+whichTeam);
    }
}