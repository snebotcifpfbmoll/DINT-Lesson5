package com.serafinebot.dint.truefalse;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.serafinebot.dint.truefalse.data.Question;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Question> questions = new ArrayList<>();
    TextView questionView = null;
    Button falseBtn = null;
    Button trueBtn = null;
    Button prevBtn = null;
    Button nextBtn = null;
    int currentQuestion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // fill questions
        questions.add(new Question("Spain is part of Europe.", true));
        questions.add(new Question("Americans have the best measurement system.", false));
        questions.add(new Question("There are only 3 continents.", false));
        questions.add(new Question("If you heat water at 100ºC it boils.", true));
        questions.add(new Question("The metric system is the best.", true));
        questions.add(new Question("Russia is the largest country.", true));

        questionView = findViewById(R.id.question);
        falseBtn = findViewById(R.id.false_button);
        trueBtn = findViewById(R.id.true_button);
        prevBtn = findViewById(R.id.previous_button);
        nextBtn = findViewById(R.id.next_button);

        falseBtn.setOnClickListener(this);
        trueBtn.setOnClickListener(this);
        prevBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);

        question(0);
    }

    public void onClick(View v) {
        if (v == falseBtn) {
            checkQuestion(false);
        } else if (v == trueBtn) {
            checkQuestion(true);
        } else if (v == prevBtn) {
            question(-1);
        } else if (v == nextBtn) {
            question(1);
        }
    }

    public void checkQuestion(boolean answer) {
        String result = questions.get(currentQuestion).answer() == answer ? "Correct" : "Incorrect";
        Toast msg = Toast.makeText(this, result, Toast.LENGTH_LONG);
        msg.show();
    }

    public void question(int inc) {
        int nextQuestion = currentQuestion + inc;
        if (nextQuestion >= 0 && nextQuestion < questions.size()) {
            currentQuestion = nextQuestion;
            questionView.setText(questions.get(currentQuestion).getQuestion());
        }

        prevBtn.setEnabled(currentQuestion > 0);
        nextBtn.setEnabled(currentQuestion < questions.size() - 1);
    }
}