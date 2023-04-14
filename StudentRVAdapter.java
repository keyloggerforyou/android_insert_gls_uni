package com.example.crud;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class StudentRVAdapter extends RecyclerView.Adapter<StudentRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<StudentModal> StudentModalArrayList;
    private Context context;

    // constructor
    public StudentRVAdapter(ArrayList<StudentModal> StudentModalArrayList, Context context) {
        this.StudentModalArrayList = StudentModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        StudentModal modal = StudentModalArrayList.get(position);
        holder.name.setText(modal.getName());
        holder.roll.setText(modal.getRoll());
        holder.sub.setText(modal.getSub());
        holder.marks.setText(modal.getMarks());

        // below line is to add on click listener for our recycler view item.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // on below line we are calling an intent.
                Intent i = new Intent(context, update.class);

                // below we are passing all our values.
                i.putExtra("name", modal.getName());
                i.putExtra("roll", modal.getRoll());
                i.putExtra("sub", modal.getSub());
                i.putExtra("marks", modal.getMarks());

                // starting our activity.
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return StudentModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView name,roll,sub,marks;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            name = itemView.findViewById(R.id.tvname);
            roll = itemView.findViewById(R.id.tvroll);
            sub = itemView.findViewById(R.id.tvsub);
            marks = itemView.findViewById(R.id.tvmarks);
        }
    }
}



