package com.attendance.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.attendance.model.Students;
import com.attendance.repository.AttendanceRepo;
import com.attendance.response.AttendannceResponse;
import java.util.ArrayList;

public class AttendanceViewModel extends ViewModel {

    private AttendanceRepo repository;

    public AttendanceViewModel(){
        repository = new AttendanceRepo();
    }

    public LiveData<AttendannceResponse> post(String lectureId, ArrayList<Students> studentsList){
        return repository.postAttendance(lectureId,studentsList);
    }

}
