package com.example.epsilonnutrition;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Menu7Calculator1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Calls XML Layout File
        return inflater.inflate(R.layout.fragment_menu_7_sub_1, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Epsilon Nutrition - BMI Calculator");

        height1 = (EditText) getActivity().findViewById(R.id.height1);
        weight1 = (EditText) getActivity().findViewById(R.id.weight1);
        result1 = (TextView) getActivity().findViewById(R.id.result);


//        Button backButton1 = getActivity().findViewById(R.id.backButton1);
        Button calcButton = getActivity().findViewById(R.id.calc);
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI(v);
            }
        });
//        backButton1.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent in = new Intent(getActivity().getApplicationContext(),Menu7.class);
//                startActivity(in);
//            }
//        });


    }

    private EditText height1;
    private EditText weight1;
    private TextView result1;


    public void calculateBMI(View v) {

        String heightStr = height1.getText().toString();
        String weightStr = weight1.getText().toString();

        if (heightStr != null && !"".equals(heightStr)
                && weightStr != null  &&  !"".equals(weightStr)) {
            float heightValue = Float.parseFloat(heightStr);
            float weightValue = Float.parseFloat(weightStr);

            float bmi = 730 * weightValue / (heightValue * heightValue);

            displayBMI(bmi);
        }
    }

    private void displayBMI(float bmi) {
        String bmiLabel = "";

        bmiLabel = bmi + " is your BMI";
        result1.setText(bmiLabel);
    }
}








