package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tictactoe.databinding.ActivityGamePageBinding;

import java.util.ArrayList;
import java.util.List;

public class Game_Page extends AppCompatActivity {

    ActivityGamePageBinding binding;
    private  final List<int[]> combinationList = new ArrayList<>();
    private int[] boxPositions = {0,0,0,0,0,0,0,0,0};
    private int playerTurn = 1;
    private int totalselectedBoxes = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGamePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        combinationList.add(new int[] {0, 1, 2});
        combinationList.add(new int[] {3, 4, 5});
        combinationList.add(new int[] {6, 7, 8});
        combinationList.add(new int[] {0, 3, 6});
        combinationList.add(new int[] {1, 4, 7});
        combinationList.add(new int[] {2, 5, 8});
        combinationList.add(new int[] {2, 4, 6});
        combinationList.add(new int[] {0, 4, 8});


        String getPlayerOneName = getIntent().getStringExtra("PlayerOne");
        String getPlayerTwoName = getIntent().getStringExtra("PlayerTwo");

        binding.playerOneName.setText(getPlayerOneName);
        binding.playerTwoName.setText(getPlayerTwoName);
    }

    public void open1(View view){
        if(isboxselected(0)){
            performAction((ImageView) view , 0);
        }
    }
    public void open2(View view) {
        if (isboxselected(1)) {
            performAction((ImageView) view, 1);
        }
    }
    public void open3(View view) {
        if(isboxselected(2)){
            performAction((ImageView) view , 2);
        }
    }
    public void open4(View view){
        if(isboxselected(3)){
            performAction((ImageView) view , 3);
        }
    }
    public void open5(View view) {
        if (isboxselected(4)) {
            performAction((ImageView) view, 4);
        }
    }
    public void open6(View view) {
        if(isboxselected(5)){
            performAction((ImageView) view , 5);
        }
    }
    public void open7(View view){
        if(isboxselected(6)){
            performAction((ImageView) view , 6);
        }
    }
    public void open8(View view) {
        if (isboxselected(7)) {
            performAction((ImageView) view, 7);
        }
    }
    public void open9(View view) {
        if(isboxselected(8)){
            performAction((ImageView) view , 8);
        }
    }


    private void performAction(ImageView imageView, int selectedBoxPosition){
        boxPositions[selectedBoxPosition] = playerTurn;

        if (playerTurn == 1){
            imageView.setImageResource(R.drawable.x);
            if(checkResult()){
                Result_Page resultpage = new Result_Page(Game_Page.this, binding.playerOneName.getText().toString() + "is a Winner", Game_Page.this);

                resultpage.setCancelable(false);
                resultpage.show();
            }
            else if(totalselectedBoxes == 9){
                Result_Page resultPage = new Result_Page(Game_Page.this, "Match Draw",Game_Page .this);
                resultPage.setCancelable(false);
                resultPage.show();
            }
            else {
                changePlayerTurn(2);
                totalselectedBoxes ++;
            }
        }
        else {
            imageView.setImageResource(R.drawable.o);
            if(checkResult()){
                Result_Page resultpage = new Result_Page(Game_Page.this, binding.playerTwoName.getText().toString() + "is a Winner", Game_Page.this);

                resultpage.setCancelable(false);
                resultpage.show();
            }
            else if(totalselectedBoxes == 9){
                Result_Page resultPage = new Result_Page(Game_Page.this, "Match Draw",Game_Page .this);
                resultPage.setCancelable(false);
                resultPage.show();
            }
            else {
                changePlayerTurn(1);
                totalselectedBoxes ++;
            }
        }
    }

    private  void changePlayerTurn(int currentPlayerTurn){
        playerTurn = currentPlayerTurn;
        if(playerTurn == 1){
            binding.onelayout.setBackgroundResource(R.drawable.board);
            binding.twolayout.setBackgroundResource(R.drawable.box);
        }
        else {
            binding.twolayout.setBackgroundResource(R.drawable.board);
            binding.onelayout.setBackgroundResource(R.drawable.box);
        }
    }
    private boolean checkResult(){
        boolean responce = false;
        for(int i = 0 ; i<combinationList.size(); i++){
            final int [] combination = combinationList.get(i);

            if(boxPositions[combination[0]] == playerTurn && boxPositions [combination[1]] == playerTurn && boxPositions[combination[2]] == playerTurn){
                responce = true;
            }
        }
        return  responce;
    }

    private boolean isboxselected(int boxPosition){
        boolean responce = false;
        if(boxPositions[boxPosition] == 0){
            responce = true;
        }
        return responce;
    }

    public  void  restartMatch(){
        boxPositions = new  int[] {0,0,0,0,0,0,0,0,0};
        playerTurn = 1;
        totalselectedBoxes = 1;

        binding.image1.setImageResource(R.drawable.box);
        binding.image2.setImageResource(R.drawable.box);
        binding.image3.setImageResource(R.drawable.box);
        binding.image4.setImageResource(R.drawable.box);
        binding.image5.setImageResource(R.drawable.box);
        binding.image6.setImageResource(R.drawable.box);
        binding.image7.setImageResource(R.drawable.box);
        binding.image8.setImageResource(R.drawable.box);
        binding.image9.setImageResource(R.drawable.box);

    }

}