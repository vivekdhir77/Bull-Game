package com.example.bullgame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

import java.util.Random;

public class PlayerVSBot extends AppCompatActivity {
    Button Check, Reveal,NewGame;
    EditText inputText;
    TextView randomNum, AnswerBox;

    String bull_no;
    int r,count=0;
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
    // TextView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_v_s_bot);
        Check = findViewById(R.id.Check);
        Reveal = findViewById(R.id.Reveal);
        NewGame = findViewById(R.id.NewGame);

        inputText = findViewById(R.id.inputText);


        randomNum = findViewById(R.id.randomNum);
        AnswerBox = findViewById(R.id.AnswerBox);

        Random rand = new Random();
        r= rand.nextInt(1000);
        bull_no = String.valueOf(r);
        int len= bull_no.length();
        if (len<3) {
            if (len == 2)
                bull_no = "0" + bull_no;
            else
                bull_no = "00" + bull_no;
        }


        Check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            count+=1;
            String inp= inputText.getText().toString();

            if (checker(inp))
                AnswerBox.setText("Invalid Input");

            int bull = bull_(bull_no,inp);
            int cow = cow_(bull_no,inp);

            if (bull==3)
            {
                randomNum.setText("");
                if(count!=1) {
                    AnswerBox.setText("\n\nCongratulations!! \n Your took " + count + " guesses \n to find the bull's weight");
                }
                else
                    AnswerBox.setText("\n\nAwesome!! \n Your just took "+count+" guess \n to find the bull's weight");
                ImageView img=(ImageView)findViewById(R.id.imageView2);
                img.setVisibility(View.VISIBLE);
            }
            else if (cow==0 && bull==0)
                AnswerBox.setText("SHIT !!");
            else
                AnswerBox.setText("BULL = "+ bull+"    COW = "+cow);
            }

        });


        Reveal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomNum.setText(bull_no);
            }
        });

        NewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r= rand.nextInt(1000);
                bull_no = String.valueOf(r);
                int len= bull_no.length();
                if (len<3) {
                    if (len == 2)
                        bull_no = "0" + bull_no;
                    else
                        bull_no = "00" + bull_no;
                }
                count=0;
                randomNum.setText("");
                AnswerBox.setText("");
            }
        });

    }
}