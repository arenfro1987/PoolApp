package com.innovateeverything.drenfro87.poolapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class selectGameType extends AppCompatActivity {
    Button startRace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_game_type);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        startRace = (Button) findViewById(R.id.toGameButton);

        startRace.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent gameType = new Intent(selectGameType.this, selectPlayers.class);
                startActivity(gameType);
            }
        });


    }

}
