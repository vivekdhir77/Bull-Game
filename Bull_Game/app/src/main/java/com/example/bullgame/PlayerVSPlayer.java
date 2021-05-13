package com.example.bullgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayerVSPlayer extends AppCompatActivity {
    Button Revealer, Checker, goNext;

    EditText NumberInput;

    TextView infoBox, revealNum, Result;

    int count =0, winner=0;
    boolean check=true;
    String p1, p2, g1,g2;
    //-----------------------------------------------------------------
    static int bull_(String bull_no, String inp)
    {
        int ans=0;
        String b = bull_no;
        String in = inp;
        if (b.charAt(0)==in.charAt(0))
            ans++;
        if (b.charAt(1)==in.charAt(1))
            ans++;
        if (b.charAt(2)==in.charAt(2))
            ans++;
        return ans;
    }

    static int cow_(String bull_no, String inp)
    {
        int ans=0;
        String b = bull_no.toString();
        String in = inp.toString();
        int bNo[], iNo[];
        bNo = new int[256];
        iNo = new int[256];
        for (int i=0;i<3;i++)
        {
            bNo[b.charAt(i)]++;
            iNo[in.charAt(i)]++;
        }
        for (int i = 0; i < 256; i++) {
            // If freq1[i] and freq2[i] both exceeds 0
            if (bNo[i] > 0 & iNo[i] > 0) {
                ans+= Math.min(bNo[i],iNo[i]);
            }
        }
        ans = ans - bull_(bull_no,inp);
        return ans;
    }

    static boolean checker(String s)
    {
        try {
            int d = Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        if (s.length()!=3)
            return true;
        else
            return false;
    }
    //-----------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_v_s_player);
        Revealer = findViewById(R.id.Revealer);
        Checker = findViewById(R.id.Checker);
        goNext = findViewById(R.id.goNext);

        NumberInput = findViewById(R.id.NumberInput);

        infoBox = findViewById(R.id.InfoBox);
        revealNum = findViewById(R.id.revealNum);
        Result = findViewById(R.id.Result);

        infoBox.setText("Player 1: Enter your number to be guessed");
//        p1 = NumberInput.getText().toString();
//        count++;


        Checker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check) {
                    if (count % 2 == 0 && count !=0 ) {
                        infoBox.setText("Player 1: Enter your guess");
                        g1 = NumberInput.getText().toString();
                        if(checker(g1))
                            Result.setText("INVALID INPUT");
                        else{
                            int bull1 = bull_(p2, g1);
                            int cow1 = cow_(p2, g1);
                            if (bull1 == 3) {
                                Result.setText("Player 1 wins!!");
                                ImageView img=(ImageView)findViewById(R.id.imageView);
                                img.setVisibility(View.VISIBLE);
                                winner=1;
                                check = false;
                            }
                            else
                                Result.setText("BULL = " + bull1 + "   COW = " + cow1);
                        }
//                        count++;
//                        infoBox.setText("Player 2: Enter your guess");
                    }
                    else if  (count % 2 == 1 && count !=1 ){
                        infoBox.setText("Player 2: Enter your guess");
                        g2 = NumberInput.getText().toString();
                        if (checker(g2)   )
                            Result.setText("INVALID INPUT");
                        else {
                            int bull2 = bull_(p1, g2);
                            int cow2 = cow_(p1, g2);
                            if (bull2 == 3) {
                                Result.setText("Player 2 wins!!");
                                ImageView img=(ImageView)findViewById(R.id.imageView);
                                img.setVisibility(View.VISIBLE);
                                winner=2;
                                check = false;
                            }
                            else
                                Result.setText("BULL = " + bull2 + "   COW = " + cow2);
                        }
//                        count++;
//                        infoBox.setText("Player 1: Enter your guess");
                    }
                    else
                    {
                        Result.setText("INVALID BUTTON");
                    }

                }
                else
                {
                    Result.setText("Player "+winner+" wins!!");
                }
            }
        });
        goNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check) {
                    if (count == 0) {
                        Result.setText("");
                        p1 = NumberInput.getText().toString();
                        count++;
                        infoBox.setText("Player 2: Enter your number to be guessed");
                    } else if (count == 1) {
                        Result.setText("");
                        infoBox.setText("Player 2: Enter your number to be guessed");
                        p2 = NumberInput.getText().toString();
                        count++;
                        infoBox.setText("Player 1: Enter your guess");
                    } else if (count % 2 == 0 && count != 1) {
                        count++;
                        infoBox.setText("Player 2: Enter your guess");
                    } else {
                        count++;
                        infoBox.setText("Player 1: Enter your guess");
                    }
                }
                }


        });



        Revealer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                revealNum.setText("Player 1: "+p1+"\nPlayer 2: "+p2);
            }
        });
    }
}