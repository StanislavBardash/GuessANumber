package com.example.guessadigit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    int val1, val2;
    int start, middle, end;
    TextView tv1;
    Intent intent;
    int ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity_layout);
        intent = new Intent(SecondActivity.this, EndActivity.class);
        tv1 = findViewById(R.id.output);
        val1 = getIntent().getIntExtra("bound1", 0);
        val2 = getIntent().getIntExtra("bound2", 0);
        start = val1;
        end = val2;
        middle = (int)(val1+val2)/2;
        check_final("less");
        tv1.setText("Is it " + String.valueOf(middle) + "?");
    }
    public void check_final(String condition){
        if (end - start <= 2){
            if(condition.equals("less")){
                ans = start + 1;
            }
            else{
                ans = end - 1;
            }
            intent.putExtra("ans", ans);
            startActivity(intent);
        }
    }
    public void LessClick(View view) {
        end = middle;
        middle = (int)(start + end) /2;
        check_final("less");
        tv1.setText("Is it " + String.valueOf(middle) + "?");
    }

    public void BiggerClick(View view) {
        start = middle;
        middle = (int)(start + end) /2;
        check_final("more");
        tv1.setText("Is it " + String.valueOf(middle) + "?");
    }

    public void EqualsClick(View view) {
        intent.putExtra("ans", middle);
        startActivity(intent);
    }
}
