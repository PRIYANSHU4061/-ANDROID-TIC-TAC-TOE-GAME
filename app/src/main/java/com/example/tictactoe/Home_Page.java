package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Home_Page extends AppCompatActivity {

    EditText playerOne;
    EditText playerTwo;

    Button button ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        playerOne = findViewById(R.id.playerOne);
        playerTwo = findViewById(R.id.playerTwo);
        button = findViewById(R.id.StartGame);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getPlayerOneName = playerOne.getText().toString();
                String getPlayerTwoName = playerTwo.getText().toString();

                if(getPlayerOneName.isEmpty() || getPlayerTwoName.isEmpty()){
                    Toast.makeText(Home_Page.this, "Enter players name", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(Home_Page.this, Game_Page.class);
                    intent.putExtra("playerOne", getPlayerOneName);
                    intent.putExtra("playerTwo", getPlayerTwoName);
                    startActivity(intent);
                }
            }
        });
    }
}