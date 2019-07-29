package com.example.epsilonnutrition;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;


public class SecondActivity extends AppCompatActivity {

    EditText datareceived;
    String filename = "myfile";
    FileOutputStream outputStream;
    Button next2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        Intent localIntent = getIntent();

       final String fname = localIntent.getStringExtra("key");
       final String lname = localIntent.getStringExtra("key2");
       final int age = localIntent.getIntExtra("key3", -1);
       final int feet = localIntent.getIntExtra("key4", -1);
       final int inch = localIntent.getIntExtra("key5", -1);
       final double weight = localIntent.getDoubleExtra("key6", -1);
       final String sex = localIntent.getStringExtra("key7");
       final String activity = localIntent.getStringExtra("key8");
       final double bmi = BMI(weight, feet, inch);
       final double bmr = BMR(weight, feet, inch, age, sex);
       final double tdee = TDEE(activity, bmr);
       String a;
       String b;
       String c;
       String d;

        datareceived = (EditText) findViewById(R.id.editText7);
        datareceived.setText(fname);
        datareceived = (EditText) findViewById(R.id.editText8);
        datareceived.setText(lname);
        datareceived = (EditText) findViewById(R.id.editText9);
        datareceived.setText(a = "Age: " + Integer.toString(age));
        datareceived = (EditText) findViewById(R.id.editText10);
        datareceived.setText("Sex: " + sex);
        datareceived = (EditText) findViewById(R.id.editText11);
        datareceived.setText(a = "Height: " + Integer.toString(feet) + " feet and");
        datareceived = (EditText) findViewById(R.id.editText12);
        datareceived.setText(a = Integer.toString(inch) + " inches");
        datareceived = (EditText) findViewById(R.id.editText13);
        a = Double.toString(weight);
        datareceived.setText(String.format("Weight: %.2f", weight));
        datareceived = (EditText) findViewById(R.id.editText14);
        datareceived.setText("Physical activity level: " + activity);
        datareceived = (EditText) findViewById(R.id.editText15);
        b = Double.toString(bmi);
        datareceived.setText(String.format("Your BMI: %.2f", bmi));
        datareceived = (EditText) findViewById(R.id.editText16);
        c = Double.toString(bmr);
        datareceived.setText(String.format("Your BMR: %.2f", bmr));
        datareceived = (EditText) findViewById(R.id.editText17);
        d = Double.toString(tdee);
        datareceived.setText(String.format("Your TDEE: %.2f", tdee));

        next2 = (Button) findViewById(R.id.button2);

        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent startIntent = new Intent(SecondActivity.this, ForthActivity.class);


                String[] array = new String[11];

                try {
                    outputStream = openFileOutput(filename, Context.MODE_APPEND);
                    for (String s : array) {
                        outputStream.write(s.getBytes());
                    }
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }


                array[0] = fname;
                array[1] = lname;
                array[2] = String.valueOf(age);
                array[3] = String.valueOf(feet);
                array[4] = String.valueOf(inch);
                array[5] = String.valueOf(weight);
                array[6] = sex;
                array[7] = activity;
                array[8] = String.valueOf(bmi);
                array[9] = String.valueOf(bmr);
                array[10] = String.valueOf(tdee);
                startIntent.putExtra("key9", array);
                startIntent.putExtra("key10", filename);
                startActivity(startIntent);
            }
        });
    }







    public double BMI(Double weight,int feet, int inch ) {
        double bmi = 0.0;
        bmi = (feet* 12 + inch);
        bmi *= bmi;
        bmi = weight / bmi * 703;

        return bmi;
    }

    public double BMR(Double weight,int feet, int inch, int age, String sex) {
        double bmr = 0.0;
        bmr = (feet* 12 + inch);
        if(sex.equals("Female"))
            bmr =  655 + (4.35 * weight) + (4.7 * bmr) - (4.7 * age) ;
        else
            bmr =  66 + (6.23 * weight) + (12.7 * bmr) - (6.8 * age) ;
        return bmr;
    }

    public double TDEE(String activity, Double bmr) {

        double tdee =0.00;
        if (activity.equals("Sedentary"))
            tdee = bmr * 1.2;
        else if(activity.equals("Lightly Active"))
            tdee = bmr * 1.375;
        else if(activity.equals("Moderately Active"))
            tdee = bmr * 1.55;
        else if(activity.equals("Very Active"))
            tdee = bmr * 1.725;
        else
            tdee = bmr * 1.9;

        return tdee;
    }


}
