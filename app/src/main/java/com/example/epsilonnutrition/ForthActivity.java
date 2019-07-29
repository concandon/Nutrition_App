package com.example.epsilonnutrition;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ForthActivity extends AppCompatActivity {


    EditText   display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth);

        display = (EditText) findViewById(R.id.editText18);
        Intent localIntent = getIntent();
        String filename = localIntent.getStringExtra("key9");
        String[] lname = localIntent.getStringArrayExtra("key10");
        File file = new File(filename);

        StringBuilder txt  = new StringBuilder();

        try {
            BufferedReader buffer = new BufferedReader (new FileReader(file));
            String line;

            while((line = buffer.readLine()) != null) {
                String screen = buffer.readLine().toString();
                display.setText(screen);
            }
            buffer.close();
        }
        catch (IOException e) {
            System.exit(0);
        }
    }
}
