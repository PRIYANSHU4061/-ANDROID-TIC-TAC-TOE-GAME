package com.example.tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result_Page extends Dialog {

    private  final  String message;
    private  final  Game_Page gamePage;


    public Result_Page(@NonNull Context context , String message, Game_Page gamePage){
        super(context);
        this.message = message;
        this.gamePage = gamePage;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);

        TextView messageText = findViewById(R.id.messageText);
        Button button = findViewById(R.id.startAgain);

        messageText.setText(message);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gamePage.restartMatch();
                dismiss();
            }
        });
    }
}