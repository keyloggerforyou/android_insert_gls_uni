package com.example.crud;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class display extends AppCompatActivity {

    private ArrayList<StudentModal> StudentModalArrayList;
    private DBHandler dbHandler;
    private StudentRVAdapter StudentRVAdapter;
    private RecyclerView StudentRV;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        StudentModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(display.this);
        StudentModalArrayList = dbHandler.readstudent();
        StudentRVAdapter = new StudentRVAdapter(StudentModalArrayList,display.this);
        StudentRV = findViewById(R.id.tvstudentdetails);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(display.this, RecyclerView.VERTICAL, false);
        StudentRV.setLayoutManager(linearLayoutManager);
        StudentRV.setAdapter(StudentRVAdapter);
    }
}
