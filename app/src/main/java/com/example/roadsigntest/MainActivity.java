package com.example.roadsigntest;

import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final int numberOfQuestions = RoadQuiz.roadSigns.length;
    private int currentQuestionIndex = 0;
    private int score;
    private String selectedAnswer = "";

    private TextView questionNumberView;
    private ImageView signImageView;
    private Button option1, option2, option3, option4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referencing Views
        questionNumberView = findViewById(R.id.questionNumber);
        signImageView = findViewById(R.id.signImageView);
        option1 = findViewById(R.id.button);
        option2 = findViewById(R.id.button2);
        option3 = findViewById(R.id.button3);
        option4 = findViewById(R.id.button4);
        Button submitButton = findViewById(R.id.submitButton);

        //Set OnClickListener
        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        option4.setOnClickListener(this);
        submitButton.setOnClickListener(this);

        questionNumberView.setText("Question " + (currentQuestionIndex + 1)+ " out of " + numberOfQuestions);

        setNewQuestion();



    }


    @Override
    public void onClick(View view) {
        option1.setBackgroundColor(getColor(R.color.defaultButtonColor));
        option2.setBackgroundColor(getColor(R.color.defaultButtonColor));
        option3.setBackgroundColor(getColor(R.color.defaultButtonColor));
        option4.setBackgroundColor(getColor(R.color.defaultButtonColor));
        Button clickedButton = (Button) view;
        if(clickedButton.getId() == R.id.submitButton){
            if(selectedAnswer.equals(RoadQuiz.correctAnswers[currentQuestionIndex])) {
                score++;
            }
            currentQuestionIndex ++;
            questionNumberView.setText("Question " + (currentQuestionIndex + 1)+ " out of " + numberOfQuestions);
            setNewQuestion();

        }else{
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(getColor(R.color.selectedColor));

        }
    }

    void setNewQuestion(){
        if(currentQuestionIndex==7){

            finishQuiz();
            return;
        }


        signImageView.setImageResource(RoadQuiz.roadSigns[currentQuestionIndex]);
        option1.setText(RoadQuiz.choices[currentQuestionIndex][0]);
        option2.setText(RoadQuiz.choices[currentQuestionIndex][1]);
        option3.setText(RoadQuiz.choices[currentQuestionIndex][2]);
        option4.setText(RoadQuiz.choices[currentQuestionIndex][3]);
    }

    void finishQuiz(){
        new AlertDialog.Builder(this)
                .setTitle("Results")
                .setMessage("Score is " + score + " out of "+ numberOfQuestions)
                .setPositiveButton("Retake Quiz",((dialogInterface, i) -> restartQuiz()))
                .setCancelable(false)
                .show();
    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex = 0;
        questionNumberView.setText("Question " + (currentQuestionIndex + 1)+ " out of " + numberOfQuestions);
        setNewQuestion();
    }
}