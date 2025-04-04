package com.example.randomquiz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup radioGroup;
    private RadioButton option1, option2, option3, option4;
    private Button submitButton;

    private List<Question> questionList;
    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.questionTextView);
        radioGroup = findViewById(R.id.radioGroup);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        submitButton = findViewById(R.id.submitButton);

        loadQuestions();
        Collections.shuffle(questionList); // Randomize questions
        displayQuestion();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void loadQuestions() {
        questionList = new ArrayList<>();

        questionList.add(new Question("What is the capital of Australia?",
                List.of("Canberra", "Sydney", "Melbourne", "Brisbane"), 0));

        questionList.add(new Question("Who discovered gravity?",
                List.of("Isaac Newton", "Albert Einstein", "Galileo Galilei", "Nikola Tesla"), 0));

        questionList.add(new Question("Which planet is known as the Red Planet?",
                List.of("Venus", "Mars", "Jupiter", "Saturn"), 1));

        questionList.add(new Question("How many bones are in the adult human body?",
                List.of("206", "208", "201", "215"), 0));

        questionList.add(new Question("What is the hardest natural substance on Earth?",
                List.of("Diamond", "Gold", "Iron", "Quartz"), 0));

        questionList.add(new Question("Which element has the chemical symbol 'O'?",
                List.of("Oxygen", "Osmium", "Oxalate", "Oganesson"), 0));

        questionList.add(new Question("What is the largest mammal on Earth?",
                List.of("Blue Whale", "Elephant", "Giraffe", "Great White Shark"), 0));
    }

    private void displayQuestion() {
        if (currentQuestionIndex < questionList.size()) {
            Question currentQuestion = questionList.get(currentQuestionIndex);
            questionTextView.setText(currentQuestion.getQuestion());
            option1.setText(currentQuestion.getOptions().get(0));
            option2.setText(currentQuestion.getOptions().get(1));
            option3.setText(currentQuestion.getOptions().get(2));
            option4.setText(currentQuestion.getOptions().get(3));
            radioGroup.clearCheck();
        } else {
            Toast.makeText(this, "Quiz Finished! Your score: " + score + "/" + questionList.size(), Toast.LENGTH_LONG).show();
            submitButton.setEnabled(false);
        }
    }

    private void checkAnswer() {
        int selectedOption = -1;
        if (option1.isChecked()) selectedOption = 0;
        else if (option2.isChecked()) selectedOption = 1;
        else if (option3.isChecked()) selectedOption = 2;
        else if (option4.isChecked()) selectedOption = 3;

        if (selectedOption == questionList.get(currentQuestionIndex).getCorrectAnswerIndex()) {
            score++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
        }

        currentQuestionIndex++;
        displayQuestion();
    }
}
