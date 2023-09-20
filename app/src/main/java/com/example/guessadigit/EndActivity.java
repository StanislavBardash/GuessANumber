package com.example.guessadigit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EndActivity extends AppCompatActivity {
    int ans;
    TextView resultv;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_activity_layout);
        ans = getIntent().getIntExtra("ans", 0);
        resultv = findViewById(R.id.ending);
        resultv.setText("It was " + String.valueOf(ans));
        intent = new Intent(EndActivity.this, MainActivity.class);


    }

    public void goHome(View view) {
        startActivity(intent);
    }
}
