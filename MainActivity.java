package com.example.crud;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText etvname,etvroll,etvsub,etvmarks;
    Button btninsert,btndisplay;
    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etvname = findViewById(R.id.etvname);
        etvroll = findViewById(R.id.etvroll);
        etvsub = findViewById(R.id.etvsub);
        etvmarks = findViewById(R.id.etvmarks);
        btninsert = findViewById(R.id.btninsert);
        btndisplay = findViewById(R.id.btndisplay);
        dbHandler = new DBHandler(MainActivity.this);
        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etvname.getText().toString();
                String roll = etvroll.getText().toString();
                String sub = etvsub.getText().toString();
                String marks = etvmarks.getText().toString();

                // validating if the text fields are empty or not.
                if (name.isEmpty() || roll.isEmpty() || sub.isEmpty() || marks.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }
                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewStudent(name,roll, sub, marks);
                // after adding the data we are displaying a toast message.
                Toast.makeText(MainActivity.this, "Record has been added.", Toast.LENGTH_SHORT).show();
                etvname.setText("");
                etvroll.setText("");
                etvsub.setText("");
                etvmarks.setText("");
            }
        });
        btndisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,display.class);
                startActivity(i);
            }
        });
    }
}