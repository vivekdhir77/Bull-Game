package com.example.bullgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openRules(View view)
    {
        Toast.makeText(this, "How to Play?", Toast.LENGTH_SHORT).show();
        Intent inten=new Intent(this, rules.class);
        startActivity(inten);
    }
    public void openPlayerVSBot(View view)
    {
        Toast.makeText(this, "Player VS Computer", Toast.LENGTH_SHORT).show();
        Intent intent= new Intent(this,PlayerVSBot.class);
        startActivity(intent);
    }
    public void openPlayerVSPlayer(View view)
    {
        Toast.makeText(this, "Player V/S Player", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,PlayerVSPlayer.class);
        startActivity(intent);
    }
}