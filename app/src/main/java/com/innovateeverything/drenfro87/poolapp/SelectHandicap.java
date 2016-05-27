package com.innovateeverything.drenfro87.poolapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

public class SelectHandicap extends AppCompatActivity {

    private NumberPicker player1Handi;
    private NumberPicker player2Handi;
    private TextView player1;
    private TextView player2;
    private Button startGame;
    private Game currentGame;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_handicap);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        player1 = (TextView) findViewById(R.id.player1TextView);
        player2 = (TextView) findViewById(R.id.player2TextView);
        player1Handi = (NumberPicker) findViewById(R.id.player1HandiPicker);
        player2Handi = (NumberPicker) findViewById(R.id.player2HandiPicker);
        startGame = (Button) findViewById(R.id.toGameButton);
        intent = getIntent();
        currentGame = (Game)intent.getSerializableExtra("game");

        player1Handi.setMaxValue(10);
        //player1Handi.setMinValue(-10);
        //player2Handi.setMinValue(-10);
        player2Handi.setMaxValue(10);
        //player1Handi.setValue(0);
        //player2Handi.setValue(0);
        player2.setText(currentGame.getPlayers().get(1).getName());
        player1.setText(currentGame.getPlayers().get(0).getName());

        startGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent gameType = new Intent(SelectHandicap.this, MainGame.class);

                currentGame.getPlayers().get(0).setHandicap(player1Handi.getValue());
                currentGame.getPlayers().get(1).setHandicap(player2Handi.getValue());

                gameType.putExtra("game",currentGame);


                startActivity(gameType);
            }
        });


    }

}

