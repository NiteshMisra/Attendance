package com.attendance.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.attendance.R;
import com.attendance.adapter.StudentAdapter;
import com.attendance.model.StudentModel;
import com.attendance.model.Students;
import com.attendance.response.AttendannceResponse;
import com.attendance.viewmodel.AttendanceViewModel;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {

    private AttendanceViewModel viewModel;
    public ArrayList<StudentModel> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewModel = ViewModelProviders.of(MainActivity.this).get(AttendanceViewModel.class);
        students = new ArrayList<>();

        students.add(new StudentModel("Kapil Dev",false,false,false));
        students.add(new StudentModel("Azhar",false,false,false));
        students.add(new StudentModel("Amit Mishra",false,false,false));
        students.add(new StudentModel("Virat Kohli",false,false,false));
        students.add(new StudentModel("Sachin Tendulkar",false,false,false));
        students.add(new StudentModel("Dhoni Singh",false,false,false));
        students.add(new StudentModel("Mahi Mar rha h",false,false,false));
        students.add(new StudentModel("Rohit Sharma",false,false,false));
        students.add(new StudentModel("Shikhar Dhawan",false,false,false));
        students.add(new StudentModel("Rishabh Pant",false,false,false));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setHasFixedSize(true);

        StudentAdapter studentAdapter = new StudentAdapter(students,MainActivity.this);
        recyclerView.setAdapter(studentAdapter);
        studentAdapter.notifyDataSetChanged();

        MaterialButton submitButton = findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitAttendance();
            }
        });

    }

    private void submitAttendance(){

        ArrayList<Students> studentsList = new ArrayList<>();

        int i =0;
        for (StudentModel item : students){
            if (item.isPresent()){
                studentsList.add(new Students(i,"present"));
                i++;
            }else if (item.isAbsent()){
                studentsList.add(new Students(i,"absent"));
                i++;
            }else {
                studentsList.add(new Students(i,"late"));
                i++;
            }
        }

        viewModel.post("14",studentsList).observe(MainActivity.this, new Observer<AttendannceResponse>() {
            @Override
            public void onChanged(AttendannceResponse attendannceResponse) {
                if (attendannceResponse != null){
                    Toast.makeText(MainActivity.this,attendannceResponse.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
