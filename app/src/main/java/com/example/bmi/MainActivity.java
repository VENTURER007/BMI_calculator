package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText height,weight;
        Button btn;
        TextView result;
        LinearLayout llmain;

        height = findViewById(R.id.editTextHeight);
        weight = findViewById(R.id.editTextWeight);
        result = findViewById(R.id.textViewResult);
        btn = findViewById(R.id.buttonCalculate);
        llmain = findViewById(R.id.llmain);
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float ht = Float.parseFloat(height.getText().toString());
                double wt = Float.parseFloat(weight.getText().toString());

                double bmi = wt / (ht * ht);


                if(bmi>25){
                    result.setText("You are overweight!");
                    String res = "You are overweight!";
                    intent.putExtra("value",res);
                    llmain.setBackgroundColor(getResources().getColor(R.color.OW));
                } else if (bmi < 18) {

                    result.setText("You are under weight!");
                    String res = "You are under weight!";
                    intent.putExtra("value",res);
                    llmain.setBackgroundColor(getResources().getColor(R.color.UW));

                }else{
                    result.setText("You are Healthy:)");
                    String res = "You are Healthy";
                    intent.putExtra("value",res);
                    llmain.setBackgroundColor(getResources().getColor(R.color.HW));
                }

                startActivity(intent);



//                new Handler().postDelayed(new Runnable() {
//
//                    @Override
//                    public void run() {
//
//
//                        startActivity(intent);
//                    }
//                },1000);


            }
        });






    }
}