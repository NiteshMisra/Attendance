package com.attendance.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.attendance.R;
import com.attendance.activity.MainActivity;
import com.attendance.model.StudentModel;
import com.attendance.model.Students;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private ArrayList<StudentModel> studentList;
    private MainActivity mainActivity;

    public StudentAdapter(ArrayList<StudentModel> studentModels, MainActivity mainActivity) {
        this.studentList = studentModels;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        final StudentModel uploadCurrent = studentList.get(position);
        holder.studentName.setText((position + 1) + ".)  " + uploadCurrent.getStudentName());
        holder.present.setChecked(uploadCurrent.isPresent());
        holder.absent.setChecked(uploadCurrent.isAbsent());
        holder.late.setChecked(uploadCurrent.isLate());

        if (position%2 != 0){
            holder.layout.setBackgroundColor(Color.parseColor("#F0F0F0"));
        }else{
            holder.layout.setBackgroundColor(Color.parseColor("#FCFCFC"));
        }

        holder.present.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mainActivity.students.get(position).setPresent(isChecked);
                if (holder.absent.isChecked()){
                    mainActivity.students.get(position).setAbsent(false);
                    holder.absent.setChecked(false);
                }
                if (holder.late.isChecked()){
                    mainActivity.students.get(position).setLate(false);
                    holder.late.setChecked(false);
                }
                holder.present.setChecked(isChecked);

            }
        });

        holder.absent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mainActivity.students.get(position).setAbsent(isChecked);
                if (holder.present.isChecked()){
                    mainActivity.students.get(position).setPresent(false);
                    holder.present.setChecked(false);
                }
                if (holder.late.isChecked()){
                    mainActivity.students.get(position).setLate(false);
                    holder.late.setChecked(false);
                }
                holder.absent.setChecked(isChecked);
            }
        });

        holder.late.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mainActivity.students.get(position).setLate(isChecked);
                if (holder.present.isChecked()){
                    mainActivity.students.get(position).setPresent(false);
                    holder.present.setChecked(false);
                }
                if (holder.absent.isChecked()){
                    mainActivity.students.get(position).setAbsent(false);
                    holder.absent.setChecked(false);
                }
                holder.late.setChecked(isChecked);
            }
        });

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView studentName;
        CheckBox present,absent,late;
        ConstraintLayout layout;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            studentName = itemView.findViewById(R.id.student_name);
            present = itemView.findViewById(R.id.present);
            absent = itemView.findViewById(R.id.absent);
            late = itemView.findViewById(R.id.late);
            layout = itemView.findViewById(R.id.item_layout);
        }
    }

}
