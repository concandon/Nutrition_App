package com.example.epsilonnutrition;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    EditText valTxt;
    EditText valTxt2;
    EditText valTxt3;
    EditText valTxt4;
    EditText valTxt5;
    EditText valTxt6;
    Spinner spinner;
    Spinner spinner2;
    String sex  = "";
    String activity = "";
    Button next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

//        spinner = (Spinner) findViewById(R.id.spinner);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.array, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(this);
//
//        spinner2 = (Spinner) findViewById(R.id.spinner2);
//        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.array2 , android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner2.setAdapter(adapter2);
//        spinner2.setOnItemSelectedListener(this);


        valTxt = (EditText) findViewById(R.id.editText);
        valTxt2 = (EditText) findViewById(R.id.editText2);
        valTxt3 = (EditText) findViewById(R.id.editText3);
        valTxt4 = (EditText) findViewById(R.id.editText4);
        valTxt5 = (EditText) findViewById(R.id.editText5);
        valTxt6 = (EditText) findViewById(R.id.editText6);


        next = (Button) findViewById(R.id.button);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fName = valTxt.getText().toString();
                String lName = valTxt2.getText().toString();
                int age = Integer.parseInt(valTxt3.getText().toString());
                int feet = Integer.parseInt(valTxt4.getText().toString());
                int inch = Integer.parseInt(valTxt5.getText().toString());
                double pound = Double.parseDouble(valTxt6.getText().toString());




                Intent startIntent = new Intent(FirstActivity.this, SecondActivity.class);
                startIntent.putExtra("key", fName);
                startIntent.putExtra("key2", lName);
                startIntent.putExtra("key3", age);
                startIntent.putExtra("key4", feet);
                startIntent.putExtra("key5", inch);
                startIntent.putExtra("key6", pound);
                startIntent.putExtra("key7", sex);
                startIntent.putExtra("key8", activity);
                startActivity(startIntent);
            }
        });
    }





    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
       if(text.equals("Male")||text.equals("Female"))
            sex = text;
        else
           activity = text;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }



}
