package com.attendance.network;

import com.attendance.model.Students;
import com.attendance.response.AttendannceResponse;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    @POST("api/v1/institute/attendance")
    @FormUrlEncoded
    Call<AttendannceResponse> postAttendance(
            @Field("lecture_id") String lectureId,
            @Field("students") List<Students> attendanceList
    );

}
