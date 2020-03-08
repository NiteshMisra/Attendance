package com.attendance.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.attendance.model.Students;
import com.attendance.network.Api;
import com.attendance.network.RetrofitClient;
import com.attendance.response.AttendannceResponse;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AttendanceRepo {

    private Api api;

    public AttendanceRepo(){
        api = RetrofitClient.getInstance().getApi();
    }

    public LiveData<AttendannceResponse> postAttendance(String lectureId, ArrayList<Students> studentsList){

        final MutableLiveData<AttendannceResponse> liveData = new MutableLiveData<>();
        api.postAttendance(lectureId,studentsList).enqueue(new Callback<AttendannceResponse>() {
            @Override
            public void onResponse(@NotNull Call<AttendannceResponse> call, @NotNull Response<AttendannceResponse> response) {

                assert response.body() != null;
                if (response.isSuccessful() && response.body().getSuccessCode() == 200){
                    liveData.postValue(response.body());
                }else{
                    liveData.postValue(null);
                }
            }

            @Override
            public void onFailure(@NotNull Call<AttendannceResponse> call, @NotNull Throwable t) {
                liveData.postValue(null);
            }
        });
        return liveData;
    }

}
