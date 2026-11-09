package com.example.truefalsequiz;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class Secondquestionactivity extends AppCompatActivity {
    boolean correctAnswer = true;
    String explanation = "yes, the earth is indeed a round shape";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_secondquestionactivity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnTrue = findViewById(R.id.btnTrue);
        Button btnFalse = findViewById(R.id.btnFalse);

        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean userAnswer = true;

                boolean isCorrect;
                if (userAnswer == correctAnswer) {
                    isCorrect = true;
                } else {
                    isCorrect = false;
                }

                Intent intent = new Intent(
                        Secondquestionactivity.this,
                        ResultActivity.class
                );

                intent.putExtra("isCorrect", isCorrect);
                intent.putExtra("explanation", explanation);
                intent.putExtra("hasNextQuestion", false);

                startActivity(intent);
            }
        });

        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean userAnswer = false;

                boolean isCorrect;
                if (userAnswer == correctAnswer) {
                    isCorrect = true;
                } else {
                    isCorrect = false;
                }

                Intent intent = new Intent(
                        Secondquestionactivity.this,
                        ResultActivity.class
                );

                intent.putExtra("isCorrect", isCorrect);
                intent.putExtra("explanation", explanation);
                intent.putExtra("hasNextQuestion", false);

                startActivity(intent);
            }
        });
    }
}