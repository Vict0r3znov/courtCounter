package com.exemple.android.courtcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    Button go;
    public EditText teamAName;
    public EditText teamBName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        go = findViewById(R.id.go);
        teamAName = findViewById(R.id.teamAName);
        teamBName = findViewById(R.id.teamBName);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!teamAName.getText().toString().equals("") && !teamBName.getText().toString().equals("")) {
                    Intent score = new Intent (MainActivity.this,ScoreActivity.class);
                    score.putExtra("TeamAName",teamAName.getText().toString());
                    score.putExtra("TeamBName",teamBName.getText().toString());
                    startActivity(score);
                }
            }
        });
         }

}
