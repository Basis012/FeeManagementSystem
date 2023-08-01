package com.dodo.feemanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;

public class StaffHome extends AppCompatActivity {

    AppCompatImageView LogOut;
    MaterialButton insertfee, markattendence, viewstudent;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_home);

        LogOut=findViewById(R.id.LogOut);
        getSupportActionBar().hide();
    insertfee = findViewById(R.id.insertfee);
        markattendence = findViewById(R.id.markattendence);
       viewstudent = findViewById(R.id.viewstudent);
       insertfee.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
             Intent i = new Intent(StaffHome.this,InsertFee.class);
             startActivity(i);
           }
       });
       markattendence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MarkAttendence.class));
            }
        });
      viewstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ViewStudent.class));
            }
        });
        LogOut();

    }

    public void LogOut(){
        FirebaseAuth.getInstance().signOut();
        LogOut.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), MainActivity.class)) );}
}