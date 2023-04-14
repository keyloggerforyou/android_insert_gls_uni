package com.example.crudone;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    EditText etvname,etvroll;
    Button btninsert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etvname = findViewById(R.id.etvname);
        etvroll = findViewById(R.id.etvroll);
        btninsert = findViewById(R.id.btninsert);

        dbhandler dbhandler = new dbhandler(this);
        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etvname.getText().toString();
                String roll = etvroll.getText().toString();
                dbhandler.insert(name,roll);

            }
        });
    }
}