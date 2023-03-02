package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float ht = Float.parseFloat(height.getText().toString());
                double wt = Float.parseFloat(weight.getText().toString());

                double bmi = wt / (ht * ht);


                if(bmi>25){
                    result.setText("You are overweight!");
                    llmain.setBackgroundColor(getResources().getColor(R.color.OW));
                } else if (bmi < 18) {

                    result.setText("You are under weight!");
                    llmain.setBackgroundColor(getResources().getColor(R.color.UW));

                }else{
                    result.setText("You are Healthy:)");
                    llmain.setBackgroundColor(getResources().getColor(R.color.HW));
                }
            }
        });






    }
}