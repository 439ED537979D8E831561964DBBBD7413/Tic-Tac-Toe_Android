package com.example.unkwn.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class tttActivity extends AppCompatActivity {
    Button[] buttons;
    int turn;
     public void checkGame(){
         for(int i = 0; i < 9; i+=3){
             checkWinner(buttons[i],buttons[i+1],buttons[i+2]);
         }
         for(int i = 0; i < 3; i++){
             checkWinner(buttons[i],buttons[i+3],buttons[i+6]);
         }
        checkWinner(buttons[0],buttons[4],buttons[8]);
        checkWinner(buttons[2],buttons[4],buttons[6]);
    }

    public void checkWinner(Button b1,Button b2,Button b3){
        if (b1.getText().equals(b2.getText()) && b2.getText().equals(b3.getText()) && b3.getText().equals("X")){
            Toast.makeText(tttActivity.this, String.format("player %s is winner ", turn),Toast.LENGTH_LONG).show();
        }
    }
    public void reset(View view){
        turn =1;
        for(Button b : buttons){
            b.setText("");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startup);
    }
    public void start(View view){
        setContentView(R.layout.activity_ttt);
        buttons = new Button[]{
            (Button) findViewById(R.id.b1),
            (Button) findViewById(R.id.b2),
            (Button) findViewById(R.id.b3),
            (Button) findViewById(R.id.b4),
            (Button) findViewById(R.id.b5),
            (Button) findViewById(R.id.b6),
            (Button) findViewById(R.id.b7),
            (Button) findViewById(R.id.b8),
            (Button) findViewById(R.id.b9)
        };
        turn=1;

        for(final Button b : buttons){
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setButtonText(b);
                }
            });
        }
    }
    public void setButtonText(Button b){
        if (b.getText().toString().equals("")){
            if (turn==1) {
                b.setText("X");
                turn = 2;
            }
            else if (turn==2) {
                b.setText("O");
                turn = 1;
            }
        }
        checkGame();
    }
}
