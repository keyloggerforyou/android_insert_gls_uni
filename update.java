package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class update extends AppCompatActivity {

    private EditText etvname,etvroll,etvsub,etvmarks;
    private DBHandler dbHandler;
    Button btnupdate,btndelete,btndisplay;
    String name,roll,sub,marks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        etvname = findViewById(R.id.etvname);
        etvroll = findViewById(R.id.etvroll);
        etvsub = findViewById(R.id.etvsub);
        etvmarks = findViewById(R.id.etvmarks);
        btnupdate = findViewById(R.id.btnupdate);
        btndelete = findViewById(R.id.btndelete);
        btndisplay = findViewById(R.id.btndisplay);
        dbHandler = new DBHandler(update.this);

        name = getIntent().getStringExtra("name");
        roll = getIntent().getStringExtra("roll");
        sub = getIntent().getStringExtra("sub");
        marks = getIntent().getStringExtra("marks");

        etvname.setText(name);
        etvroll.setText(roll);
        etvsub.setText(sub);
        etvmarks.setText(marks);

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler.updatestudent(name, etvname.getText().toString(), etvroll.getText().toString(), etvsub.getText().toString(), etvmarks.getText().toString());
                Toast.makeText(update.this, "Record Updated..", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(update.this, display.class);
                startActivity(i);

            }
        });
        btndisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(update.this, display.class);
                startActivity(i);
            }
        });
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler.deletestudent(name);
                Toast.makeText(update.this, "Deleted the Name", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(update.this, display.class);
                startActivity(i);
            }
        });

    }
    }