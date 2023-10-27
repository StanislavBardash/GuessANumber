package com.example.guessadigit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.bound1);
        et2 = findViewById(R.id.bound2);
        et1.setText(String.valueOf(0));
        et2.setText(String.valueOf(10));

    }

    public void onClick(View view) {
        String str1 = et1.getText().toString();
        String str2 = et2.getText().toString();
        if (TextUtils.isEmpty(str1)) {
            et1.setError("You need to type a number!");
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            et2.setError("You need to type a number!");
            return;
        }
        int val1 = Integer.parseInt(str1);
        int val2 = Integer.parseInt(str2);
        if (val1 > val2) {
            et1.setError("First bound should be less than second one!");
            return;
        }
//        if (val2 - val1 <= 1 ){
//            et1.setError("There is no wished number that fits");
//            return;
//        }
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("bound1", val1);
        intent.putExtra("bound2", val2);
        startActivity(intent);
    }
}