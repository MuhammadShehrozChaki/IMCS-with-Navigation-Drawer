package com.example.imcs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class TeacherHome extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[], s2[], s3[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_home);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView_teacher_list);

        String s1[], s2[], s3[];
        int image[]= {R.drawable.waseem,R.drawable.yasir,R.drawable.hira,R.drawable.hq,R.drawable.fida,R.drawable.gully,R.drawable.imtiaz,R.drawable.gafoor,R.drawable.buladi};

        s1= getResources().getStringArray(R.array.Teacher_Name);
        s2= getResources().getStringArray(R.array.Description);
        s3=getResources().getStringArray(R.array.dr);

        MyAdapter myAdapter=new MyAdapter(this, s1, s2,s3, image);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

