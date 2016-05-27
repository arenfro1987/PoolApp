package com.innovateeverything.drenfro87.poolapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

public class selectPlayers extends AppCompatActivity {

    NumberPicker races;
    EditText player1;
    EditText player2;
    Button toHandi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_players);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        player1 = (EditText) findViewById(R.id.player1EditText);
        player2 = (EditText) findViewById(R.id.player2EditText);
        toHandi = (Button) findViewById(R.id.toGameButton);

        races = (NumberPicker) findViewById(R.id.player1HandiPicker);

        races.setMinValue(1);
        races.setMaxValue(10);

        toHandi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent gameType = new Intent(selectPlayers.this, SelectHandicap.class);

                Player playerOne = new Player();
                Player playerTwo = new Player();
                Game currentGame = new Game();

                playerOne.setName(player1.getText().toString());
                playerTwo.setName(player2.getText().toString());
                currentGame.setGameTo(races.getValue());
                currentGame.addPlayers(playerOne);
                currentGame.addPlayers(playerTwo);

                gameType.putExtra("game",currentGame);


                startActivity(gameType);
            }
        });




    }

}
