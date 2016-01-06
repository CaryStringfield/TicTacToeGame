package edu.uco.vstringfield.p3virgil_s;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private boolean win;
    private int move;
    private int gameNumber;
    private String winner;
    private String turn;
    private ArrayList <String> gameLog = new ArrayList<String>();
    private String[] theMoves = new String[10];
    private ImageButton Button1;
    private ImageButton Button2;
    private ImageButton Button3;
    private ImageButton Button4;
    private ImageButton Button5;
    private ImageButton Button6;
    private ImageButton Button7;
    private ImageButton Button8;
    private ImageButton Button9;
    private ImageButton NewButton;
    private ImageButton LogButton;
    private ImageView gameStates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        win = false;
        move = 1;
        gameNumber = 1;
        winner = "In Progress";
        turn = "O";
        for(int i = 0; i < 10; i++)
        {
            theMoves[i] = " ";
        }//end for


        Button1 = (ImageButton) findViewById(R.id.Button1);
        Button2 = (ImageButton) findViewById(R.id.Button2);
        Button3 = (ImageButton) findViewById(R.id.Button3);
        Button4 = (ImageButton) findViewById(R.id.Button4);
        Button5 = (ImageButton) findViewById(R.id.Button5);
        Button6 = (ImageButton) findViewById(R.id.Button6);
        Button7 = (ImageButton) findViewById(R.id.Button7);
        Button8 = (ImageButton) findViewById(R.id.Button8);
        Button9 = (ImageButton) findViewById(R.id.Button9);
        NewButton = (ImageButton) findViewById(R.id.NewButton);
        LogButton = (ImageButton) findViewById(R.id.LogButton);

        gameStates= (ImageView) findViewById(R.id.imageGameStates);

        //gameLog.add("" + gameNumber + "     "  + winner);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        NumButtonListener listen = new NumButtonListener();

        Button1.setOnClickListener(listen);
        Button2.setOnClickListener(listen);
        Button3.setOnClickListener(listen);
        Button4.setOnClickListener(listen);
        Button5.setOnClickListener(listen);
        Button6.setOnClickListener(listen);
        Button7.setOnClickListener(listen);
        Button8.setOnClickListener(listen);
        Button9.setOnClickListener(listen);

        NewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button1.setEnabled(true);
                Button1.setBackgroundResource(R.drawable.square);

                Button2.setEnabled(true);
                Button2.setBackgroundResource(R.drawable.square);

                Button3.setEnabled(true);
                Button3.setBackgroundResource(R.drawable.square);

                Button4.setEnabled(true);
                Button4.setBackgroundResource(R.drawable.square);

                Button5.setEnabled(true);
                Button5.setBackgroundResource(R.drawable.square);

                Button6.setEnabled(true);
                Button6.setBackgroundResource(R.drawable.square);

                Button7.setEnabled(true);
                Button7.setBackgroundResource(R.drawable.square);

                Button8.setEnabled(true);
                Button8.setBackgroundResource(R.drawable.square);

                Button9.setEnabled(true);
                Button9.setBackgroundResource(R.drawable.square);

                gameNumber++;
                win = false;
                move = 1;
                gameStates.setBackgroundResource(R.drawable.oturn);
                winner = "In Progress";
                turn = "O";
                for(int i = 0; i < 10; i++)
                {
                    theMoves[i] = " ";
                }//end for

            }
        });//end new listener

        LogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent log = new Intent(getApplicationContext(), TheLog.class);
                log.putStringArrayListExtra("gameLog",gameLog);
                startActivity(log);
            }
        });//end log listener


        return true;
    }

    private class NumButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (turn == "X")
            {
                v.setBackgroundResource(R.drawable.xx);
                if(v == Button1)
                {
                    theMoves[1] = "X";
                }// end if v = button1
                if(v == Button2)
                {
                    theMoves[2] = "X";
                }// end if v = button2
                if(v == Button3)
                {
                    theMoves[3] = "X";
                }// end if v = button3
                if(v == Button4)
                {
                    theMoves[4] = "X";
                }// end if v = button4
                if(v == Button5)
                {
                    theMoves[5] = "X";
                }// end if v = button5
                if(v == Button6)
                {
                    theMoves[6] = "X";
                }// end if v = button6
                if(v == Button7)
                {
                    theMoves[7] = "X";
                }// end if v = button7
                if(v == Button8)
                {
                    theMoves[8] = "X";
                }// end if v = button8
                if(v == Button9)
                {
                    theMoves[9] = "X";
                }// end if v = button9
                checkForWin();
            }// if turn = x
            else
            {
                v.setBackgroundResource(R.drawable.oo);
                if(v == Button1)
                {
                    theMoves[1] = "O";
                }// end if v = button1
                if(v == Button2)
                {
                    theMoves[2] = "O";
                }// end if v = button2
                if(v == Button3)
                {
                    theMoves[3] = "O";
                }// end if v = button3
                if(v == Button4)
                {
                    theMoves[4] = "O";
                }// end if v = button4
                if(v == Button5)
                {
                    theMoves[5] = "O";
                }// end if v = button5
                if(v == Button6)
                {
                    theMoves[6] = "O";
                }// end if v = button6
                if(v == Button7)
                {
                    theMoves[7] = "O";
                }// end if v = button7
                if(v == Button8)
                {
                    theMoves[8] = "O";
                }// end if v = button8
                if(v == Button9)
                {
                    theMoves[9] = "O";
                }// end if v = button9
                checkForWin();
            }//end else (turn = o)
        v.setEnabled(false);
    }//end onClick
}//end class

    public void setTurn()
    {
        move ++;
        if(move > 9)
        {
            setWinner("Draw");

        }
        else if(turn == "O")
        {
            turn = "X";
            gameStates.setBackgroundResource(R.drawable.xturn);
        }//end if turn = O
        else
        {
            turn = "O";
            gameStates.setBackgroundResource(R.drawable.oturn);
        }//end else (turn = x)
    }//end set turn

    public void setWinner(String theWinner)
    {
        winner = theWinner;
        gameLog.add("   " + gameNumber + "            " + winner);

        Button1.setEnabled(false);
        Button2.setEnabled(false);
        Button3.setEnabled(false);
        Button4.setEnabled(false);
        Button5.setEnabled(false);
        Button6.setEnabled(false);
        Button7.setEnabled(false);
        Button8.setEnabled(false);
        Button9.setEnabled(false);

        if(winner == "X")
        {
            gameStates.setBackgroundResource(R.drawable.xwin);
        }//end if winner x

        if(winner == "O")
        {
            gameStates.setBackgroundResource(R.drawable.owin);
        }//end if winner o

        if(winner == "Draw")
        {
            gameStates.setBackgroundResource(R.drawable.draw);
        }//end if draw
    }//end set winner

    public void checkForWin()
    {
        if(move > 4)
        {
            if(theMoves[1] == turn && theMoves[2] == turn && theMoves[3] == turn)
            {
                win = true;
                if(turn == "X")
                {
                    Button1.setBackgroundResource(R.drawable.bx);
                    Button2.setBackgroundResource(R.drawable.bx);
                    Button3.setBackgroundResource(R.drawable.bx);
                }//end turn = x
                else
                {
                    Button1.setBackgroundResource(R.drawable.bo);
                    Button2.setBackgroundResource(R.drawable.bo);
                    Button3.setBackgroundResource(R.drawable.bo);
                }
            }//end if for win pattern 123

            if(theMoves[1] == turn && theMoves[4] == turn && theMoves[7] == turn)
            {
                win = true;
                if(turn == "X")
                {
                    Button1.setBackgroundResource(R.drawable.bx);
                    Button4.setBackgroundResource(R.drawable.bx);
                    Button7.setBackgroundResource(R.drawable.bx);
                }//end turn = x
                else
                {
                    Button1.setBackgroundResource(R.drawable.bo);
                    Button4.setBackgroundResource(R.drawable.bo);
                    Button7.setBackgroundResource(R.drawable.bo);
                }
            }//end if for win pattern 147

            if(theMoves[1] == turn && theMoves[5] == turn && theMoves[9] == turn)
            {
                win = true;
                if(turn == "X")
                {
                    Button1.setBackgroundResource(R.drawable.bx);
                    Button5.setBackgroundResource(R.drawable.bx);
                    Button9.setBackgroundResource(R.drawable.bx);
                }//end turn = x
                else
                {
                    Button1.setBackgroundResource(R.drawable.bo);
                    Button5.setBackgroundResource(R.drawable.bo);
                    Button9.setBackgroundResource(R.drawable.bo);
                }
            }//end if for win pattern 159

            if(theMoves[2] == turn && theMoves[5] == turn && theMoves[8] == turn)
            {
                win = true;
                if(turn == "X")
                {
                    Button2.setBackgroundResource(R.drawable.bx);
                    Button5.setBackgroundResource(R.drawable.bx);
                    Button8.setBackgroundResource(R.drawable.bx);
                }//end turn = x
                else
                {
                    Button2.setBackgroundResource(R.drawable.bo);
                    Button5.setBackgroundResource(R.drawable.bo);
                    Button8.setBackgroundResource(R.drawable.bo);
                }
            }//end if for win pattern 258

            if(theMoves[3] == turn && theMoves[6] == turn && theMoves[9] == turn)
            {
                win = true;
                if(turn == "X")
                {
                    Button9.setBackgroundResource(R.drawable.bx);
                    Button6.setBackgroundResource(R.drawable.bx);
                    Button3.setBackgroundResource(R.drawable.bx);
                }//end turn = x
                else
                {
                    Button9.setBackgroundResource(R.drawable.bo);
                    Button6.setBackgroundResource(R.drawable.bo);
                    Button3.setBackgroundResource(R.drawable.bo);
                }
            }//end if for win pattern 369

            if(theMoves[4] == turn && theMoves[5] == turn && theMoves[6] == turn)
            {
                win = true;
                if(turn == "X")
                {
                    Button4.setBackgroundResource(R.drawable.bx);
                    Button5.setBackgroundResource(R.drawable.bx);
                    Button6.setBackgroundResource(R.drawable.bx);
                }//end turn = x
                else
                {
                    Button4.setBackgroundResource(R.drawable.bo);
                    Button5.setBackgroundResource(R.drawable.bo);
                    Button6.setBackgroundResource(R.drawable.bo);
                }
            }//end if for win pattern 456

            if(theMoves[7] == turn && theMoves[8] == turn && theMoves[9] == turn)
            {
                win = true;
                if(turn == "X")
                {
                    Button7.setBackgroundResource(R.drawable.bx);
                    Button8.setBackgroundResource(R.drawable.bx);
                    Button9.setBackgroundResource(R.drawable.bx);
                }//end turn = x
                else
                {
                    Button7.setBackgroundResource(R.drawable.bo);
                    Button8.setBackgroundResource(R.drawable.bo);
                    Button9.setBackgroundResource(R.drawable.bo);
                }
            }//end if for win pattern 789

            if(theMoves[7] == turn && theMoves[5] == turn && theMoves[3] == turn)
            {
                win = true;
                if(turn == "X")
                {
                    Button7.setBackgroundResource(R.drawable.bx);
                    Button5.setBackgroundResource(R.drawable.bx);
                    Button3.setBackgroundResource(R.drawable.bx);
                }//end turn = x
                else
                {
                    Button7.setBackgroundResource(R.drawable.bo);
                    Button5.setBackgroundResource(R.drawable.bo);
                    Button3.setBackgroundResource(R.drawable.bo);
                }
            }//end if for win pattern 753
        }//end if move > 4

        if (win)
        {
            setWinner(turn);
        }
        else
        {
            setTurn();
        }

    }// end check for win

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
