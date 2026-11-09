package com.example.truefalsequiz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;

public class ResultActivity extends AppCompatActivity {
    TextView tvResult;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView( R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tvResult = findViewById(R.id.tvResult);
        TextView tvExplanation = findViewById(R.id.tvExplanation);

        String explanation = getIntent().getStringExtra("explanation");

        tvExplanation.setText(explanation);
        layout = findViewById(R.id.main);


        boolean isCorrect = getIntent().getBooleanExtra("isCorrect", false);

        if (isCorrect) {
            tvResult.setText("צדקת! גבינה יש רק בכדור בארץ...");
            layout.setBackgroundColor(getColor(R.color.result_correct));
        } else {
            tvResult.setText("טעית...הירח הוא מורכב מאבנים");
            layout.setBackgroundColor(getColor(R.color.result_wrong));
        }
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button btnNext = findViewById(R.id.btnNext);

        boolean hasNextQuestion =
                getIntent().getBooleanExtra("hasNextQuestion", false);

        if (hasNextQuestion) {
            btnNext.setVisibility(View.VISIBLE);
        } else {
            btnNext.setVisibility(View.GONE);
        }

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        ResultActivity.this,
                        Secondquestionactivity.class
                );

                startActivity(intent);
                finish();
            }
        });
    }
}