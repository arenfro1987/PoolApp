package com.innovateeverything.drenfro87.poolapp;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainGame extends AppCompatActivity {

    TextView player1;
    TextView player2;
    ImageView player1Ball;
    ImageView player2Ball;
    Button player1Minus;
    Button player1Plus;
    Button player2Minus;
    Button player2Plus;
    Intent intent;
    Game currentGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        player1 = (TextView) findViewById(R.id.player1GameView);
        player2 = (TextView) findViewById(R.id.player2GameView);
        player1Ball = (ImageView) findViewById(R.id.player1Ball);
        player2Ball = (ImageView) findViewById(R.id.player2Ball);
        player1Minus = (Button) findViewById(R.id.player1MinusButton);
        player1Plus = (Button) findViewById(R.id.player1PlusButton);
        player2Minus = (Button) findViewById(R.id.player2Minusbutton);
        player2Plus = (Button) findViewById(R.id.player2PlusButton);
        intent = getIntent();
        currentGame = (Game) intent.getSerializableExtra("game");
        player1.setText(currentGame.getPlayers().get(0).getName());
        player2.setText(currentGame.getPlayers().get(1).getName());

        player1Ball.setImageResource(R.drawable.billiardballcue);
        player2Ball.setImageResource(R.drawable.billiardballcue);

        player1Minus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentGame.getPlayers().get(0).setGamesWon(currentGame.getPlayers().get(0).getGamesWon() - 1);
                updateBall(player1Ball,0);
                checkWin();
            }


        });

        player1Plus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentGame.getPlayers().get(0).setGamesWon(currentGame.getPlayers().get(0).getGamesWon() + 1);
                updateBall(player1Ball,0);
                checkWin();
            }


        });

        player2Minus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentGame.getPlayers().get(1).setGamesWon(currentGame.getPlayers().get(1).getGamesWon() - 1);
                updateBall(player2Ball,1);
                checkWin();
            }


        });

        player2Plus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentGame.getPlayers().get(1).setGamesWon(currentGame.getPlayers().get(1).getGamesWon() + 1);
                updateBall(player2Ball,1);
                checkWin();
            }


        });


    }

    private void updateBall(ImageView playerBall,int playerNumber) {
        switch (currentGame.getPlayers().get(playerNumber).getGamesWon()){
            case 0: playerBall.setImageResource(R.drawable.billiardballcue);
                break;
            case 1:playerBall.setImageResource(R.drawable.ball1);
                break;
            case 2:playerBall.setImageResource(R.drawable.ball2);
                break;
            case 3:playerBall.setImageResource(R.drawable.billiardball3);
                break;
            case 4:playerBall.setImageResource(R.drawable.billiardball4);
                break;
            case 5:playerBall.setImageResource(R.drawable.billiardball5);
                break;
            case 6:playerBall.setImageResource(R.drawable.billiardball6);
                break;
            case 7:playerBall.setImageResource(R.drawable.billiardball7);
                break;
            case 8:playerBall.setImageResource(R.drawable.billiardball8);
                break;
            case 9:playerBall.setImageResource(R.drawable.billiardball9);
                break;
            case 10:playerBall.setImageResource(R.drawable.billiardball10);
                break;
            case 11:playerBall.setImageResource(R.drawable.billiardball11);
                break;
            case 12:playerBall.setImageResource(R.drawable.billiardball12);
                break;
            case 13:playerBall.setImageResource(R.drawable.billiardball13);
                break;
            case 14:playerBall.setImageResource(R.drawable.billiardball14);
                break;
            case 15:playerBall.setImageResource(R.drawable.billiardball15);
                break;
            default:
                break;
        }

    }
    private void checkWin() {
        int player1Points = currentGame.getPlayers().get(0).getGamesWon();
        int player2Points = currentGame.getPlayers().get(1).getGamesWon();
        int player1Handi = currentGame.getPlayers().get(0).getHandicap();
        int player2Handi = currentGame.getPlayers().get(1).getHandicap();
        int toWin = currentGame.getGameTo();
        if(player1Points >= toWin + player1Handi)
        {
            playerWin(0);
        }
        else if(player2Points >= toWin + player2Handi)
        {
            playerWin(1);
        }
    }

    private void playerWin(int player) {
        FragmentManager fm = getFragmentManager();
        Bundle args = new Bundle();
        args.putString("name", currentGame.getPlayers().get(player).getName());
        DialogFragment newFragment = new WinnerFragment();
        newFragment.setArguments(args);
        newFragment.show(fm, "abc");
    }

    public void doPositiveClick() {
        //restart
        currentGame.getPlayers().get(0).setGamesWon(0);
        currentGame.getPlayers().get(1).setGamesWon(0);
        updateBall(player1Ball, 0);
        updateBall(player2Ball,1);

    }

    public void doNegativeClick() {
        //reset
        Intent gameType = new Intent(MainGame.this, MainActivity.class);
        startActivity(gameType);
    }
}
