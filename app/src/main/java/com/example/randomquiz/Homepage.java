package com.example.randomquiz;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Homepage extends AppCompatActivity {
    private TextView questionTextView;
    private RadioGroup radioGroup;
    private RadioButton option1, option2, option3, option4;
    private Button submitButton;

    private List<Question> questionList;
    private int currentQuestionIndex = 0;
    private int score = 0;

    int totalQuestions = 5;

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
        Collections.shuffle(questionList);
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

        questionList.add(new Question("Which ocean is the largest?",
                List.of("Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"), 3));

        questionList.add(new Question("Who painted the Mona Lisa?",
                List.of("Vincent Van Gogh", "Pablo Picasso", "Leonardo da Vinci", "Claude Monet"), 2));

        questionList.add(new Question("What is the boiling point of water in Celsius?",
                List.of("90°C", "100°C", "110°C", "120°C"), 1));

    questionList.add(new Question("Which gas do plants use for photosynthesis?",
               List.of("Oxygen", "Carbon Dioxide", "Nitrogen", "Hydrogen"), 1));

        questionList.add(new Question("What is the longest river in the world?",
                List.of("Amazon River", "Nile River", "Mississippi River", "Yangtze River"), 1));

        questionList.add(new Question("Who wrote 'Romeo and Juliet'?",
                List.of("Charles Dickens", "William Shakespeare", "Mark Twain", "Jane Austen"), 1));
        questionList.add(new Question("What is the largest desert in the world?",
                List.of("Sahara Desert", "Antarctica", "Gobi Desert", "Kalahari Desert"), 1));

        questionList.add(new Question("Which country is famous for the Eiffel Tower?",
                List.of("Italy", "Spain", "France", "Germany"), 2));

        questionList.add(new Question("What is the fastest land animal?",
                List.of("Lion", "Cheetah", "Tiger", "Jaguar"), 1));

        questionList.add(new Question("Which animal is known as the 'Ship of the Desert'?",
                List.of("Elephant", "Horse", "Camel", "Donkey"), 2));

        questionList.add(new Question("How many continents are there on Earth?",
                List.of("5", "6", "7", "8"), 2));

        questionList.add(new Question("What is the smallest country in the world?",
                List.of("Monaco", "Vatican City", "Malta", "Liechtenstein"), 1));
        questionList.add(new Question("Which is the longest mountain range in the world?",
                List.of("Rocky Mountains", "Andes Mountains", "Himalayas", "Alps"), 1));
        questionList.add(new Question("What is the capital of France?",
                List.of(new String[]{"Berlin", "Madrid", "Paris", "Rome"}), 2));
       // questionList.add(new Question("Which gas do plants absorb?",
    //            List.of(new String[]{"Oxygen", "Carbon Dioxide", "Nitrogen", "Helium"}), 1));
  //      questionList.add(new Question("Who wrote 'Hamlet'?",
//                List.of(new String[]{"Charles Dickens", "Leo Tolstoy", "Shakespeare", "Mark Twain"}), 2));
//        questionList.add(new Question("Which planet is closest to the sun?",
//                List.of(new String[]{"Venus", "Mercury", "Earth", "Mars"}), 1));
//        questionList.add(new Question("What is the square root of 64?",
//                List.of(new String[]{"6", "8", "7", "9"}), 1));
//        questionList.add(new Question("In Android, what file contains the app permissions?",
//                List.of(new String[]{"build.gradle", "strings.xml", "MainActivity.java", "AndroidManifest.xml"}), 3));
//        questionList.add(new Question("What is the largest mammal?",
//                List.of(new String[]{"Elephant", "Giraffe", "Blue Whale", "Hippopotamus"}), 2));
//        questionList.add(new Question("Which language is used to style web pages?",
//                List.of(new String[]{"HTML", "Python", "CSS", "Java"}), 2));
//        questionList.add(new Question("What is H2O commonly known as?", List.of(new String[]{"Salt", "Oxygen", "Hydrogen", "Water"}), 3));
//        questionList.add(new Question("What is the main ingredient in guacamole?",
//                List.of(new String[]{"Lettuce", "Tomato", "Avocado", "Pepper"}), 2));
//        questionList.add(new Question("What is the powerhouse of the cell?",
//                List.of(new String[]{"Nucleus", "Mitochondria", "Ribosome", "Chloroplast"}), 1));
//        questionList.add(new Question("What is the capital city of Australia?",
//                List.of(new String[]{"Sydney", "Melbourne", "Canberra", "Perth"}), 2));
//        questionList.add(new Question("Which planet has rings?",
//                List.of(new String[]{"Earth", "Mars", "Saturn", "Venus"}), 2));
//        questionList.add(new Question("What year did man land on the moon?",
//                List.of(new String[]{"1965", "1969", "1972", "1959"}), 1));
//        questionList.add(new Question("Which organ pumps blood throughout the human body?",
//                List.of(new String[]{"Brain", "Liver", "Lungs", "Heart"}), 3));
//        questionList.add(new Question("What does HTTP stand for?",
//                List.of(new String[]{"HyperText Transfer Protocol", "HighText Transfer Protocol", "Hyperloop Transfer Protocol", "None"}), 0));
//        questionList.add(new Question("Which country invented tea?",
//                List.of(new String[]{"India", "China", "Japan", "England"}), 1));
//        questionList.add(new Question("What is Java primarily used for in Android?",
//                List.of(new String[]{"Web Design", "Operating Systems", "App Development", "Game Consoles"}), 2));
//        questionList.add(new Question("What color are the stars in the U.S. flag?",
//                List.of(new String[]{"Red", "Blue", "White", "Yellow"}), 2));
//        questionList.add(new Question("Which instrument has 88 keys?",
//                List.of(new String[]{"Guitar", "Flute", "Piano", "Saxophone"}), 2));
//        questionList.add(new Question("Which planet is known for its red appearance?",
//                List.of(new String[]{"Jupiter", "Mars", "Venus", "Saturn"}), 1));
//        questionList.add(new Question("In which country is the Great Pyramid of Giza?",
//                List.of(new String[]{"Mexico", "Iraq", "India", "Egypt"}), 3));
    }

    Button playBtn;


    @SuppressLint("MissingInflatedId")
    protected void onCreate2(Bundle savedInstanceState1) {
        Bundle savedInstanceState2 = null;
        super.onCreate(null);
        setContentView(R.layout.activity_main);

        playBtn = findViewById(R.id.playBtn);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Homepage.this, "Quiz Starting...", Toast.LENGTH_SHORT).show();
            }
        });
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

        if (selectedOption == -1) {
            Toast.makeText(this, "Please select an answer!", Toast.LENGTH_SHORT).show();
            return;
        }

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